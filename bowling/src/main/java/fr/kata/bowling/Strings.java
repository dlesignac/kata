package fr.kata.bowling;

public class Strings {

    public static String removeSpaces(String s) {
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c != ' ') result.append(c);
        }

        return result.toString();
    }

    public static String skip(String s, int skip) {
        return s.substring(skip);
    }

}
