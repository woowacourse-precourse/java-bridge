package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {

    @Test
    void validateNumeric_예외검출() {
        List<String> inputs = Arrays.asList("12A", "bbb", "c12d");

        for (String input: inputs) {
            assertThatThrownBy(() -> Validator.validateNumeric(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void validateNumeric_정상값() {
        List<String> inputs = Arrays.asList("123", "456", "789");

        for (String input: inputs) {
            assertThatNoException()
                    .isThrownBy(() -> Validator.validateNumeric(input));
        }
    }

    @Test
    void validateNumericSize_예외검출() {
        List<String> inputs = Arrays.asList("1", "2", "21", "22");

        for (String input: inputs) {
            assertThatThrownBy(() -> Validator.validateNumericSize(3, 20, input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void validateNumericSize_정상값() {
        List<String> inputs = Arrays.asList("3", "4", "19", "20");

        for (String input: inputs) {
            assertThatNoException()
                    .isThrownBy(() -> Validator.validateNumericSize(3, 20, input));
        }
    }

    @Test
    void ValidateContains_예외검출() {
        List<String> correctInputs = Arrays.asList("A", "B", "C");
        List<String> inputs = Arrays.asList("AS", "ABC", "CD", "123", "a", "b", "c");

        for (String input: inputs) {
            assertThatThrownBy(() -> Validator.validateContains(correctInputs, input))
                    .isInstanceOf((IllegalArgumentException.class));
        }
    }

    @Test
    void ValidateContains_정상값() {
        List<String> correctInputs = Arrays.asList("A", "B", "C", "AD");
        List<String> inputs = Arrays.asList("A", "C", "B", "AD");

        for (String input: inputs) {
            assertThatNoException()
                    .isThrownBy(() -> Validator.validateContains(correctInputs, input));
        }
    }

}
