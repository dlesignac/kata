package fr.kata.lags;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestTreeTest {

    @Test
    public void maxGain_should_return_18() {
        RequestTree tree = new RequestTree();
        tree.insert(Request.of("AF514 0 5 10"));
        tree.insert(Request.of("CO5 3 7 14"));
        tree.insert(Request.of("AF515 5 9 7"));
        tree.insert(Request.of("BA01 6 9 8"));

        assertThat(tree.maxGain()).isEqualTo(18);
    }

}
