package fr.kata.bowling;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleTest {

    @Test(expected = IllegalArgumentException.class)
    public void new_with_first_spare_should_throw_IllegalArgumentException() {
        new Simple(Roll.SPARE, Roll.MISS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void new_with_first_strike_should_throw_IllegalArgumentException() {
        new Simple(Roll.STRIKE, Roll.MISS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void new_with_second_spare_should_throw_IllegalArgumentException() {
        new Simple(Roll.MISS, Roll.SPARE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void new_with_second_strike_should_throw_IllegalArgumentException() {
        new Simple(Roll.MISS, Roll.STRIKE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void new_with_first_greater_than_second_strike_should_throw_IllegalArgumentException() {
        new Simple(Roll.NINE, Roll.EIGHT);
    }

    @Test
    public void new_with_valid_should_return_instance() {
        assertThat(new Simple(Roll.MISS, Roll.MISS)).isNotNull();
    }

    @Test
    public void getPoints_of_miss_miss_should_return_0() {
        assertThat(new Simple(Roll.MISS, Roll.MISS).getPoints()).isEqualTo(0);
    }

    @Test
    public void getPoints_of_miss_five_should_return_5() {
        assertThat(new Simple(Roll.MISS, Roll.FIVE).getPoints()).isEqualTo(5);
    }

    @Test
    public void getPoints_of_five_five_should_return_5() {
        assertThat(new Simple(Roll.FIVE, Roll.FIVE).getPoints()).isEqualTo(5);
    }

    @Test
    public void getPoints_of_two_five_should_return_5() {
        assertThat(new Simple(Roll.TWO, Roll.FIVE).getPoints()).isEqualTo(5);
    }

}
