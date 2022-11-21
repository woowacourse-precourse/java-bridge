package bridge.view;

import bridge.mock.MockInputView;
import bridge.system.validation.InputToBridgeSizeValidator;
import bridge.system.validation.InputToCommandValidator;
import bridge.system.validation.InputToMovingPointValidator;
import bridge.view.inputview.InputView;
import bridge.vo.enums.Command;
import bridge.vo.enums.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    public static final String UP = Step.U.toString();
    public static final String RETRY = Command.R.toString();
    public static final String QUIT = Command.Q.toString();

    @Nested
    @DisplayName("사용자로부터 다리의 길이를 입력받는 readBridgeSize 테스트")
    class ReadBridgeSizeTest {
        @ParameterizedTest(name = "입력값 -> {0}")
        @ValueSource(strings = {"5", "13"})
        @DisplayName("사용자로부터 다리의 길이를 입력받을 수 있다.")
        void whenReadingBridgeSize_thenReturnsBridgeSizeInput(String input) {
            //given
            InputView inputView = new MockInputView(List.of(input));

            //when && then
            assertThat(inputView.readBridgeSize())
                    .isEqualTo(Integer.valueOf(input));
        }

        @ParameterizedTest(name = "입력값 -> {0}")
        @ValueSource(strings = {"영", "R", "-", "0.5", "-4"})
        @DisplayName("사용자가 자연수가 아닌 값을 입력하면 예외가 발생한다.")
        void givenInputNotNumber_whenReadingBridgeSize_thenThrowsException(String input) {
            //given
            InputView inputView = new MockInputView(List.of(input));

            //when && then
            assertThatThrownBy(inputView::readBridgeSize)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(InputToBridgeSizeValidator.NOT_ONLY_NATURAL_NUMBER_MESSAGE);
        }

        @ParameterizedTest(name = "입력값 -> {0}")
        @ValueSource(strings = {"2", "21"})
        @DisplayName("사용자가 유효한 다리 길이의 범위가 아닌 값을 입력하면 예외가 발생한다.")
        void givenInputInvalidRange_whenReadingBridgeSize_thenThrowsException(String input) {
            //given
            InputView inputView = new MockInputView(List.of(input));

            //when && then
            assertThatThrownBy(inputView::readBridgeSize)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(InputToBridgeSizeValidator.INVALID_NUMBER_RANGE_IN_BRIDGE_SIZE_MESSAGE);
        }
    }

    @Nested
    @DisplayName("사용자가 이동할 칸을 입력받는 readMoving 메서드 테스트")
    class readMovingTest {
        @Test
        @DisplayName("사용자가 이동할 칸을 선택하기 위해 U 또는 D를 입력할 수 있다.")
        void whenReadingMoving_thenReturnsMovingPoint() {
            //given
            InputView inputView = new MockInputView(List.of(UP));

            //when
            String target = inputView.readMoving();

            //then
            assertThat(target).isEqualTo(UP);
        }

        @ParameterizedTest(name = "입력값 -> {0}")
        @ValueSource(strings = {"u", "d", "가", "-D", "UU", "UD"})
        @DisplayName("사용자가 U 또는 D 이외의 값을 입력하면 예외가 발생한다. UU나 UD같은 것도 허용하지 않는다.")
        void givenNotUNorD_whenReadingMoving_thenReturnsMovingPoint(String input) {
            //given
            InputView inputView = new MockInputView(List.of(input));

            //when && then
            assertThatThrownBy(inputView::readMoving)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(InputToMovingPointValidator.INVALID_INPUT_VALUE_MESSAGE);
        }
    }

    @Nested
    @DisplayName("게임 재시작/종료 여부를 입력받는 readGameCommand 매서드")
    class ReadGameCommandTest {
        @Test
        @DisplayName("게임 재시작/종료 여부를 결정하기 위해 R 또는 Q 를 입력할 수 있다.")
        void givenROrQ_whenReadingGameCommand_thenReturnsCommand() {
            //given
            InputView inputView = new MockInputView(List.of(RETRY, QUIT));

            //when
            assertThat(inputView.readGameCommand()).isEqualTo(RETRY);
            assertThat(inputView.readGameCommand()).isEqualTo(QUIT);
        }

        @ParameterizedTest(name = "입력값 -> {0}")
        @ValueSource(strings = {"r", "q", "가", "-D", "RR", "QQ"})
        @DisplayName("R 이나 Q 가 아닌 값을 입력하면 예외가 발생한다.")
        void givenNotRNorQ_whenReadingGameCommand_thenThrowsException(String input) {
            //given
            InputView inputView = new MockInputView(List.of(input));

            //when
            assertThatThrownBy(inputView::readGameCommand)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(InputToCommandValidator.INVALID_INPUT_VALUE_MESSAGE);
        }
    }
}