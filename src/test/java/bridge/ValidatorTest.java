package bridge;

import bridge.error.ErrorMessage;
import bridge.util.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Nested
    class IsNumber {
        @DisplayName("입력값이 숫자로 변환되는 경우 변환된 값을 반환한다.")
        @Test
        void inputByNumber() {
            // given
            String input = "4";

            // when
            int number = Validator.isNumber(input);

            // then
            Assertions.assertThat(number).isEqualTo(Integer.parseInt(input));
        }

        @DisplayName("입력값이 숫자로 변환되지 않는 경우 예외를 반환한다.")
        @Test
        void inputByString() {
            String input = "adf";

            Assertions.assertThatThrownBy(() -> Validator.isNumber(input))
                    .hasMessageContaining(ErrorMessage.NOT_NUMBER_BRIDGE_SIZE.getMessage())
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class IsInRange {
        @DisplayName("입력 숫자가 3 ~ 20 사이라면 예외를 반환하지 않는다.")
        @Test
        void inputByNumber() {
            Assertions.assertThatNoException()
                    .isThrownBy(() -> Validator.isInRange(6));
        }

        @DisplayName("입력 숫자가 3 ~ 20 사이가 아니라면 예외를 반환한다.")
        @Test
        void inputByString() {
            Assertions.assertThatThrownBy(() -> Validator.isInRange(24))
                    .hasMessageContaining(ErrorMessage.INVALID_BRIDGE_SIZE.getMessage())
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class IsOneString {
        @DisplayName("입력값이 한 문자인 경우 예외를 반환하지 않는다.")
        @Test
        void movingOneString() {
            Assertions.assertThatNoException()
                    .isThrownBy(() -> Validator.isOneStringMoving("F"));
        }

        @DisplayName("입력값이 한 문자가 아닌 경우 예외를 반환한다.")
        @Test
        void movingNotOneString() {
            Assertions.assertThatThrownBy(() -> Validator.isOneStringMoving("ABC"))
                    .hasMessageContaining(ErrorMessage.NOT_ONE_STRING_MOVING.getMessage())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("입력값이 한 문자인 경우 예외를 반환하지 않는다.")
        @Test
        void commandOneString() {
            Assertions.assertThatNoException()
                    .isThrownBy(() -> Validator.isOneStringCommand("B"));
        }

        @DisplayName("입력값이 한 문자가 아닌 경우 예외를 반환한다.")
        @Test
        void commandNotOneString() {
            Assertions.assertThatThrownBy(() -> Validator.isOneStringCommand("GEG"))
                    .hasMessageContaining(ErrorMessage.NOT_ONE_STRING_COMMAND.getMessage())
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class IsUppercase {
        @DisplayName("입력값이 대문자인 경우 예외를 반환하지 않는다.")
        @Test
        void movingUppercaseString() {
            Assertions.assertThatNoException()
                    .isThrownBy(() -> Validator.isUppercaseMoving("F"));
        }

        @DisplayName("입력값이 대문자가 아닌 경우 예외를 반환한다.")
        @Test
        void movingNotOneString() {
            Assertions.assertThatThrownBy(() -> Validator.isUppercaseMoving("d"))
                    .hasMessageContaining(ErrorMessage.NOT_UPPER_CASE_MOVING.getMessage())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("입력값이 대문자인 경우 예외를 반환하지 않는다.")
        @Test
        void commandUppercaseString() {
            Assertions.assertThatNoException()
                    .isThrownBy(() -> Validator.isUppercaseCommand("Y"));
        }

        @DisplayName("입력값이 대문자가 아닌 경우 예외를 반환한다.")
        @Test
        void commandNotOneString() {
            Assertions.assertThatThrownBy(() -> Validator.isUppercaseCommand("n"))
                    .hasMessageContaining(ErrorMessage.NOT_UPPER_CASE_COMMAND.getMessage())
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class IsUpOrDown {
        @DisplayName("입력값이 U 또는 D인 경우 예외를 반환하지 않는다.")
        @Test
        void inputOneString() {
            Assertions.assertThatNoException()
                    .isThrownBy(() -> Validator.isUpOrDown("U"));
        }

        @DisplayName("입력값이 U 또는 D가 아닌 경우 예외를 반환한다.")
        @Test
        void inputNotOneString() {
            Assertions.assertThatThrownBy(() -> Validator.isUpOrDown("R"))
                    .hasMessageContaining(ErrorMessage.U_OR_D_MOVING.getMessage())
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class IsRestartOrQuit {
        @DisplayName("입력값이 R 또는 Q인 경우 예외를 반환하지 않는다.")
        @Test
        void inputOneString() {
            Assertions.assertThatNoException()
                    .isThrownBy(() -> Validator.isRestartOrQuit("R"));
        }

        @DisplayName("입력값이 R 또는 Q가 아닌 경우 예외를 반환한다.")
        @Test
        void inputNotOneString() {
            Assertions.assertThatThrownBy(() -> Validator.isRestartOrQuit("C"))
                    .hasMessageContaining(ErrorMessage.R_OR_Q_COMMAND.getMessage())
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
