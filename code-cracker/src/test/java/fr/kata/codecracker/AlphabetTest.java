package fr.kata.codecracker;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AlphabetTest {

    @Test
    public void new_with_valid_words_should_return_instance() {
        assertThat(new Alphabet("")).isNotNull();
    }

    @Test(expected = NullPointerException.class)
    public void new_with_null_words_should_throw_NullPointerException() {
        new Alphabet(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void new_with_words_with_duplicates_should_throw_IllegalArgumentException() {
        new Alphabet("aba");
    }

    @Test
    public void length_of_empty_alphabet_should_return_0() {
        assertThat(new Alphabet("").length()).isEqualTo(0);
    }

    @Test
    public void length_of_latin_alphabet_should_return_26() {
        assertThat(Alphabet.latin().length()).isEqualTo(26);
    }

}
