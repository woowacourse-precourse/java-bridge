package bridge.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.utils.Constants.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserInputValidatorTest {

    @DisplayName("다리 길이는 숫자여야 한다.")
    @Test
    void 다리_길이는_숫자() {
        assertThatThrownBy(() -> UserInputValidator.validateBridgeSize("C"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE_NOT_DIGIT);
    }

    @DisplayName("다리 길이는 3이상 20이하여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"2", "21"})
    void 다리_길이는_3이상_20이하(String bridgeLength) {
        assertThatThrownBy(() -> UserInputValidator.validateBridgeSize(bridgeLength))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE_OUT_OF_RANGE_BRIDGE_SIZE);
    }

    @DisplayName("다리 길이 - 정상 입력")
    @ParameterizedTest
    @ValueSource(strings = {"3", "20"})
    void 다리_길이_정상_입력(String bridgeLength) {
        assertDoesNotThrow(() -> UserInputValidator.validateBridgeSize(bridgeLength));
    }

    @DisplayName("이동할 칸은 U,D만 입력 가능하다.")
    @ParameterizedTest
    @ValueSource(strings = {"A", "W", " "})
    void 다리_칸은_U_D만_입력_가능(String spaceToMove) {
        assertThatThrownBy(() -> UserInputValidator.validateSpaceToMove(spaceToMove))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE_NOT_VALID_SPACE_NAME);
    }

    @DisplayName("다리 칸 - 정상 입력")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void 다리_칸_정상_입력(String spaceToMove) {
        assertDoesNotThrow(() -> UserInputValidator.validateSpaceToMove(spaceToMove));
    }

    @DisplayName("재시작 코드는 R, Q만 입력 가능하다.")
    @ParameterizedTest
    @ValueSource(strings = {"A", "W", " "})
    void 재시작_코드는_Q_R_가능(String gameCommand) {
        assertThatThrownBy(() -> UserInputValidator.validateGameCommand(gameCommand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE_NOT_VALID_GAME_COMMAND_NAME);
    }

    @DisplayName("재시작 코드는 R, Q만 입력 가능하다.")
    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void 재시작_코드_정상_입력(String gameCommand) {
        assertDoesNotThrow(() -> UserInputValidator.validateGameCommand(gameCommand));
    }
}