package fr.kata.bankocr;

import com.sun.deploy.util.StringUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AccountNumber {

    private static final int NUMBER_OF_DIGITS = 9;

    private List<Digit> digits;

    AccountNumber(Path path) {
        this.digits = DigitsReader.readDigits(path, NUMBER_OF_DIGITS);
    }

    private AccountNumber(List<Digit> digits) {
        this.digits = digits;
    }

    private boolean allPerfectMatch() {
        return digits.stream().allMatch(digit -> digit.getPerfectMatch() != null);
    }

    private boolean isAcceptable() {
        return allPerfectMatch() && isValid();
    }

    private boolean isValid() {
        return checksum() % 11 == 0;
    }

    private int checksum() {
        int checksum = 0;

        for (int i = NUMBER_OF_DIGITS; i > 0; i--) {
            checksum += i * digits.get(NUMBER_OF_DIGITS - i).getPerfectMatch().toInt();
        }

        return checksum;
    }

    private List<AccountNumber> findAlternatives() {
        List<AccountNumber> alternativeAccountNumbers = new ArrayList<>();

        if (!isAcceptable()) {
            for (int i = 0; i < digits.size(); i++) {
                for (DigitValue alternativeDigitValue : digits.get(i).getPotentielMatches()) {
                    List<Digit> alternativeDigits = new ArrayList<>(digits);
                    alternativeDigits.set(i, new Digit(alternativeDigitValue));
                    AccountNumber an = new AccountNumber(alternativeDigits);
                    alternativeAccountNumbers.add(an);
                }
            }
        }

        return alternativeAccountNumbers;
    }

    private List<AccountNumber> findValidAlternatives() {
        return findAlternatives().stream()
                .filter(AccountNumber::isAcceptable)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        if (isAcceptable()) return validToString();

        List<AccountNumber> validAlternatives = findValidAlternatives();
        if (validAlternatives.size() > 1) return manyAlternativeToString(validAlternatives);
        if (validAlternatives.size() == 1) return oneAlternativeToString(validAlternatives.get(0));
        else return noAlternativeToString();
    }

    String partialToString() {
        return digits.stream()
                .map(Digit::toString)
                .collect(Collectors.joining());
    }

    private String validToString() {
        return digits.stream().map(Digit::toString).collect(Collectors.joining());
    }

    private String manyAlternativeToString(List<AccountNumber> alternatives) {
        return partialToString() + " AMB [" + StringUtils.join(alternatives.stream()
                        .map(accountNumber -> "'" + accountNumber.toString() + "'")
                        .sorted()
                        .collect(Collectors.toList())
                , ", ") + "]";
    }

    private String oneAlternativeToString(AccountNumber alternative) {
        return alternative.toString();
    }

    private String noAlternativeToString() {
        if (!allPerfectMatch()) return partialToString() + " ILL";
        else return partialToString() + " ERR";
    }
}
