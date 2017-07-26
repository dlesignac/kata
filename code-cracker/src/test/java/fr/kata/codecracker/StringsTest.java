package fr.kata.codecracker;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringsTest {

    @Test
    public void hasDuplicates_with_no_duplicates_should_return_false() {
        assertThat(Strings.hasDuplicates("abc")).isFalse();
    }

    @Test
    public void hasDuplicates_with_duplicates_should_return_true() {
        assertThat(Strings.hasDuplicates("aba")).isTrue();
    }
}
