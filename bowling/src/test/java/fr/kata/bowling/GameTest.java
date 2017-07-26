package fr.kata.bowling;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test(expected = IllegalArgumentException.class)
    public void of_invalid_should_throw_IllegalArgumentException() {
        assertThat(Game.of("/ X X X X X X X X XXX")).isNotNull();
    }

    @Test
    public void of_full_miss_should_return_instance() {
        assertThat(Game.of("-- -- -- -- -- -- -- -- -- --")).isNotNull();
    }

    @Test
    public void of_full_miss_spare_should_return_instance() {
        assertThat(Game.of("-/ -/ -/ -/ -/ -/ -/ -/ -/ -/-")).isNotNull();
    }

    @Test
    public void of_full_strike_should_return_instance() {
        assertThat(Game.of("X X X X X X X X X XXX")).isNotNull();
    }

    @Test
    public void getPoints_of_full_miss_should_return_0() {
        assertThat(Game.of("-- -- -- -- -- -- -- -- -- --").getPoints()).isEqualTo(0);
    }

    @Test
    public void getPoints_of_full_miss_spare_should_return_0() {
        assertThat(Game.of("-/ -/ -/ -/ -/ -/ -/ -/ -/ -/-").getPoints()).isEqualTo(100);
    }

    @Test
    public void getPoints_spare_five_should_return_20() {
        assertThat(Game.of("-/ 55 -- -- -- -- -- -- -- --").getPoints()).isEqualTo(20);
    }

    @Test
    public void getPoints_spare_strike_should_return_30() {
        assertThat(Game.of("-/ X -- -- -- -- -- -- -- --").getPoints()).isEqualTo(30);
    }

    @Test
    public void getPoints_spare_five_at_end_should_return_15() {
        assertThat(Game.of("-- -- -- -- -- -- -- -- -- -/5").getPoints()).isEqualTo(15);
    }

    @Test
    public void getPoints_spare_strike_at_end_should_return_20() {
        assertThat(Game.of("-- -- -- -- -- -- -- -- -- -/X").getPoints()).isEqualTo(20);
    }

    @Test
    public void getPoints_strike_five_five_should_return_20() {
        assertThat(Game.of("X 55 -- -- -- -- -- -- -- --").getPoints()).isEqualTo(20);
    }

    @Test
    public void getPoints_strike_five_eight_should_return_26() {
        assertThat(Game.of("X 58 -- -- -- -- -- -- -- --").getPoints()).isEqualTo(26);
    }

    @Test
    public void getPoints_strike_strike_miss_should_return_30() {
        assertThat(Game.of("X X -- -- -- -- -- -- -- --").getPoints()).isEqualTo(30);
    }

    @Test
    public void getPoints_strike_strike_five_should_return_45() {
        assertThat(Game.of("X X 55 -- -- -- -- -- -- --").getPoints()).isEqualTo(45);
    }

    @Test
    public void getPoints_strike_five_eight_at_end_should_return_18() {
        assertThat(Game.of("-- -- -- -- -- -- -- -- -- X58").getPoints()).isEqualTo(18);
    }

    @Test
    public void getPoints_strike_strike_miss_at_end_should_return_20() {
        assertThat(Game.of("-- -- -- -- -- -- -- -- -- XX-").getPoints()).isEqualTo(20);
    }

    @Test
    public void getPoints_strike_strike_five_at_end_should_return_25() {
        assertThat(Game.of("-- -- -- -- -- -- -- -- -- XX5").getPoints()).isEqualTo(25);
    }

    @Test
    public void getPoints_of_full_strike_should_return_300() {
        assertThat(Game.of("X X X X X X X X X XXX").getPoints()).isEqualTo(300);
    }

}
