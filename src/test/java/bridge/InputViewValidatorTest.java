package bridge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewValidatorTest {

    @DisplayName("문자열(String)이 정수 형태를 갖추고 있는 지 확인한다.")
    @Test
    void validateNumberFormat() {
        assertThrows(IllegalArgumentException.class, () -> InputViewValidator.validateNumberFormat("123f"));
        InputViewValidator.validateNumberFormat("123");
    }

    @DisplayName("정수가 다리의 길이를 만족하는 지 확인한다.")
    @Test
    void validateBridgeLength() {
        assertThrows(IllegalArgumentException.class, () -> InputViewValidator.validateBridgeLength(100));
        assertThrows(IllegalArgumentException.class, () -> InputViewValidator.validateBridgeLength(30));
        assertThrows(IllegalArgumentException.class, () -> InputViewValidator.validateBridgeLength(2));
        assertThrows(IllegalArgumentException.class, () -> InputViewValidator.validateBridgeLength(-3));
        assertThrows(IllegalArgumentException.class, () -> InputViewValidator.validateBridgeLength(0));
        InputViewValidator.validateBridgeLength(3);
        InputViewValidator.validateBridgeLength(4);
        InputViewValidator.validateBridgeLength(5);
    }
}