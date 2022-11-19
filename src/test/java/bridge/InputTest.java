package bridge;

import bridge.model.InputValidator;
import static bridge.util.ConvertData.convertStringIntoInt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class InputTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    InputValidator inputValidator = new InputValidator();


    @DisplayName("다리 길이 입력 테스트")
    @Nested
    class BridgeSize {

        @DisplayName("다리 길이가 3~20 사이가 아닌 경우 예외 발생")
        @ParameterizedTest
        @CsvSource(value = {"-1", "50"})
        void testBridgeSizeInRange(int input) {
            assertThatThrownBy(() -> inputValidator.BridgeSize(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("다리 길이가 숫자가 아닌 경우 예외 발생")
        @Test
        void testBridgeSizeIsNotNumber() {
            assertThatThrownBy(() -> convertStringIntoInt("A"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
