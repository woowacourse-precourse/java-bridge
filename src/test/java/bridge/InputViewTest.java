package bridge;

import bridge.provider.BridgeSizeProvider;
import bridge.common.SystemSet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    private InputView inputView = new InputView();

    @Nested
    @DisplayName("다리 길이 입력 테스트")
    class readBridgeSizeTest {

        @ParameterizedTest
        @DisplayName("숫자가 아니라면 예외가 발생한다.")
        @ValueSource(strings = {"3개", "!!", " ", "삼"})
        public void 숫자_입력_테스트(String input) {
            SystemSet.input(input);

            assertThatThrownBy(() -> inputView.readBridgeSize())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @DisplayName("숫자가 범위를 벗어나면 예외가 발생한다.")
        @ValueSource(strings = {"255", "21", "1", "-2", "0"})
        public void 범위_확인_테스트(String input) {
            SystemSet.input(input);

            assertThatThrownBy(() -> inputView.readBridgeSize())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @DisplayName("올바른 형식을 입력받는다.")
        @ArgumentsSource(BridgeSizeProvider.class)
        public void 범위_확인_테스트(String inputStr, int inputInt) {
            SystemSet.input(inputStr);
            Assertions.assertThat(inputView.readBridgeSize()).isEqualTo(inputInt);
        }
    }
}
