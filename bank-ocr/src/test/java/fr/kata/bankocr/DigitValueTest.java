package fr.kata.bankocr;

import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class DigitValueTest {

    @Test
    public void findPerfectMatch_should_return_zero() {
        assertThat(DigitValue.findPerfectMatch(" _ | ||_|").get()).isEqualTo(DigitValue.ZERO);
    }

    @Test
    public void findPerfectMatch_should_return_one() {
        assertThat(DigitValue.findPerfectMatch("     |  |").get()).isEqualTo(DigitValue.ONE);
    }

    @Test
    public void findPerfectMatch_should_return_two() {
        assertThat(DigitValue.findPerfectMatch(" _  _||_ ").get()).isEqualTo(DigitValue.TWO);
    }

    @Test
    public void findPerfectMatch_should_return_three() {
        assertThat(DigitValue.findPerfectMatch(" _  _| _|").get()).isEqualTo(DigitValue.THREE);
    }

    @Test
    public void findPerfectMatch_should_return_four() {
        assertThat(DigitValue.findPerfectMatch("   |_|  |").get()).isEqualTo(DigitValue.FOUR);
    }

    @Test
    public void findPerfectMatch_should_return_five() {
        assertThat(DigitValue.findPerfectMatch(" _ |_  _|").get()).isEqualTo(DigitValue.FIVE);
    }

    @Test
    public void findPerfectMatch_should_return_six() {
        assertThat(DigitValue.findPerfectMatch(" _ |_ |_|").get()).isEqualTo(DigitValue.SIX);
    }

    @Test
    public void findPerfectMatch_should_return_seven() {
        assertThat(DigitValue.findPerfectMatch(" _   |  |").get()).isEqualTo(DigitValue.SEVEN);
    }

    @Test
    public void findPerfectMatch_should_return_eight() {
        assertThat(DigitValue.findPerfectMatch(" _ |_||_|").get()).isEqualTo(DigitValue.EIGHT);
    }

    @Test
    public void findPerfectMatch_should_return_nine() {
        assertThat(DigitValue.findPerfectMatch(" _ |_| _|").get()).isEqualTo(DigitValue.NINE);
    }

    @Test
    public void findPotentialMatches_should_return_zero() {
        assertThat(DigitValue.findPotentialMatches("__ | ||_|"))
                .isEqualTo(new HashSet<>(Collections.singletonList(DigitValue.ZERO)));
    }

    @Test
    public void findPotentialMatches_should_return_eight() {
        assertThat(DigitValue.findPotentialMatches(" _ | ||_|"))
                .isEqualTo(new HashSet<>(Collections.singletonList(DigitValue.EIGHT)));
    }
}
