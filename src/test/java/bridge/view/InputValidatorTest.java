package bridge.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @DisplayName("다리 길이 검증")
    @Nested
    class ValidateBridgeSizeTest {

        @DisplayName("성공한 경우 예외를 발생시키지 않아야 한다.")
        @ValueSource(ints = {3, 10, 20})
        @ParameterizedTest
        void success(int bridgeSize) {
            InputValidator inputValidator = new InputValidator();

            inputValidator.validateBridgeSize(bridgeSize);
        }

        @DisplayName("실패한 경우 예외를 발생시켜야 한다.")
        @ValueSource(ints = {0, -1, 21})
        @ParameterizedTest
        void fail(int bridgeSize) {
            InputValidator inputValidator = new InputValidator();

            assertThatThrownBy(() -> inputValidator.validateBridgeSize(bridgeSize))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    @DisplayName("움직임 검증")
    @Nested
    class ValidateMovingTest {

        @DisplayName("성공한 경우 예외를 발생시키지 않아야 한다.")
        @ValueSource(strings = {"U", "D"})
        @ParameterizedTest
        void success(String moving) {
            InputValidator inputValidator = new InputValidator();

            inputValidator.validateMoving(moving);
        }

        @DisplayName("실패한 경우 예외를 발생시켜야 한다.")
        @ValueSource(strings = {"A", "1", ""})
        @ParameterizedTest
        void fail(String moving) {
            InputValidator inputValidator = new InputValidator();

            assertThatThrownBy(() -> inputValidator.validateMoving(moving))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("이동할 칸은 U(위), D(아래) 중 하나여야 합니다.");
        }
    }

    @DisplayName("움직임 검증")
    @Nested
    class ValidateGameCommandTest {

        @DisplayName("성공한 경우 예외를 발생시키지 않아야 한다.")
        @ValueSource(strings = {"Q", "R"})
        @ParameterizedTest
        void success(String gameCommand) {
            InputValidator inputValidator = new InputValidator();

            inputValidator.validateGameCommand(gameCommand);
        }

        @DisplayName("실패한 경우 예외를 발생시켜야 한다.")
        @ValueSource(strings = {"A", "1", ""})
        @ParameterizedTest
        void fail(String gameCommand) {
            InputValidator inputValidator = new InputValidator();

            assertThatThrownBy(() -> inputValidator.validateGameCommand(gameCommand))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("게임 재시작/종료 여부는 R(재시작)과 Q(종료) 중 하나여야 합니다.");
        }
    }
}