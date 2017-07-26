package fr.kata.bowling;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringsTest {

    @Test
    public void removeSpaces_with_no_spaces_should_return_same_string() {
        assertThat(Strings.removeSpaces("abc")).isEqualTo("abc");
    }

    @Test
    public void removeSpaces_with_spaces_should_return_valid_string() {
        assertThat(Strings.removeSpaces("a b c")).isEqualTo("abc");
    }

    @Test(expected = NullPointerException.class)
    public void skip_of_null_should_throw_NullPointerException() {
        Strings.skip(null, 0);
    }

    @Test
    public void skip_of_valid_string_should_return_valid_string() {
        assertThat(Strings.skip("abcd", 2)).isEqualTo("cd");
    }

}
