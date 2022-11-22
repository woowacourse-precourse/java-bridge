package bridge.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class InputConfigTest {

    private InputConfig config = new InputConfig();

    @DisplayName("다리 길이 입력이 정상일 경우")
    @ValueSource(strings = {"5", "20", "14"})
    @ParameterizedTest
    void checkBridgeLength_true(String input) {
        assertDoesNotThrow(() -> config.checkBridgeLength(input));
    }

    @DisplayName("다리 길이 입력이 비정상일 경우")
    @ValueSource(strings = {"123", "21", "0"})
    @ParameterizedTest
    void checkBridgeLength_false(String input) {
        assertThatThrownBy(() -> config.checkBridgeLength(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동 입력이 정상일 경우")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void checkMovingInput_true(String input) {
        assertDoesNotThrow(() -> config.checkMovingInput(input));
    }

    @DisplayName("이동 입력이 비정상일 경우")
    @ValueSource(strings = {"A", "UU", "d"})
    @ParameterizedTest
    void checkMovingInput_false(String input) {
        assertThatThrownBy(() -> config.checkMovingInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작/종료 입력이 정상일 경우")
    @ValueSource(strings = {"R", "Q", "R"})
    @ParameterizedTest
    void checkAskReGameInput_true(String input) {
        assertDoesNotThrow(() -> config.checkAskReGameInput(input));
    }

    @DisplayName("재시작/종료 입력이 비정상일 경우")
    @ValueSource(strings = {"r", "q", "RRR", "5"})
    @ParameterizedTest
    void checkAskReGameInput_false(String input) {
        assertThatThrownBy(() -> config.checkAskReGameInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}