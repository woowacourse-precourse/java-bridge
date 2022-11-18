package bridge.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    private Validator validator;

    public ValidatorTest() {
        validator = new Validator();
    }

    @DisplayName("다리길이 유효성 검사 정상 입력")
    @Test
    void valid_number() {
        String bridge_size = "10";
        int answer = 10;
        int bridge_int = validator.canCreateBridge(bridge_size);

        assertEquals(answer, bridge_int);
    }

    @DisplayName("문자를 숫자로 바꿀시 예외처리")
    @Test
    void string_change_int_error() {
        String bridge_size = "abcd";

        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    int answer = validator.toInt(bridge_size);
                }),
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    int answer = validator.canCreateBridge(bridge_size);
                })
        );
    }

    @DisplayName("3이상 20이하 숫자가 아닐경우 에러 처리")
    @Test
    void not_three_between_twenty_error() {
        int bridge_size = 21;
        String str_bridge_size = "21";

        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    validator.checkCreateBridgeSize(bridge_size);
                }),
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    validator.canCreateBridge(str_bridge_size);
                })
        );
    }
}