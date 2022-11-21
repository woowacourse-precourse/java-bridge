package bridge.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @DisplayName("다리의 길이 입력 유효성 검사 (3~20)-> False")
    @ValueSource(strings = {"2", "", "21", "''", "$", "a"})
    @ParameterizedTest
    void is_valid_size(String inputSize) {
        assertThatThrownBy(() -> InputValidator.isValidSize(inputSize)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸을 입력 유효성 검사")
    @ValueSource(strings = {"", "E", "''"})
    @ParameterizedTest
    void is_valid_moving(String moving) {
        assertThatThrownBy(() -> InputValidator.isValidMoving(moving)).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("게임 다시 사작 입력 유효성 검사")
    @ValueSource(strings = {"", "R", "''"})
    @ParameterizedTest
    void is_valid_retry(String retry) {
        assertThatThrownBy(() -> InputValidator.isValidMoving(retry)).isInstanceOf(IllegalArgumentException.class);
    }
}
