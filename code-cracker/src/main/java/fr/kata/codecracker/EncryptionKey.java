package fr.kata.codecracker;

import java.util.Objects;

public class EncryptionKey {

    private Alphabet alphabet;
    private String key;

    public EncryptionKey(Alphabet alphabet, String key) {
        this.alphabet = Objects.requireNonNull(alphabet);
        this.key = Objects.requireNonNull(key);
        checkDuplicates();
        checkSize();
    }

    private void checkDuplicates() {
        if (Strings.hasDuplicates(key)) throw new IllegalArgumentException();
    }

    private void checkSize() {
        if (key.length() < alphabet.length()) throw new IllegalArgumentException();
    }

    public char decode(char c) {
        int positionInAlphabet = key.indexOf(c);
        if (positionInAlphabet == -1) return c;
        return alphabet.getWords().charAt(positionInAlphabet);
    }

    public char encrypt(char c) {
        int positionInAlphabet = alphabet.getWords().indexOf(c);
        if (positionInAlphabet == -1) return c;
        return key.charAt(positionInAlphabet);
    }

    public static EncryptionKey identity(Alphabet alphabet) {
        return new EncryptionKey(alphabet, alphabet.getWords());
    }

}
