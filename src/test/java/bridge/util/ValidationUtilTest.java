package bridge.util;

import bridge.enums.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationUtilTest {

    @DisplayName("다리의 길이는 3이상 20 이하의 숫자이다.")
    @Nested
    class BridgeLengthTest {
        @Test
        void valid() {
            ValidationUtil.isValidBridgeLength("3");
            ValidationUtil.isValidBridgeLength("20");
        }

        @ValueSource(strings = {"-1", "0", "2", "21", "a", "!", "999999999999999999999999999999999999999999999999999999999999999999999"})
        @ParameterizedTest
        void inValid(String input) {
            assertThatThrownBy(() -> ValidationUtil.isValidBridgeLength(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_LENGTH.getValue());
        }
    }

    @DisplayName("U 혹은 D인지 확인한다.")
    @Nested
    class isUpOrDownTest {
        @Test
        void valid() {
            ValidationUtil.isUpOrDown("U");
            ValidationUtil.isUpOrDown("D");
        }

        @ValueSource(strings = {"R", "Q", "A", "10", "-10", "*", "!"})
        @ParameterizedTest
        void inValid(String input) {
            assertThatThrownBy(() -> ValidationUtil.isUpOrDown(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_INPUT.getValue());
        }
    }


    @DisplayName("R 혹은 Q인지 확인한다.")
    @Nested
    class isRetryOrQuitTest {
        @Test
        void valid() {
            ValidationUtil.isRetryOrQuit("R");
            ValidationUtil.isRetryOrQuit("Q");
        }

        @ValueSource(strings = {"U", "D", "A", "10", "-10", "*", "!"})
        @ParameterizedTest
        void inValid(String input) {
            assertThatThrownBy(() -> ValidationUtil.isRetryOrQuit(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_INPUT.getValue());
        }
    }
}