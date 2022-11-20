package bridge.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        this.inputValidator = new InputValidator();
    }

    @DisplayName("다리 길이 입력 테스트")
    @Nested
    class ValidateBridgeSize {
        @ParameterizedTest(name = "3 이상 20 이하가 아니면 예외 처리한다")
        @ValueSource(ints = {1, 2, 21, 22})
        void inputBridgeLengthOutOfRange(int size) {
            assertThatThrownBy(() -> inputValidator.validateBridgeSizeRange(size))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest(name = "3 이상 20 이하의 숫자를 입력할 수 있다.")
        @ValueSource(ints = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20})
        void inputBridgeLength(int size) {
            assertDoesNotThrow(() -> inputValidator.validateBridgeSizeRange(size));
        }

        @ParameterizedTest(name = "숫자가 아닌 문자면 예외 처리한다.")
        @ValueSource(strings = {" ", "abc", ",./", "가나다", "@#%^&"})
        void validateNumberNotDigit(String text) {
            assertThatThrownBy(() -> inputValidator.validateNumber(text))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest(name = "숫자가 공백 또는 Null 이면 예외 처리한다.")
        @NullAndEmptySource
        void validateNumberNull(String text) {
            assertThatThrownBy(() -> inputValidator.validateNumber(text))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest(name = "숫자를 입력한다.")
        @ValueSource(strings = {"3", "4", "19", "20"})
        void validateNumber(String text) {
            assertThat(inputValidator.validateNumber(text)).isEqualTo(Integer.parseInt(text));
        }
    }

    @DisplayName("플레이어가 이동할 칸 입력 테스트")
    @Nested
    class ValidateInputMoving {
        @ParameterizedTest(name = "U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력할 수 있다.")
        @ValueSource(strings = {"U", "D"})
        void inputMoving() {
            assertDoesNotThrow(() -> inputValidator.validateInputMoving("U"));
        }

        @ParameterizedTest(name = "U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력할 수 있으며 Null또는 공백이면 예외 처리한다.")
        @NullAndEmptySource
        void inputMovingNullOrEmpty(String moving) {
            assertThatThrownBy(() -> inputValidator.validateInputMoving(moving))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest(name = "U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.")
        @ValueSource(strings = {"u", "d", "UD", "DU", " ", "abc"})
        void inputMovingException(String moving) {
            assertThatThrownBy(() -> inputValidator.validateInputMoving(moving))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("게임 재시작/종료 여부 입력 테스트")
    @Nested
    class ValidateInputGameCommand {
        @ParameterizedTest(name = "R(재시작)과 Q(종료) 중 하나의 문자를 입력할 수 있다.")
        @ValueSource(strings = {"R", "Q"})
        void inputGameCommand(String gameCommand) {
            assertDoesNotThrow(() -> inputValidator.validateInputGameCommand(gameCommand));
        }

        @ParameterizedTest(name = "R(재시작)과 Q(종료) 중 하나의 문자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.")
        @NullAndEmptySource
        @ValueSource(strings = {"r", "q", "Rq", "Qr", "ab", "cd"})
        void inputGameCommandException(String gameCommand) {
            assertThatThrownBy(() -> inputValidator.validateInputGameCommand(gameCommand))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
