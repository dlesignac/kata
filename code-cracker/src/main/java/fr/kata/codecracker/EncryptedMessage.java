package fr.kata.codecracker;

import java.util.Objects;

public class EncryptedMessage {

    private String message;

    public EncryptedMessage(String message) {
        this.message = Objects.requireNonNull(message);
    }

    public String decode(EncryptionKey key) {
        StringBuilder decoded = new StringBuilder();

        for (char c : message.toCharArray()) {
            decoded.append(key.decode(c));
        }

        return decoded.toString();
    }

    public String encrypt(EncryptionKey key) {
        StringBuilder encrypted = new StringBuilder();

        for (char c : message.toCharArray()) {
            encrypted.append(key.encrypt(c));
        }

        return encrypted.toString();
    }
}
