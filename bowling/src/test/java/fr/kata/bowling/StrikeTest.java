package fr.kata.bowling;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StrikeTest {

    @Test(expected = IllegalArgumentException.class)
    public void new_with_second_spare_should_throw_IllegalArgumentException() {
        new Strike(Roll.SPARE, Roll.MISS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void new_with_second_strike_and_third_spare_should_throw_IllegalArgumentException() {
        new Strike(Roll.STRIKE, Roll.SPARE);
    }

    @Test
    public void new_with_valid_should_return_instance() {
        assertThat(new Strike(Roll.MISS, Roll.MISS)).isNotNull();
    }

    @Test
    public void getPoints_of_miss_miss_should_return_10() {
        assertThat(new Strike(Roll.MISS, Roll.MISS).getPoints()).isEqualTo(10);
    }

    @Test
    public void getPoints_of_miss_five_should_return_15() {
        assertThat(new Strike(Roll.MISS, Roll.FIVE).getPoints()).isEqualTo(15);
    }

    @Test
    public void getPoints_of_five_five_should_return_15() {
        assertThat(new Strike(Roll.FIVE, Roll.FIVE).getPoints()).isEqualTo(15);
    }

    @Test
    public void getPoints_of_five_eight_should_return_18() {
        assertThat(new Strike(Roll.FIVE, Roll.EIGHT).getPoints()).isEqualTo(18);
    }

    @Test
    public void getPoints_of_strike_five_should_return_25() {
        assertThat(new Strike(Roll.STRIKE, Roll.FIVE).getPoints()).isEqualTo(25);
    }

    @Test
    public void getPoints_of_strike_strike_should_return_30() {
        assertThat(new Strike(Roll.STRIKE, Roll.STRIKE).getPoints()).isEqualTo(30);
    }

}
