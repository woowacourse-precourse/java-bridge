package bridge.input;

import bridge.domain.GameCommand;
import bridge.domain.MoveCommand;
import bridge.input.validate.BasicBridgeValidator;
import bridge.input.validate.BridgeValidator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    static class MockSizeBridgeInput implements BridgeInput {
        @Override
        public String readData() {
            return "2131af";
        }
    }

    private static InputView inputView;
    private static BridgeValidator bridgeValidator;

    @BeforeAll
    static void setInputView() {
        inputView = new InputView(new ConsoleBridgeInput(), new BasicBridgeValidator());
    }

    @BeforeAll
    static void setBridgeValidator() {
        bridgeValidator = new BasicBridgeValidator();
    }

    @DisplayName("다리 길이 입력 테스트")
    @Nested
    class inputSize {
        @DisplayName("3~20 사이의 값을 입력할 경우 값이 반환된다")
        @Test
        void correctBridgeSize1() {
            String input = "3\n20";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            int size = inputView.readBridgeSize();
            int size2 = inputView.readBridgeSize();

            assertThat(size).isEqualTo(3);
            assertThat(size2).isEqualTo(20);
        }

        @DisplayName("정해진 다리 길이 범위 외의 값을 입력할 경우 예외가 발생한다")
        @ValueSource(strings = {"2", "21", "3z", "2.2"})
        @ParameterizedTest
        void exceptBridgeSizeRange1(String size) {
            assertThatThrownBy(() -> bridgeValidator.validateBridgeSize(size))
                    .isInstanceOf(RuntimeException.class);
        }
    }

    @DisplayName("이동 입력 테스트")
    @Nested
    class inputMove {
        @DisplayName("MoveCommand 를 입력하면 해당 command가 반환된다")
        @Test
        void correctBridgeMove() {
            String input = MoveCommand.UP.getCommand();
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            String move = inputView.readMoving();

            assertThat(move).isEqualTo("U");
        }

        @DisplayName("정해진 Move Command 가 아닐 경우 예외가 발생한다.")
        @ValueSource(strings = {"f", "u", "d", "z"})
        @ParameterizedTest
        void exceptBridgeSizeRange1(String command) {
            assertThatThrownBy(() -> bridgeValidator.validateMoveCommand(command))
                    .isInstanceOf(RuntimeException.class);
        }
    }

    @DisplayName("게임 재시작/ 종료 입력 테스트")
    @Nested
    class inputGameCommand {
        @DisplayName("GameCommand 를 입력할경우 해당 command가 반환된다")
        @Test
        void inputR() {
            String input = GameCommand.RESTART.getCommand();
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            String move = inputView.readGameCommand();

            assertThat(move).isEqualTo(GameCommand.RESTART.getCommand());
        }

        @DisplayName("정해진 Game Command 가 아닐 경우 예외가 발생한다.")
        @ValueSource(strings = {"f", "u", "d", "z"})
        @ParameterizedTest
        void exceptBridgeSizeRange1(String command) {
            assertThatThrownBy(() -> bridgeValidator.validateMoveCommand(command))
                    .isInstanceOf(RuntimeException.class);
        }
    }
}