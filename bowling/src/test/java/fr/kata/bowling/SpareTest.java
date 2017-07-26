package fr.kata.bowling;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpareTest {

    @Test(expected = IllegalArgumentException.class)
    public void new_with_first_spare_should_throw_IllegalArgumentException() {
        new Spare(Roll.SPARE, Roll.MISS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void new_with_first_strike_should_throw_IllegalArgumentException() {
        new Spare(Roll.STRIKE, Roll.MISS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void new_with_third_spare_should_throw_IllegalArgumentException() {
        new Spare(Roll.MISS, Roll.SPARE);
    }

    @Test
    public void new_with_valid_should_return_instance() {
        assertThat(new Spare(Roll.MISS, Roll.MISS)).isNotNull();
    }

    @Test
    public void getPoints_of_miss_should_return_10() {
        assertThat(new Spare(Roll.MISS, Roll.MISS).getPoints()).isEqualTo(10);
    }

    @Test
    public void getPoints_of_five_should_return_20() {
        assertThat(new Spare(Roll.MISS, Roll.FIVE).getPoints()).isEqualTo(15);
    }

}
