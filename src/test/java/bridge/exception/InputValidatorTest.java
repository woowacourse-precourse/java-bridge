package bridge.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @DisplayName("올바른 다리 길이가 입력되지 않으면 예외 처리")
    @ValueSource(strings = {"2", "", "-4","21", "R"})
    @ParameterizedTest(name = "[{index}] length={0}")
    void validateBridgeLengthTest(String length) {
        assertThatThrownBy(() ->
                InputValidator.validateBridgeLength(length)
        ).isInstanceOf(IllegalArgumentException.class).hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("입력이 U 또는 D가 아니면 예외 처리")
    @ValueSource(strings = {"UD", "", "-4", "Q"})
    @ParameterizedTest(name = "[{index}] moving={0}")
    void validateCorrectMovingCommandTest(String moving) {
        assertThatThrownBy(() ->
                InputValidator.validateCorrectMovingCommand(moving)
        ).isInstanceOf(IllegalArgumentException.class).hasMessageStartingWith("[ERROR]");;
    }

    @DisplayName("입력이 R 또는 Q가 아니면 예외 처리")
    @ValueSource(strings = {"RQ", "", "-4", "U"})
    @ParameterizedTest(name = "[{index}] retry={0}")
    void validateCorrectRetryCommandTest(String retry) {
        assertThatThrownBy(() ->
                InputValidator.validateCorrectRetryCommand(retry)
        ).isInstanceOf(IllegalArgumentException.class).hasMessageStartingWith("[ERROR]");;
    }
}