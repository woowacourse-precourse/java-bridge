package bridge;

import bridge.enums.ErrorMessage;
import bridge.util.ValidationUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class ValidationTest {

    @DisplayName("다리의 길이는 3이상 20 이하이다.")
    @Nested
    class BridgeLengthTest {
        @Test
        void valid() {
            ValidationUtil.isValidBridgeLength(3);
            ValidationUtil.isValidBridgeLength(20);
        }

        @ValueSource(strings = {"2", "21"})
        @ParameterizedTest
        void inValid(Integer input) {
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

        @ValueSource(strings = {"R", "Q", "A", "1", "*", "!"})
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

        @ValueSource(strings = {"U", "D", "A", "1", "*", "!"})
        @ParameterizedTest
        void inValid(String input) {
            assertThatThrownBy(() -> ValidationUtil.isRetryOrQuit(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_INPUT.getValue());
        }
    }
}
