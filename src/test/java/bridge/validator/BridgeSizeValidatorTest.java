package bridge.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeSizeValidatorTest {

    @DisplayName("공백 입력시 예외가 발생한다.")
    @Test
    void inputBridgeSizeBlankTest() {
        assertThrows(IllegalArgumentException.class, () -> BridgeSizeValidator.validate(""));
    }

    @DisplayName("다리길이가 3보다 작거나 20보다 크면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "21", "22"})
    void inputBridgeSizeUnderOrOverTest(String size) {
        assertThrows(IllegalArgumentException.class, () -> BridgeSizeValidator.validate(size));
    }

    @DisplayName("다리길이가 숫자가 아닌경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "3.1", "19.1"})
    void inputBridgeSizeDigitTest(String size) {
        assertThrows(IllegalArgumentException.class, () -> BridgeSizeValidator.validate(size));
    }

    @DisplayName("다리 생성 테스트 성공")
    @ParameterizedTest
    @ValueSource(strings = {"3", "4", "19", "20"})
    void inputBridgeSizeSuccessTest(String size) {
        assertDoesNotThrow(() -> BridgeSizeValidator.validate(size));
    }
}
