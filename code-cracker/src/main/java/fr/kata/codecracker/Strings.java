package fr.kata.codecracker;

import java.util.HashMap;
import java.util.Map;

public class Strings {

    public static boolean hasDuplicates(String key) {
        Map<Character, Boolean> found = new HashMap<>();

        for (char c : key.toCharArray()) {
            Boolean alreadyFound = found.get(c);

            if (alreadyFound != null && alreadyFound) {
                return true;
            }

            found.put(c, true);
        }

        return false;
    }

}
