package fr.kata.bankocr;

public class StringComparator {

    static int numberOfDifferences(String s1, String s2) {
        int numberOfDifferences = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) numberOfDifferences++;
        }

        return numberOfDifferences;
    }
}
