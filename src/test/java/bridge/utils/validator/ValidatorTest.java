package bridge.utils.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @ParameterizedTest
    @ValueSource(strings = {"q", "@", "ㅂ", "2", "21"})
    void InputBridgeSizeNotNumberOrOutRangeNumber(String input) {
        assertThatThrownBy(() -> BridgeValidator.validSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","u","d","A","a","ㄱ","@"})
    void InputMovingOption(String input) {
        assertThatThrownBy(() -> GameValidator.validMovingOption(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","r","q","A","a","ㄱ","@"})
    void InputGameCommand(String input) {
        assertThatThrownBy(() -> GameValidator.validGameCommand(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}