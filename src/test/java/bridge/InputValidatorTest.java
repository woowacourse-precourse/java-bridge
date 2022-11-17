package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InputValidatorTest {


    @DisplayName("다리의 길이 예외처리 (3~20)")
    @CsvSource(value = {"2:false", ":false", "21:false", "null:false", "$:false", "3:true", "20:true",
            "a:false"}, delimiter = ':')
    @ParameterizedTest
    void is_not_valid_size(String inputSize, boolean expected) {
        assertThat(InputValidator.isValidSize(inputSize)).isEqualTo(expected);
    }

}
