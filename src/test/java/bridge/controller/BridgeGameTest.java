package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.User;
import bridge.domain.message.ErrorMessage;
import bridge.domain.utils.BridgeState;
import bridge.view.InputView;
import bridge.view.OutputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.util.List;

class BridgeGameTest {

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
    @ValueSource(strings = {"A,U", "1234,U"})
    void 다리를_이동할때_정해진값이_아니면_에러를발생한다(String input) {
        final byte[] buf = String.join("\n", input.split(",")).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newConsole));

        new InputView().readMoving();

        Assertions.assertThat(newConsole.toString().trim()).contains(ErrorMessage.BRIDGE_INPUT_ONLY_UP_AND_DOWN);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A,R", "1234,Q"})
    void 재시작할때__정해진값이_아니면_에러를발생한다(String input) {
        final byte[] buf = String.join("\n", input.split(",")).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newConsole));

        new InputView().readGameCommand();

        Assertions.assertThat(newConsole.toString().trim()).contains(ErrorMessage.INPUT_ONLY_RETRY_OR_END);
    }

    @ParameterizedTest
    @CsvSource(value = {"U:U:true", "U:D:false", "D:U:false", "D:D:true"}, delimiter = ':')
    void 각_방향에따라_GameState가_제대로_동작해서_살았는지_죽었는지_반영하는지(String bridgePosition, String position, boolean isAlive) {
        Bridge bridge = new Bridge(List.of(bridgePosition));
        User user = new User();
        BridgeGame bridgeGame = new BridgeGame(new InputView(), new OutputView());
        System.setIn(new ByteArrayInputStream(position.getBytes()));
        bridgeGame.move(user, bridge);

        Assertions.assertThat(user.getUserCrossing(0)).isEqualTo(BridgeState.convertToBridgeState(position, isAlive));
    }
}