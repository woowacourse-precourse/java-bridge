package bridge.controller;

import bridge.domain.message.ErrorMessage;
import bridge.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class BridgeControllerTest {

    private InputView inputView;

    @BeforeEach
    void beforeEach() {
        inputView = new InputView();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", " "})
    void 잘못된_다리의크기_입력시_예외발생(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Assertions.assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_IS_NUMERIC);
    }

    @Test
    void 다리의크기는_0이될수_없다() {
        InputStream inputStream = new ByteArrayInputStream("0".getBytes());
        System.setIn(inputStream);

        Assertions.assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BRIDGE_SIZE_NOT_ZERO);
    }

    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void 다리를_이동할때는_U또는D만_입력할수있다(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        InputView inputView = new InputView();
        Assertions.assertThat(inputView.readMoving()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "1234"})
    void 다리를_이동할때_정해진값이_아니면_에러를발생한다(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        InputView inputView = new InputView();
        Assertions.assertThatThrownBy(() -> inputView.readMoving())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BRIDGE_INPUT_ONLY_UP_AND_DOWN);
    }
}