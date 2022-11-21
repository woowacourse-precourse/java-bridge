package bridge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final InputView inputView = new InputView();

    @ParameterizedTest
    @ValueSource(strings = {"이십칠", "5ㅋ", "@", "a"})
    void validateBridgeSizeStringAsExceptionTest(String bridgeSize) {
        assertThatThrownBy(() -> inputView.validateBridgeSizeAsString(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1", "21", "2147483648", "-2147483648"})
    void validateBridgeSizeIntegerAsExceptionTest(String bridgeSize) {
        assertThatThrownBy(() -> inputView.validateBridgeSizeAsInteger(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "12", "@", "Z", "UU", "UD"})
    void validateMovingExceptionTest(String moving) {
        assertThatThrownBy(() -> inputView.validateMoving(moving))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "12", "@", "Z", "RR", "RQ"})
    void validateGameCommandExceptionTest(String gameCommand) {
        assertThatThrownBy(() -> inputView.validateGameCommand(gameCommand))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
