package fr.kata.codecracker;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EncryptionKeyTest {

    @Test
    public void new_valid_key_should_return_instance() {
        assertThat(new EncryptionKey(sampleAlphabet(), "def")).isNotNull();
    }

    @Test(expected = NullPointerException.class)
    public void new_null_alphabet_should_throw_NullPointerException() {
        new EncryptionKey(null, "abc");
    }

    @Test(expected = NullPointerException.class)
    public void new_null_key_should_throw_NullPointerException() {
        new EncryptionKey(sampleAlphabet(), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void new_key_of_length_under_ALPHABET_SIZE_should_throw_IllegalArgumentException() {
        new EncryptionKey(sampleAlphabet(), "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void new_key_with_duplicates_should_throw_IllegalArgumentException() {
        new EncryptionKey(sampleAlphabet(), "aba");
    }

    @Test
    public void decode_with_char_in_alphabet_should_return_decoded() {
        assertThat(new EncryptionKey(sampleAlphabet(), "def").decode('e')).isEqualTo('b');
    }

    @Test
    public void decode_with_char_not_in_alphabet_should_return_decoded() {
        assertThat(new EncryptionKey(sampleAlphabet(), "def").decode('a')).isEqualTo('a');
    }

    @Test
    public void encrypt_with_char_in_alphabet_should_return_decoded() {
        assertThat(new EncryptionKey(sampleAlphabet(), "def").encrypt('b')).isEqualTo('e');
    }

    @Test
    public void encrypt_with_char_not_in_alphabet_should_return_decoded() {
        assertThat(new EncryptionKey(sampleAlphabet(), "def").encrypt('d')).isEqualTo('d');
    }

    private static Alphabet sampleAlphabet() {
        return new Alphabet("abc");
    }

}
