package bridge;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeTest {
    @DisplayName("다리 길이가 정상인 경우에 대한 테스트")
    @ValueSource(strings = {"3", "15", "20"})
    @ParameterizedTest
    void correctBridgeSize(String input) {
        Validation validation = new Validation();
        assertFalse(validation.isCheckNotDigit(input));
        assertThatCode(() -> validation.validateBridgeSize(Integer.parseInt(input)))
                .doesNotThrowAnyException();
    }

    @DisplayName("다리 길이가 숫자가 아닌 경우에 대한 예외 테스트")
    @ValueSource(strings = {"삼", "three", " "})
    @ParameterizedTest
    void notDigitBridgeSize(String input) {
        Validation validation = new Validation();
        assertTrue(validation.isCheckNotDigit(input));
    }

    @DisplayName("다리 길이가 3부터 20 사이가 아닌 경우에 대한 예외 테스트")
    @ValueSource(ints = {-2, 1, 30})
    @ParameterizedTest
    void wrongRangeBridgeSize(int input) {
        Validation validation = new Validation();
        assertThatThrownBy(() -> validation.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}