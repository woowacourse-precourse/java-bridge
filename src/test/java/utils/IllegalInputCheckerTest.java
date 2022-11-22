package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IllegalInputCheckerTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void checkMoveInputTest() {
        IllegalInputChecker illegalInputChecker = new IllegalInputChecker();
        String moveInput = "U";

        String actual = illegalInputChecker.checkMoveInput(moveInput);
        String expect = "U";

        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("사용자가 U,D 외에 다른 것을 입력한 경우")
    @Test
    void checkMoveInput_exception() {
        IllegalInputChecker illegalInputChecker = new IllegalInputChecker();
        String moveInput = "*";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            illegalInputChecker.checkMoveInput(moveInput);
        });
    }

    @DisplayName("사용자가 다리 사이즈를 숫자 외에 다른 것을 입력한 경우")
    @Test
    void checkBridgeSizeInput_exception() {
        IllegalInputChecker illegalInputChecker = new IllegalInputChecker();
        String bridgeSize = "T";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            illegalInputChecker.checkBridgeSizeInput(bridgeSize);
        });
    }

    @DisplayName("사용자가 다리 사이즈를 3-20 범위 외에 다른 것을 입력한 경우")
    @Test
    void checkBridgeSizeInput_exception_out_of_range() {
        IllegalInputChecker illegalInputChecker = new IllegalInputChecker();
        String bridgeSize = "22";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            illegalInputChecker.checkBridgeSizeInput(bridgeSize);
        });
    }






}
