package bridge;

import bridge.domain.game.Retry;
import bridge.provider.BridgeSizeProvider;
import bridge.common.SystemSet;
import bridge.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    private InputView inputView = InputView.getInstance();

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
        public void 올바른_입력_테스트(String inputStr, int inputInt) {
            SystemSet.input(inputStr);

            Assertions.assertThat(inputView.readBridgeSize()).isEqualTo(inputInt);
        }
    }

    @Nested
    @DisplayName("이동할 칸 입력 테스트")
    class readMovingTest {
        @ParameterizedTest
        @DisplayName("U, D가 아니라면 예외가 발생한다.")
        @ValueSource(strings = {"2", "d", "u", "@", "!!!", "예외"})
        public void 예외_입력_테스트(String input) {
            SystemSet.input(input);

            assertThatThrownBy(() -> inputView.readMoving())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @DisplayName("올바른 형식을 입력받는다.")
        @ValueSource(strings = {"U", "D"})
        public void 올바른_입력_테스트(String input) {
            SystemSet.input(input);

            Assertions.assertThat(inputView.readMoving()).isEqualTo(input);
        }
    }

    @Nested
    @DisplayName("재시도 입력 테스트")
    class readGameCommandTest {
        @ParameterizedTest
        @DisplayName("R, Q")
        @ValueSource(strings = {"큐", "r", "q", "@", "!!", "2"})
        public void 예외_입력_테스트(String input) {
            SystemSet.input(input);

            assertThatThrownBy(() -> inputView.readGameCommand())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @DisplayName("올바른 형식을 입력받는다.")
        @ValueSource(strings = {"R", "Q"})
        public void 올바른_입력_테스트(String input) {
            SystemSet.input(input);

            Assertions.assertThat(inputView.readGameCommand()).isEqualTo(Retry.of(input));
        }
    }
}
