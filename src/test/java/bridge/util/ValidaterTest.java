package bridge.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidaterTest {
    private static final String ERROR_MESSAGE_NOT_INT = "[ERROR] 숫자를 입력해주세요.";
    private static final String ERROR_MESSAGE_NOT_PROPER_BRIDGE_SIZE = "[ERROR] 다리 길이는 3이상 20이하의 숫자만 입력 가능합니다.";
    private static final String ERROR_MESSAGE_NOT_PROPER_MOVE = "[ERROR] 대문자 U또는 D를 입력해주세요.";
    private static final String ERROR_MESSAGE_NOT_PROPER_COMMAND = "[ERROR] 대문자 R또는 Q를 입력해주세요.";
    Validater validater = new Validater();


    @DisplayName("숫자가 아닌 다리 크기에 대한 예외 처리")
    @ValueSource(strings = {"가나다", "1가나", "가나23"})
    @ParameterizedTest
    void notNumericBridgeSize(String input) {
        assertThatThrownBy(() -> validater.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_NOT_INT);
    }

    @DisplayName("3~20 범위를 벗어난 다리 크기에 대한 예외 처리")
    @ValueSource(strings = {"0", "2", "21"})
    @ParameterizedTest
    void notProperBridgeSize(String input) {
        assertThatThrownBy(() -> validater.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_NOT_PROPER_BRIDGE_SIZE);
    }

    @DisplayName("대문자 U또는 D가 아닌 입력에 대한 예외 처리")
    @ValueSource(strings = {"u", "d", "Q", "R", "21", "위"})
    @ParameterizedTest
    void notMovingCommand(String input) {
        assertThatThrownBy(() -> validater.validateMovingInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_NOT_PROPER_MOVE);
    }

    @DisplayName("대문자 R또는 Q가 아닌 입력에 대한 예외 처리")
    @ValueSource(strings = {"r", "q", "U", "D", "21", "위"})
    @ParameterizedTest
    void validateGameCommandInput(String input) {
        assertThatThrownBy(() -> validater.validateGameCommandInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_NOT_PROPER_COMMAND);
    }
}