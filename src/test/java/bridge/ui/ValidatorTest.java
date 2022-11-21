package bridge.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.constant.ErrorCode.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    @DisplayName("다리 길이 입력이 유효한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"3", "5"})
    void bridgeLengthCorrectValue(String size) {
        // then
        Validator.bridgeSizeValidate(size);
    }

    @DisplayName("다리 길이 입력이 유효하지 않은 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1", "21", "a"})
    void bridgeLengthWrongValue(String size) {
        // then
        assertThatThrownBy(() -> Validator.bridgeSizeValidate(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_BRIDGE_SIZE_INPUT);
    }

    @DisplayName("이동 입력이 유효한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void moveCorrectValue(String move) {
        // then
        Validator.moveValidate(move);
    }

    @DisplayName("이동 입력이 유효하지 않은 경우")
    @ParameterizedTest
    @ValueSource(strings = {"a", " ", "d"})
    void moveWrongValue(String move) {
        // then
        assertThatThrownBy(() -> Validator.moveValidate(move))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_MOVE_INPUT);
    }

    @DisplayName("재시작 입력이 유효한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void gameCommandCorrectValue(String gameCommand) {
        // then
        Validator.gameCommandValidate(gameCommand);
    }

    @DisplayName("재시작 입력이 유효하지 않은 경우")
    @ParameterizedTest
    @ValueSource(strings = {"r", "q", "z"})
    void gameCommandWrongValue(String gameCommand) {
        // then
        assertThatThrownBy(() -> Validator.gameCommandValidate(gameCommand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_GAME_COMMAND_INPUT);
    }
}
