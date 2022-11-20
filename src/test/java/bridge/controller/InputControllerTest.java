package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputControllerTest {
    private InputView inputView;
    private OutputView outputView;
    private BridgeMaker bridgeMaker;

    @BeforeEach
    void initialize() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @Nested
    class BridgeSizeTest {
        @DisplayName("유효한 범위 내 숫자를 입력하면 해당 길이를 가진 다리를 생성한다.")
        @ValueSource(ints = {3, 10, 20})
        @ParameterizedTest
        void successGetBridge(int bridgeSize) {
            InputController inputController = new InputController(inputView, outputView, bridgeMaker);
            assertThat(inputController.getBridge(bridgeSize))
                    .isInstanceOf(List.class);
        }

        @DisplayName("유효한 범위 밖의 숫자를 입력하면 오류가 발생한다.")
        @ValueSource(strings = {"-1", "100", "1000000000000000"})
        @ParameterizedTest
        void failGetBridge(String input) {
            InputController inputController = new InputController(inputView, outputView, bridgeMaker);
            assertThatThrownBy(() -> inputController.getBridgeSize(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class DirectionTest {
        @DisplayName("유효한 형식의 방향을 입력하면 오류 없이 반환한다.")
        @ValueSource(strings = {"U", "D"})
        @ParameterizedTest
        void successGetMovingDirection(String moving) {
            InputController inputController = new InputController(inputView, outputView, bridgeMaker);
            assertThat(inputController.getMovingDirection(moving))
                    .isInstanceOf(String.class);
        }

        @DisplayName("유효하지 않은 방향을 입력하면 오류가 발생한다.")
        @ValueSource(strings = {"u", "d", "KKK", "%%"})
        @ParameterizedTest
        void failGetMovingDirection(String moving) {
            InputController inputController = new InputController(inputView, outputView, bridgeMaker);
            assertThatThrownBy(() -> inputController.getMovingDirection(moving))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class GameCommandTest {
        @DisplayName("유효한 형식의 명령어를 입력하면 오류 없이 반환한다.")
        @ValueSource(strings = {"R", "Q"})
        @ParameterizedTest
        void successGetMovingDirection(String command) {
            InputController inputController = new InputController(inputView, outputView, bridgeMaker);
            assertThat(inputController.getGameCommand(command))
                    .isInstanceOf(String.class);
        }

        @DisplayName("유효하지 않은 명령어를 입력하면 오류가 발생한다.")
        @ValueSource(strings = {"r", "q", "KKK", "%%"})
        @ParameterizedTest
        void failGetMovingDirection(String command) {
            InputController inputController = new InputController(inputView, outputView, bridgeMaker);
            assertThatThrownBy(() -> inputController.getGameCommand(command))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
