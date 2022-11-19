package bridge.view;

import bridge.mock.MockInputView;
import bridge.system.validation.InputToBridgeSizeValidator;
import bridge.view.inputview.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    @Nested
    @DisplayName("사용자로부터 다리의 길이를 입력받는 readBridgeSize 테스트")
    class ReadBridgeSizeTest {
        @ParameterizedTest(name = "입력값 -> {0}")
        @ValueSource(strings = {"5", "13"})
        @DisplayName("사용자로부터 다리의 길이를 입력받을 수 있다.")
        void whenReadingBridgeSize_thenReturnsBridgeSizeInput(String input) {
            //given
            InputView inputView = new MockInputView(input);

            //when && then
            assertThat(inputView.readBridgeSize())
                    .isEqualTo(Integer.valueOf(input));
        }

        @ParameterizedTest(name = "입력값 -> {0}")
        @ValueSource(strings = {"영", "R", "-", "0.5", "-4"})
        @DisplayName("사용자가 자연수가 아닌 값을 입력하면 예외가 발생한다.")
        void givenInputNotNumber_whenReadingBridgeSize_thenThrowsException(String input) {
            //given
            InputView inputView = new MockInputView(input);

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
            InputView inputView = new MockInputView(input);

            //when && then
            assertThatThrownBy(inputView::readBridgeSize)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(String.format(InputToBridgeSizeValidator.INVALID_NUMBER_RANGE_MESSAGE_FORMAT, 3, 20));
        }
    }

    @Nested
    @DisplayName("사용자가 이동할 칸을 입력받는 readMoving 메서드 테스트")
    class readMovingTest {
        @Test
        @DisplayName("사용자가 이동할 칸을 선택하기 위해 U 또는 D를 입력할 수 있다.")
        void whenReadingMoving_thenReturnsMovingPoint() {
            //given
            InputView inputView = new MockInputView("U");

            //when
            String target = inputView.readMoving();

            //then
            assertThat(target).isEqualTo("U");
        }

        @ParameterizedTest(name = "입력값 -> {0}")
        @ValueSource(strings = {"u", "d", "가", "-D", "UU", "UD"})
        @DisplayName("사용자가 U 또는 D 이외의 값을 입력하면 예외가 발생한다. UU나 UD같은 것도 허용하지 않는다.")
        void givenNotUNorD_whenReadingMoving_thenReturnsMovingPoint(String input) {
            //given
            InputView inputView = new MockInputView(input);

            //when && then
            assertThatThrownBy(inputView::readMoving)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("이동할 칸으로는 대문자 U 또는 D 둘 중 하나만 입력하실 수 있습니다.");
        }
    }

    @Nested
    @DisplayName("게임 재시작/종료 여부를 입력받는 readGameCommand 매서드")
    class ReadGameCommandTest {
        @Test
        @DisplayName("게임 재시작/종료 여부를 결정하기 위해 R 또는 Q 를 입력할 수 있다.")
        void givenROrQ_whenReadingGameCommand_thenReturnsCommand() {
            //given
            InputView inputView = new MockInputView("R", "Q");

            //when
            assertThat(inputView.readGameCommand()).isEqualTo("R");
            assertThat(inputView.readGameCommand()).isEqualTo("Q");
        }

        @ParameterizedTest(name = "입력값 -> {0}")
        @ValueSource(strings = {"r", "q", "가", "-D", "RR", "QQ"})
        @DisplayName("R 이나 Q 가 아닌 값을 입력하면 예외가 발생한다.")
        void givenNotRNorQ_whenReadingGameCommand_thenThrowsException(String input) {
            //given
            InputView inputView = new MockInputView(input);

            //when
            assertThatThrownBy(inputView::readGameCommand)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("게임 재시작/종료 여부로는 대문자 R 또는 Q 둘 중 하나만 입력하실 수 있습니다.");
        }
    }
}