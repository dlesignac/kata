package fr.kata.bankocr;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountNumberTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void from_unexisting_file_should_throw_illegal_argument_exception() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("No such file : ");
        new AccountNumber(Paths.get("src/test/resources/test_unexisting"));
    }

    @Test
    public void from_file_with_invalid_content_should_throw_illegal_argument_exception() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Invalid input file content");
        new AccountNumber(Paths.get("src/test/resources/test_empty"));
    }

    @Test
    public void from_test_000000000_should_get_value() {
        AccountNumber accountNumber = new AccountNumber(Paths.get("src/test/resources/test_000000000"));
        assertThat(accountNumber.partialToString()).isEqualTo("000000000");
    }

    @Test
    public void from_test_111111111_should_get_value() {
        AccountNumber accountNumber = new AccountNumber(Paths.get("src/test/resources/test_111111111"));
        assertThat(accountNumber.partialToString()).isEqualTo("111111111");
    }

    @Test
    public void from_test_222222222_should_get_value() {
        AccountNumber accountNumber = new AccountNumber(Paths.get("src/test/resources/test_222222222"));
        assertThat(accountNumber.partialToString()).isEqualTo("222222222");
    }

    @Test
    public void from_test_333333333_should_get_value() {
        AccountNumber accountNumber = new AccountNumber(Paths.get("src/test/resources/test_333333333"));
        assertThat(accountNumber.partialToString()).isEqualTo("333333333");
    }

    @Test
    public void from_test_444444444_should_get_value() {
        AccountNumber accountNumber = new AccountNumber(Paths.get("src/test/resources/test_444444444"));
        assertThat(accountNumber.partialToString()).isEqualTo("444444444");
    }

    @Test
    public void from_test_555555555_should_get_value() {
        AccountNumber accountNumber = new AccountNumber(Paths.get("src/test/resources/test_555555555"));
        assertThat(accountNumber.partialToString()).isEqualTo("555555555");
    }

    @Test
    public void from_test_666666666_should_get_value() {
        AccountNumber accountNumber = new AccountNumber(Paths.get("src/test/resources/test_666666666"));
        assertThat(accountNumber.partialToString()).isEqualTo("666666666");
    }

    @Test
    public void from_test_777777777_should_get_value() {
        AccountNumber accountNumber = new AccountNumber(Paths.get("src/test/resources/test_777777777"));
        assertThat(accountNumber.partialToString()).isEqualTo("777777777");
    }

    @Test
    public void from_test_888888888_should_get_value() {
        AccountNumber accountNumber = new AccountNumber(Paths.get("src/test/resources/test_888888888"));
        assertThat(accountNumber.partialToString()).isEqualTo("888888888");
    }

    @Test
    public void from_test_999999999_should_get_value() {
        AccountNumber accountNumber = new AccountNumber(Paths.get("src/test/resources/test_999999999"));
        assertThat(accountNumber.partialToString()).isEqualTo("999999999");
    }

    @Test
    public void from_test_123456789_should_get_value() {
        AccountNumber accountNumber = new AccountNumber(Paths.get("src/test/resources/test_123456789"));
        assertThat(accountNumber.partialToString()).isEqualTo("123456789");
    }

    @Test
    public void toString_from_test_000000051_should_return_() {
        AccountNumber accountNumber = new AccountNumber(Paths.get("src/test/resources/test_000000051"));
        assertThat(accountNumber.toString()).isEqualTo("000000051");
    }

    @Test
    public void from_test_49006771I_ILL() {
        AccountNumber accountNumber = new AccountNumber(Paths.get("src/test/resources/test_49006771I_ILL"));
        assertThat(accountNumber.toString()).isEqualTo("49006771? ILL");
    }

    @Test
    public void from_test_1234I678I_ILL() {
        AccountNumber accountNumber = new AccountNumber(Paths.get("src/test/resources/test_1234I678I_ILL"));
        assertThat(accountNumber.toString()).isEqualTo("1234?678? ILL");
    }

    @Test
    public void from_test_711111111() {
        AccountNumber accountNumber = new AccountNumber(Paths.get("src/test/resources/test_711111111"));
        assertThat(accountNumber.toString()).isEqualTo("711111111");
    }

    @Test
    public void from_test_777777177() {
        AccountNumber accountNumber = new AccountNumber(Paths.get("src/test/resources/test_777777177"));
        assertThat(accountNumber.toString()).isEqualTo("777777177");
    }

    @Test
    public void from_test_200800000() {
        AccountNumber accountNumber = new AccountNumber(Paths.get("src/test/resources/test_200800000"));
        assertThat(accountNumber.toString()).isEqualTo("200800000");
    }

    @Test
    public void from_test_333393333() {
        AccountNumber accountNumber = new AccountNumber(Paths.get("src/test/resources/test_333393333"));
        assertThat(accountNumber.toString()).isEqualTo("333393333");
    }

    @Test
    public void from_test_888888888() {
        AccountNumber accountNumber = new AccountNumber(Paths.get("src/test/resources/test_888888888"));
        assertThat(accountNumber.toString()).isEqualTo("888888888 AMB ['888886888', '888888880', '888888988']");
    }

    @Test
    public void from_test_555555555() {
        AccountNumber accountNumber = new AccountNumber(Paths.get("src/test/resources/test_555555555"));
        assertThat(accountNumber.toString()).isEqualTo("555555555 AMB ['555655555', '559555555']");
    }

    @Test
    public void from_test_666666666() {
        AccountNumber accountNumber = new AccountNumber(Paths.get("src/test/resources/test_666666666"));
        assertThat(accountNumber.toString()).isEqualTo("666666666 AMB ['666566666', '686666666']");
    }

    @Test
    public void from_test_999999999() {
        AccountNumber accountNumber = new AccountNumber(Paths.get("src/test/resources/test_999999999"));
        assertThat(accountNumber.toString()).isEqualTo("999999999 AMB ['899999999', '993999999', '999959999']");
    }
}
