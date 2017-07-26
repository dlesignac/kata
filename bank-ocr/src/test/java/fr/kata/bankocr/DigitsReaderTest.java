package fr.kata.bankocr;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DigitsReaderTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void readLines_unexisting_file_should_throw_illegal_argument_exception() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("No such file : ");
        DigitsReader.readLines(Paths.get("src/test/resources/test_unexisting"));
    }

    @Test
    public void readLines_empty_file_should_return_empty_list() {
        List<String> actual = DigitsReader.readLines(Paths.get("src/test/resources/test_empty"));
        assertThat(actual).isEmpty();
    }

    @Test
    public void readLines_test_one_line_should_return_list_of_one_element() {
        List<String> actual = DigitsReader.readLines(Paths.get("src/test/resources/test_one_line"));
        assertThat(actual).hasSize(1);
        assertThat(actual.get(0)).isEqualTo("test");
    }

    @Test
    public void readLines_test_n_lines_should_return_list_of_n_elements() {
        List<String> actual = DigitsReader.readLines(Paths.get("src/test/resources/test_three_lines"));
        assertThat(actual).hasSize(3);
        assertThat(actual.get(0)).isEqualTo("test0");
        assertThat(actual.get(1)).isEqualTo("test1");
        assertThat(actual.get(2)).isEqualTo("test2");
    }
}
