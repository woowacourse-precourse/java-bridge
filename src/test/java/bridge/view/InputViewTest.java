package bridge.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    InputView inputView = new InputView();

    private void setSetIn(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Nested
    @DisplayName("다리 길이 입력 검증")
    class BridgeLength {

        @Nested
        @DisplayName("숫자가 아닌 다른 것이 입력된 경우")
        class NotNumeric {

            @ParameterizedTest(name = "숫자가 아닌 {0}가 입력되면 예외 발생")
            @ValueSource(strings = {"R", "ㄱ", "*"})
            void 예외_발생(String input) {
                // given
                // when
                setSetIn(input);
                // then
                assertThatThrownBy(() ->
                        inputView.readBridgeLength());
            }
        }

        @Test
        @DisplayName("+가 붙은 범위 내 숫자 들어오면 정상 처리")
        void 기호_붙은_양수_입력() {
            // given
            String input = "+3";
            // when
            setSetIn(input);
            int result = inputView.readBridgeLength();
            // then
            assertThat(result).isEqualTo(3);
        }

        @Nested
        @DisplayName("지정된 길이의 범위를 벗어나는 경우")
        class OutOfRange {

            @ParameterizedTest(name = "{0}은 범위를 벗어난 입력이므로 예외 발생")
            @ValueSource(strings = {"1", "-1", "90"})
            void 범위_벗어난_입력(String input) {
                // given
                // when
                setSetIn(input);
                // then
                assertThatThrownBy(() ->
                        inputView.readBridgeLength());
            }

        }
    }

    @Nested
    @DisplayName("이동 옵션 입력 검증")
    class MovingOption {

        @ParameterizedTest(name = "영어가 아닌 {0}이 입력된 경우 예외 발생")
        @ValueSource(strings = {"1", "가", "*"})
        @DisplayName("유효하지 않은 타입의 입력 검증")
        void 영어가_아닌_입력(String input) {
            // given
            // when
            setSetIn(input);
            // then
            assertThatThrownBy(() ->
                    inputView.readMoving());
        }


        @ParameterizedTest(name = "유효한 옵션이 아닌 {0}이 입력된 경우 예외 발생")
        @ValueSource(strings = {"X", "Q", "A"})
        @DisplayName("유효하지 않은 옵션의 입력 검증")
        void 유효하지_않은_옵션(String input) {
            // given
            // when
            setSetIn(input);
            // then
            assertThatThrownBy(() ->
                    inputView.readMoving());
        }

        @ParameterizedTest(name = "{0} 입력시 {1} 반환")
        @CsvSource({"U,U", "D,D"})
        @DisplayName("유효한 입력")
        void 유효한_입력(String input, String output) {
            // given
            // when
            setSetIn(input);
            String result = inputView.readMoving();
            // then
            assertThat(result).isEqualTo(output);
        }

    }

    @Nested
    @DisplayName("재시작 옵션 입력 검증")
    class RestartOption {

        @ParameterizedTest(name = "영어가 아닌 {0}이 입력된 경우 예외 발생")
        @ValueSource(strings = {"1", "가", "*"})
        @DisplayName("유효하지 않은 타입의 입력 검증")
        void 영어가_아닌_입력(String input) {
            // given
            // when
            setSetIn(input);
            // then
            assertThatThrownBy(() ->
                    inputView.readRestartOption());
        }


        @ParameterizedTest(name = "유효한 옵션이 아닌 {0}이 입력된 경우 예외 발생")
        @ValueSource(strings = {"X", "U", "A"})
        @DisplayName("유효하지 않은 옵션의 입력 검증")
        void 유효하지_않은_옵션(String input) {
            // given
            // when
            setSetIn(input);
            // then
            assertThatThrownBy(() ->
                    inputView.readRestartOption());
        }

        @ParameterizedTest(name = "{0} 입력시 {1} 반환")
        @CsvSource({ "Q,Q", "R,R"})
        @DisplayName("유효한 입력")
        void 유효한_입력(String input, String output) {
            // given
            // when
            setSetIn(input);
            String result = inputView.readRestartOption();
            // then
            assertThat(result).isEqualTo(output);
        }

    }
}
