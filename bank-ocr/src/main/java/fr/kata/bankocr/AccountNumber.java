package fr.kata.bankocr;

import com.sun.deploy.util.StringUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AccountNumber {

    private static final int NUMBER_OF_DIGITS = 9;
    static final String ILLEGIBLE_SUFFIX = " ILL";
    static final String ERROR_SUFFIX = " ERR";
    static final String AMB = " AMB ";

    private List<Digit> digits;

    private AccountNumber(List<Digit> digits) {
        if (digits.size() != NUMBER_OF_DIGITS) {
            throw new IllegalArgumentException("Invalid number of digits");
        }

        this.digits = digits;
    }

    public List<Digit> getDigits() {
        return digits;
    }

    public int checksum() {
        int checksum = 0;

        for (int i = NUMBER_OF_DIGITS; i > 0; i--) {
            checksum += i * digits.get(NUMBER_OF_DIGITS - i).getValueAsInt();
        }

        return checksum;
    }

    public boolean isValid() {
        return checksum() % 11 == 0;
    }

    public boolean hasIllegible() {
        return digits.contains(Digit.UNKNOWN);
    }

    public String getSuffix() {
        String suffix = "";

        if (hasIllegible()) {
            suffix = ILLEGIBLE_SUFFIX;
        } else if (!isValid()) {
            suffix = ERROR_SUFFIX;
        }

        return suffix;
    }

    public List<AccountNumber> findAlternatives() {
        List<AccountNumber> alternativeAccountNumbers = new ArrayList<>();

        if (!isValid()) {
            for (int i = 0; i < digits.size(); i++) {
                for (Digit alternativeDigit : digits.get(i).findAlternatives()) {
                    List<Digit> alternativeDigits = new ArrayList<>(digits);
                    alternativeDigits.set(i, alternativeDigit);
                    AccountNumber an = new AccountNumber(alternativeDigits);
                    alternativeAccountNumbers.add(an);
                }
            }
        }

        return alternativeAccountNumbers;
    }

    public List<AccountNumber> findValidAlternatives() {
        return findAlternatives().stream()
                .filter(AccountNumber::isValid)
                .collect(Collectors.toList());
    }

    public static AccountNumber from(Path path) {
        return new AccountNumber(DigitsReader.readDigits(path, NUMBER_OF_DIGITS));
    }

    public static AccountNumber from(String digitsAsString) {
        return new AccountNumber(
                IntStream.range(0, NUMBER_OF_DIGITS)
                        .mapToObj(digitsAsString::charAt)
                        .map(Digit::of)
                        .collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        if (hasIllegible()) {
            return toStringWithSuffix();
        }

        List<AccountNumber> alternatives = findValidAlternatives();

        if (!isValid() && alternatives.size() == 1) {
            return alternatives.get(0).toStringWithoutSuffix();
        }

        if (!isValid() && alternatives.size() > 1) {
            return toStringWithoutSuffix() + AMB + toStringWithAlternatives();
        }

        return toStringWithSuffix();
    }

    private String toStringWithoutSuffix() {
        return digits.stream()
                .map(Digit::getValue)
                .collect(Collectors.joining());
    }

    private String toStringWithSuffix() {
        return toStringWithoutSuffix() + getSuffix();
    }

    private String toStringWithAlternatives() {
        return "[" + StringUtils.join(findValidAlternatives().stream()
                        .map(accountNumber -> "'" + accountNumber.toStringWithoutSuffix() + "'")
                        .sorted()
                        .collect(Collectors.toList())
                , ", ") + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountNumber that = (AccountNumber) o;

        return digits.equals(that.digits);
    }

    @Override
    public int hashCode() {
        return digits.hashCode();
    }
}
