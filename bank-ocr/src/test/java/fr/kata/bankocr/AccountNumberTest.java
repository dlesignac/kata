package fr.kata.bankocr;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountNumberTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void from_unexisting_file_should_throw_illegal_argument_exception() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("No such file : ");
        AccountNumber.from(Paths.get("src/test/resources/test_unexisting"));
    }

    @Test
    public void from_file_with_invalid_content_should_throw_illegal_argument_exception() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Invalid input file content");
        AccountNumber.from(Paths.get("src/test/resources/test_empty"));
    }

    @Test
    public void from_test_000000000_should_get_value() {
        AccountNumber accountNumber = AccountNumber.from(Paths.get("src/test/resources/test_000000000"));
        assertThat(accountNumber.getDigits()).isEqualTo(Arrays.asList(
                Digit.ZERO,
                Digit.ZERO,
                Digit.ZERO,
                Digit.ZERO,
                Digit.ZERO,
                Digit.ZERO,
                Digit.ZERO,
                Digit.ZERO,
                Digit.ZERO
        ));
    }

    @Test
    public void from_test_111111111_should_get_value() {
        AccountNumber accountNumber = AccountNumber.from(Paths.get("src/test/resources/test_111111111"));
        assertThat(accountNumber.getDigits()).isEqualTo(Arrays.asList(
                Digit.ONE,
                Digit.ONE,
                Digit.ONE,
                Digit.ONE,
                Digit.ONE,
                Digit.ONE,
                Digit.ONE,
                Digit.ONE,
                Digit.ONE
        ));
    }

    @Test
    public void from_test_222222222_should_get_value() {
        AccountNumber accountNumber = AccountNumber.from(Paths.get("src/test/resources/test_222222222"));
        assertThat(accountNumber.getDigits()).isEqualTo(Arrays.asList(
                Digit.TWO,
                Digit.TWO,
                Digit.TWO,
                Digit.TWO,
                Digit.TWO,
                Digit.TWO,
                Digit.TWO,
                Digit.TWO,
                Digit.TWO
        ));
    }

    @Test
    public void from_test_333333333_should_get_value() {
        AccountNumber accountNumber = AccountNumber.from(Paths.get("src/test/resources/test_333333333"));
        assertThat(accountNumber.getDigits()).isEqualTo(Arrays.asList(
                Digit.THREE,
                Digit.THREE,
                Digit.THREE,
                Digit.THREE,
                Digit.THREE,
                Digit.THREE,
                Digit.THREE,
                Digit.THREE,
                Digit.THREE
        ));
    }

    @Test
    public void from_test_444444444_should_get_value() {
        AccountNumber accountNumber = AccountNumber.from(Paths.get("src/test/resources/test_444444444"));
        assertThat(accountNumber.getDigits()).isEqualTo(Arrays.asList(
                Digit.FOUR,
                Digit.FOUR,
                Digit.FOUR,
                Digit.FOUR,
                Digit.FOUR,
                Digit.FOUR,
                Digit.FOUR,
                Digit.FOUR,
                Digit.FOUR
        ));
    }

    @Test
    public void from_test_555555555_should_get_value() {
        AccountNumber accountNumber = AccountNumber.from(Paths.get("src/test/resources/test_555555555"));
        assertThat(accountNumber.getDigits()).isEqualTo(Arrays.asList(
                Digit.FIVE,
                Digit.FIVE,
                Digit.FIVE,
                Digit.FIVE,
                Digit.FIVE,
                Digit.FIVE,
                Digit.FIVE,
                Digit.FIVE,
                Digit.FIVE
        ));
    }

    @Test
    public void from_test_666666666_should_get_value() {
        AccountNumber accountNumber = AccountNumber.from(Paths.get("src/test/resources/test_666666666"));
        assertThat(accountNumber.getDigits()).isEqualTo(Arrays.asList(
                Digit.SIX,
                Digit.SIX,
                Digit.SIX,
                Digit.SIX,
                Digit.SIX,
                Digit.SIX,
                Digit.SIX,
                Digit.SIX,
                Digit.SIX
        ));
    }

    @Test
    public void from_test_777777777_should_get_value() {
        AccountNumber accountNumber = AccountNumber.from(Paths.get("src/test/resources/test_777777777"));
        assertThat(accountNumber.getDigits()).isEqualTo(Arrays.asList(
                Digit.SEVEN,
                Digit.SEVEN,
                Digit.SEVEN,
                Digit.SEVEN,
                Digit.SEVEN,
                Digit.SEVEN,
                Digit.SEVEN,
                Digit.SEVEN,
                Digit.SEVEN
        ));
    }

    @Test
    public void from_test_888888888_should_get_value() {
        AccountNumber accountNumber = AccountNumber.from(Paths.get("src/test/resources/test_888888888"));
        assertThat(accountNumber.getDigits()).isEqualTo(Arrays.asList(
                Digit.EIGHT,
                Digit.EIGHT,
                Digit.EIGHT,
                Digit.EIGHT,
                Digit.EIGHT,
                Digit.EIGHT,
                Digit.EIGHT,
                Digit.EIGHT,
                Digit.EIGHT
        ));
    }

    @Test
    public void from_test_999999999_should_get_value() {
        AccountNumber accountNumber = AccountNumber.from(Paths.get("src/test/resources/test_999999999"));
        assertThat(accountNumber.getDigits()).isEqualTo(Arrays.asList(
                Digit.NINE,
                Digit.NINE,
                Digit.NINE,
                Digit.NINE,
                Digit.NINE,
                Digit.NINE,
                Digit.NINE,
                Digit.NINE,
                Digit.NINE
        ));
    }

    @Test
    public void from_test_123456789_should_get_value() {
        AccountNumber accountNumber = AccountNumber.from(Paths.get("src/test/resources/test_123456789"));
        assertThat(accountNumber.getDigits()).isEqualTo(Arrays.asList(
                Digit.ONE,
                Digit.TWO,
                Digit.THREE,
                Digit.FOUR,
                Digit.FIVE,
                Digit.SIX,
                Digit.SEVEN,
                Digit.EIGHT,
                Digit.NINE
        ));
    }

    @Test
    public void from_string_123456789_should_get_value() {
        AccountNumber accountNumber = AccountNumber.from("123456789");
        assertThat(accountNumber.getDigits()).isEqualTo(Arrays.asList(
                Digit.ONE,
                Digit.TWO,
                Digit.THREE,
                Digit.FOUR,
                Digit.FIVE,
                Digit.SIX,
                Digit.SEVEN,
                Digit.EIGHT,
                Digit.NINE
        ));
    }

    @Test
    public void checksum_123456789_should_return_285() {
        AccountNumber accountNumber = AccountNumber.from("123456789");
        assertThat(accountNumber.checksum()).isEqualTo(165);
    }

    @Test
    public void checksum_457508000_should_return_187() {
        AccountNumber accountNumber = AccountNumber.from("457508000");
        assertThat(accountNumber.checksum()).isEqualTo(187);
    }

    @Test
    public void isValid_123456788_should_return_false() {
        AccountNumber accountNumber = AccountNumber.from("123456788");
        assertThat(accountNumber.isValid()).isEqualTo(false);
    }

    @Test
    public void isValid_457508000_should_return_true() {
        AccountNumber accountNumber = AccountNumber.from("457508000");
        assertThat(accountNumber.isValid()).isEqualTo(true);
    }

    @Test
    public void toString_from_test_000000051_should_return_() {
        AccountNumber accountNumber = AccountNumber.from(Paths.get("src/test/resources/test_000000051"));
        assertThat(accountNumber.toString()).isEqualTo("000000051");
    }

    @Test
    public void getSuffix_from_123456789_should_return_empty_string() {
        AccountNumber accountNumber = AccountNumber.from("123456789");
        assertThat(accountNumber.getSuffix()).isEqualTo("");
    }

    @Test
    public void getSuffix_from_12345678I_should_return_ill_suffix() {
        AccountNumber accountNumber = AccountNumber.from("12345678I");
        assertThat(accountNumber.getSuffix()).isEqualTo(AccountNumber.ILLEGIBLE_SUFFIX);
    }

    @Test
    public void getSuffix_from_123456788_should_return_err_suffix() {
        AccountNumber accountNumber = AccountNumber.from("123456788");
        assertThat(accountNumber.getSuffix()).isEqualTo(AccountNumber.ERROR_SUFFIX);
    }

    @Test
    public void getSuffix_from_1234567I8_should_return_ill_suffix() {
        AccountNumber accountNumber = AccountNumber.from("1234567I8");
        assertThat(accountNumber.getSuffix()).isEqualTo(AccountNumber.ILLEGIBLE_SUFFIX);
    }

    @Test
    public void from_test_49006771I_ILL() {
        AccountNumber accountNumber = AccountNumber.from(Paths.get("src/test/resources/test_49006771I_ILL"));
        assertThat(accountNumber.toString()).isEqualTo("49006771? ILL");
    }

    @Test
    public void from_test_1234I678I_ILL() {
        AccountNumber accountNumber = AccountNumber.from(Paths.get("src/test/resources/test_1234I678I_ILL"));
        assertThat(accountNumber.toString()).isEqualTo("1234?678? ILL");
    }

    @Test
    public void findAlternatives_111111111() {
        AccountNumber accountNumber = AccountNumber.from("111111111");
        List<AccountNumber> alternatives = accountNumber.findAlternatives();
        assertThat(alternatives).containsExactly(
                AccountNumber.from("711111111"),
                AccountNumber.from("171111111"),
                AccountNumber.from("117111111"),
                AccountNumber.from("111711111"),
                AccountNumber.from("111171111"),
                AccountNumber.from("111117111"),
                AccountNumber.from("111111711"),
                AccountNumber.from("111111171"),
                AccountNumber.from("111111117")
        );
    }

    @Test
    public void findValidAlternatives_111111111() {
        AccountNumber accountNumber = AccountNumber.from("111111111");
        List<AccountNumber> alternatives = accountNumber.findValidAlternatives();
        assertThat(alternatives).containsExactly(
                AccountNumber.from("711111111")
        );
    }

    @Test
    public void from_test_711111111() {
        AccountNumber accountNumber = AccountNumber.from(Paths.get("src/test/resources/test_711111111"));
        assertThat(accountNumber.toString()).isEqualTo("711111111");
    }

    @Test
    public void from_test_777777177() {
        AccountNumber accountNumber = AccountNumber.from(Paths.get("src/test/resources/test_777777177"));
        assertThat(accountNumber.toString()).isEqualTo("777777177");
    }

    @Test
    public void from_test_200800000() {
        AccountNumber accountNumber = AccountNumber.from(Paths.get("src/test/resources/test_200800000"));
        assertThat(accountNumber.toString()).isEqualTo("200800000");
    }

    @Test
    public void from_test_333393333() {
        AccountNumber accountNumber = AccountNumber.from(Paths.get("src/test/resources/test_333393333"));
        assertThat(accountNumber.toString()).isEqualTo("333393333");
    }

    @Test
    public void from_test_888888888() {
        AccountNumber accountNumber = AccountNumber.from(Paths.get("src/test/resources/test_888888888"));
        assertThat(accountNumber.toString()).isEqualTo("888888888 AMB ['888886888', '888888880', '888888988']");
    }

    @Test
    public void from_test_555555555() {
        AccountNumber accountNumber = AccountNumber.from(Paths.get("src/test/resources/test_555555555"));
        assertThat(accountNumber.toString()).isEqualTo("555555555 AMB ['555655555', '559555555']");
    }

    @Test
    public void from_test_666666666() {
        AccountNumber accountNumber = AccountNumber.from(Paths.get("src/test/resources/test_666666666"));
        assertThat(accountNumber.toString()).isEqualTo("666666666 AMB ['666566666', '686666666']");
    }

    @Test
    public void from_test_999999999() {
        AccountNumber accountNumber = AccountNumber.from(Paths.get("src/test/resources/test_999999999"));
        assertThat(accountNumber.toString()).isEqualTo("999999999 AMB ['899999999', '993999999', '999959999']");
    }


}
