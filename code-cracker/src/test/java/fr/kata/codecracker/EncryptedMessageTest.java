package fr.kata.codecracker;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EncryptedMessageTest {

    @Test
    public void new_with_valid_message_should_return_instance() {
        assertThat(new EncryptedMessage("")).isNotNull();
    }

    @Test(expected = NullPointerException.class)
    public void new_with_null_message_should_throw_NullPointerException() {
        new EncryptedMessage(null);
    }

    @Test
    public void decode_message_with_identity_key() {
        assertThat(new EncryptedMessage("abcdefghijklmnopqrstuvwxyz").decode(identityKey()))
                .isEqualTo("abcdefghijklmnopqrstuvwxyz");
    }

    @Test
    public void decode_message_with_reverse_key() {
        assertThat(new EncryptedMessage("zyxwvutsrqponmlkjihgfedcba").decode(reverseKey()))
                .isEqualTo("abcdefghijklmnopqrstuvwxyz");
    }

    @Test
    public void decode_message_with_complex_key() {
        assertThat(new EncryptedMessage("^]|(% ~(^^&è(").decode(complexKey()))
                .isEqualTo("super message");
    }

    @Test
    public void encrypt_message_with_identity_key() {
        assertThat(new EncryptedMessage("abcdefghijklmnopqrstuvwxyz").encrypt(identityKey()))
                .isEqualTo("abcdefghijklmnopqrstuvwxyz");
    }

    @Test
    public void encrypt_message_with_reverse_key() {
        assertThat(new EncryptedMessage("abcdefghijklmnopqrstuvwxyz").encrypt(reverseKey()))
                .isEqualTo("zyxwvutsrqponmlkjihgfedcba");
    }

    @Test
    public void encrypt_message_with_complex_key() {
        assertThat(new EncryptedMessage("super message").encrypt(complexKey()))
                .isEqualTo("^]|(% ~(^^&è(");
    }

    private EncryptionKey identityKey() {
        return EncryptionKey.identity(Alphabet.latin());
    }

    private EncryptionKey reverseKey() {
        return new EncryptionKey(Alphabet.latin(), "zyxwvutsrqponmlkjihgfedcba");
    }

    private EncryptionKey complexKey() {
        return new EncryptionKey(Alphabet.latin(), "&é#'(-è_çà)=~{[|`%^@]}+$µ¨");
    }

}
