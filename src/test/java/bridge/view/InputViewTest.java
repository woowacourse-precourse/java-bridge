package bridge.view;

import bridge.mock.MockInputView;
import bridge.system.validation.InputToBridgeSizeValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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
}