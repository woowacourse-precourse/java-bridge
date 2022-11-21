package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InputValidatorTest {

    @DisplayName("다리의 길이 입력 유효성 검사 (3~20)-> False")
    @CsvSource(value = {"2:false", ":false", "21:false", "'':false", "$:false", "3:true", "20:true",
            "a:false"}, delimiter = ':')
    @ParameterizedTest
    void is_valid_size(String inputSize, boolean expected) {
        assertThat(InputValidator.isValidSize(inputSize)).isEqualTo(expected);
    }

    @DisplayName("이동할 칸을 입력 유효성 검사")
    @CsvSource(value = {" :false", "U:true", "D:true", "E:false", "'':false"}, delimiter = ':')
    @ParameterizedTest
    void is_valid_moving(String moving, boolean expected) {
        assertThat(InputValidator.isValidMoving(moving)).isEqualTo(expected);
    }

    @DisplayName("게임 다시 사작 입력 유효성 검사")
    @CsvSource(value = {":false", "R:true", "Q:true", "'':false", "D:false"}, delimiter = ':')
    @ParameterizedTest
    void is_valid_retry(String input, boolean expected) {
        assertThat(InputValidator.isValidRetry(input)).isEqualTo(expected);
    }
}
