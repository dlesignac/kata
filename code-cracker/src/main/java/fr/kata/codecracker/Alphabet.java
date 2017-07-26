package fr.kata.codecracker;

import java.util.Objects;

public class Alphabet {

    private static final String LATIN = "abcdefghijklmnopqrstuvwxyz";

    private String words;

    public Alphabet(String words) {
        this.words = Objects.requireNonNull(words);
        checkDuplicates();
    }

    private void checkDuplicates() {
        if (Strings.hasDuplicates(words)) throw new IllegalArgumentException();
    }

    public String getWords() {
        return words;
    }

    public int length() {
        return words.length();
    }

    public static Alphabet latin() {
        return new Alphabet(LATIN);
    }
}
