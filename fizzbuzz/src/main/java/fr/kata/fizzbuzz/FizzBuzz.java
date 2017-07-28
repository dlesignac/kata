package fr.kata.fizzbuzz;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {

    private int value;

    public FizzBuzz(int value) {
        this.value = value;
        checkValue();
    }

    @Override
    public String toString() {
        String output = "";
        if (value % 3 == 0) output += "Fizz";
        if (value % 5 == 0) output += "Buzz";
        if ("".equals(output)) output += String.valueOf(value);
        return output;
    }

    public static String to(int n) {
        return IntStream.range(1, n + 1)
                .mapToObj(FizzBuzz::new)
                .map(FizzBuzz::toString)
                .collect(Collectors.joining("\n"));
    }

    private void checkValue() {
        if (value <= 0) throw new IllegalArgumentException();
    }

}
