package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.ErrorCode.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    private Validator validator;

    @BeforeEach
    void beforeEach() {
        validator = new Validator();
    }

    @DisplayName("다리 길이 입력이 유효한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"3", "5"})
    void bridgeLengthCorrectValue(String length) {
        // then
        validator.bridgeLengthValidate(length);
    }

    @DisplayName("다리 길이 입력이 유효하지 않은 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1", "21", "a"})
    void bridgeLengthWrongValue(String length) {
        // then
        assertThatThrownBy(() -> validator.bridgeLengthValidate(length))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_BRIDGE_LENGTH_INPUT);
    }

    @DisplayName("이동 입력이 유효한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void moveCorrectValue(String move) {
        // then
        validator.moveValidate(move);
    }

    @DisplayName("이동 입력이 유효하지 않은 경우")
    @ParameterizedTest
    @ValueSource(strings = {"a", " ", "d"})
    void moveWrongValue(String move) {
        // then
        assertThatThrownBy(() -> validator.moveValidate(move))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_MOVE_INPUT);
    }

    @DisplayName("재시작 입력이 유효한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void gameCommandCorrectValue(String gameCommand) {
        // then
        validator.gameCommandValidate(gameCommand);
    }

    @DisplayName("재시작 입력이 유효하지 않은 경우")
    @ParameterizedTest
    @ValueSource(strings = {"r", "q", "z"})
    void gameCommandWrongValue(String gameCommand) {
        // then
        assertThatThrownBy(() -> validator.gameCommandValidate(gameCommand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_GAME_COMMAND_INPUT);
    }
}
