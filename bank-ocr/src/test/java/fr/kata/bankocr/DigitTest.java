package fr.kata.bankocr;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class DigitTest {

    @Test
    public void of_should_return_0() {
        assertThat(Digit.of(" _ | ||_|")).isEqualTo(Digit.ZERO);
    }

    @Test
    public void of_should_return_1() {
        assertThat(Digit.of("     |  |")).isEqualTo(Digit.ONE);
    }

    @Test
    public void of_should_return_2() {
        assertThat(Digit.of(" _  _||_ ")).isEqualTo(Digit.TWO);
    }

    @Test
    public void of_should_return_3() {
        assertThat(Digit.of(" _  _| _|")).isEqualTo(Digit.THREE);
    }

    @Test
    public void of_should_return_4() {
        assertThat(Digit.of("   |_|  |")).isEqualTo(Digit.FOUR);
    }

    @Test
    public void of_should_return_5() {
        assertThat(Digit.of(" _ |_  _|")).isEqualTo(Digit.FIVE);
    }

    @Test
    public void of_should_return_6() {
        assertThat(Digit.of(" _ |_ |_|")).isEqualTo(Digit.SIX);
    }

    @Test
    public void of_should_return_7() {
        assertThat(Digit.of(" _   |  |")).isEqualTo(Digit.SEVEN);
    }

    @Test
    public void of_should_return_8() {
        assertThat(Digit.of(" _ |_||_|")).isEqualTo(Digit.EIGHT);
    }

    @Test
    public void of_should_return_9() {
        assertThat(Digit.of(" _ |_| _|")).isEqualTo(Digit.NINE);
    }

    @Test
    public void of_should_return_UNKNOWN() {
        assertThat(Digit.of("         ")).isEqualTo(Digit.UNKNOWN);
    }

    @Test
    public void findAlternatives_ZERO_should_return_EIGHT() {
        assertThat(Digit.ZERO.findAlternatives()).isEqualTo(Collections.singletonList(Digit.EIGHT));
    }

    @Test
    public void findAlternatives_ONE_should_return_SEVEN() {
        assertThat(Digit.ONE.findAlternatives()).isEqualTo(Collections.singletonList(Digit.SEVEN));
    }

    @Test
    public void findAlternatives_TWO_should_return_EMPTY() {
        assertThat(Digit.TWO.findAlternatives()).isEqualTo(Collections.emptyList());
    }

    @Test
    public void findAlternatives_THREE_should_return_EMPTY() {
        assertThat(Digit.THREE.findAlternatives()).isEqualTo(Collections.singletonList(Digit.NINE));
    }

    @Test
    public void findAlternatives_FOUR_should_return_EMPTY() {
        assertThat(Digit.FOUR.findAlternatives()).isEqualTo(Collections.emptyList());
    }

    @Test
    public void findAlternatives_FIVE_should_return_SIX_and_NINE() {
        assertThat(Digit.FIVE.findAlternatives()).isEqualTo(Arrays.asList(Digit.SIX, Digit.NINE));
    }

    @Test
    public void findAlternatives_SIX_should_return_EMPTY() {
        assertThat(Digit.SIX.findAlternatives()).isEqualTo(Arrays.asList(Digit.FIVE, Digit.EIGHT));
    }

    @Test
    public void findAlternatives_SEVEN_should_return_EMPTY() {
        assertThat(Digit.SEVEN.findAlternatives()).isEqualTo(Collections.singletonList(Digit.ONE));
    }

    @Test
    public void findAlternatives_EIGHT_should_return_EMPTY() {
        assertThat(Digit.EIGHT.findAlternatives()).isEqualTo(Arrays.asList(Digit.ZERO, Digit.SIX, Digit.NINE));
    }

    @Test
    public void findAlternatives_NINE_should_return_EMPTY() {
        assertThat(Digit.NINE.findAlternatives()).isEqualTo(Arrays.asList(Digit.EIGHT, Digit.THREE, Digit.FIVE));
    }

    @Test
    public void of_0_should_return_0() {
        assertThat(Digit.of('0')).isEqualTo(Digit.ZERO);
    }

    @Test
    public void of_1_should_return_1() {
        assertThat(Digit.of('1')).isEqualTo(Digit.ONE);
    }

    @Test
    public void of_2_should_return_2() {
        assertThat(Digit.of('2')).isEqualTo(Digit.TWO);
    }

    @Test
    public void of_3_should_return_3() {
        assertThat(Digit.of('3')).isEqualTo(Digit.THREE);
    }

    @Test
    public void of_4_should_return_4() {
        assertThat(Digit.of('4')).isEqualTo(Digit.FOUR);
    }

    @Test
    public void of_5_should_return_5() {
        assertThat(Digit.of('5')).isEqualTo(Digit.FIVE);
    }

    @Test
    public void of_6_should_return_6() {
        assertThat(Digit.of('6')).isEqualTo(Digit.SIX);
    }

    @Test
    public void of_7_should_return_7() {
        assertThat(Digit.of('7')).isEqualTo(Digit.SEVEN);
    }

    @Test
    public void of_8_should_return_8() {
        assertThat(Digit.of('8')).isEqualTo(Digit.EIGHT);
    }

    @Test
    public void of_9_should_return_9() {
        assertThat(Digit.of('9')).isEqualTo(Digit.NINE);
    }
}
