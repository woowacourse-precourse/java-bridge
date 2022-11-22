package bridge.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BridgeSizeValidatorTest {

    @DisplayName("다리 길이 유효성 검사 - 공백 예외")
    @Test
    void inputBridgeSizeBlankTest() {
        assertThrows(IllegalArgumentException.class, () -> BridgeSizeValidator.validate(""));
    }

    @DisplayName("다리 길이 유효성 검사 - 3 미만, 20 초과시 예외")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "31", "41"})
    void inputBridgeSizeUnderOrOverTest(String size) {
        assertThrows(IllegalArgumentException.class, () -> BridgeSizeValidator.validate(size));
    }

    @DisplayName("다리 길이 유효성 검사 - 정 수숫자가 아닌 경우 예외")
    @ParameterizedTest
    @ValueSource(strings = {"kim", "jong", "chan", "3.3"})
    void inputBridgeSizeDigitTest(String size) {
        assertThrows(IllegalArgumentException.class, () -> BridgeSizeValidator.validate(size));
    }

    @DisplayName("다리 길이 유효성 검사 테스트 - 성공")
    @ParameterizedTest
    @ValueSource(strings = {"3", "7", "9", "20"})
    void inputBridgeSizeSuccessTest(String size) {
        assertDoesNotThrow(() -> BridgeSizeValidator.validate(size));
    }

}