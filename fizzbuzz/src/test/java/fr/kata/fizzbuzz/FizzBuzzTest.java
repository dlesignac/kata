package fr.kata.fizzbuzz;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    @Test(expected = IllegalArgumentException.class)
    public void new_of_negative_should_throw_IllegalArgumentException() {
        new FizzBuzz(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void new_of_0_should_throw_IllegalArgumentException() {
        new FizzBuzz(0);
    }

    @Test
    public void new_of_valid_should_return_instance() {
        assertThat(new FizzBuzz(1)).isNotNull();
    }

    @Test
    public void toString_of_1_should_return_1() {
        assertThat(new FizzBuzz(1).toString()).isEqualTo("1");
    }

    @Test
    public void toString_of_3_should_return_Fizz() {
        assertThat(new FizzBuzz(3).toString()).isEqualTo("Fizz");
    }

    @Test
    public void toString_of_5_should_return_Buzz() {
        assertThat(new FizzBuzz(5).toString()).isEqualTo("Buzz");
    }

    @Test
    public void toString_of_6_should_return_Fizz() {
        assertThat(new FizzBuzz(6).toString()).isEqualTo("Fizz");
    }

    @Test
    public void toString_of_10_should_return_Buzz() {
        assertThat(new FizzBuzz(10).toString()).isEqualTo("Buzz");
    }

    @Test
    public void toString_of_15_should_return_FizzBuzz() {
        assertThat(new FizzBuzz(15).toString()).isEqualTo("FizzBuzz");
    }

    @Test
    public void to_30_should_return_valid() {
        assertThat(FizzBuzz.to(30)).isEqualTo(
                "1\n2\nFizz\n4\nBuzz\n" +
                        "Fizz\n7\n8\nFizz\nBuzz\n" +
                        "11\nFizz\n13\n14\nFizzBuzz\n" +
                        "16\n17\nFizz\n19\nBuzz\n" +
                        "Fizz\n22\n23\nFizz\nBuzz\n" +
                        "26\nFizz\n28\n29\nFizzBuzz"
        );
    }

}
