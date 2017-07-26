package fr.kata.bowling;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RollTest {

    @Test(expected = IllegalArgumentException.class)
    public void of_invalid_char_should_throw_IllegalArgumentException() {
        fr.kata.bowling.Roll.of('a');
    }

    @Test
    public void of_valid_char_should_return_instance() {
        assertThat(fr.kata.bowling.Roll.of('X')).isEqualTo(fr.kata.bowling.Roll.STRIKE);
        assertThat(fr.kata.bowling.Roll.of('/')).isEqualTo(fr.kata.bowling.Roll.SPARE);
        assertThat(fr.kata.bowling.Roll.of('9')).isEqualTo(fr.kata.bowling.Roll.NINE);
        assertThat(fr.kata.bowling.Roll.of('8')).isEqualTo(fr.kata.bowling.Roll.EIGHT);
        assertThat(fr.kata.bowling.Roll.of('7')).isEqualTo(fr.kata.bowling.Roll.SEVEN);
        assertThat(fr.kata.bowling.Roll.of('6')).isEqualTo(fr.kata.bowling.Roll.SIX);
        assertThat(fr.kata.bowling.Roll.of('5')).isEqualTo(fr.kata.bowling.Roll.FIVE);
        assertThat(fr.kata.bowling.Roll.of('4')).isEqualTo(fr.kata.bowling.Roll.FOUR);
        assertThat(fr.kata.bowling.Roll.of('3')).isEqualTo(fr.kata.bowling.Roll.THREE);
        assertThat(fr.kata.bowling.Roll.of('2')).isEqualTo(fr.kata.bowling.Roll.TWO);
        assertThat(fr.kata.bowling.Roll.of('1')).isEqualTo(fr.kata.bowling.Roll.ONE);
        assertThat(fr.kata.bowling.Roll.of('-')).isEqualTo(Roll.MISS);
    }

}
