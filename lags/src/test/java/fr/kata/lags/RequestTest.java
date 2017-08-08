package fr.kata.lags;

import org.junit.Test;

import static fr.kata.lags.Request.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RequestTest {

    @Test
    public void of_valid_should_return_instance() {
        assertThat(Request.of("a 0 0 0")).isNotNull();
    }

    @Test
    public void compareTo_should_return_IS_BEFORE() {
        assertThat(Request.of("a 0 1 0").compareTo(Request.of("b 1 1 0"))).isEqualTo(IS_BEFORE);
    }

    @Test
    public void compare_should_return_IS_DURING() {
        assertThat(Request.of("a 0 1 0").compareTo(Request.of("b 0 2 0"))).isEqualTo(IS_AT_SAME_TIME);
    }

    @Test
    public void compare_should_return_IS_AFTER() {
        assertThat(Request.of("a 1 1 0").compareTo(Request.of("b 0 1 0"))).isEqualTo(IS_AFTER);
    }

}

