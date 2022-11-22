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

    @DisplayName("이동하는 방향이 U 또는 D인지 확인한다")
    @Test
    void validateBridgeStep() {
        assertThrows(IllegalArgumentException.class, () -> InputViewValidator.validateBridgeStep("N"));
        assertThrows(IllegalArgumentException.class, () -> InputViewValidator.validateBridgeStep("UU"));
        assertThrows(IllegalArgumentException.class, () -> InputViewValidator.validateBridgeStep("DD"));
        assertThrows(IllegalArgumentException.class, () -> InputViewValidator.validateBridgeStep("UD"));
        assertThrows(IllegalArgumentException.class, () -> InputViewValidator.validateBridgeStep("DU"));
        assertThrows(IllegalArgumentException.class, () -> InputViewValidator.validateBridgeStep(""));
        InputViewValidator.validateBridgeStep("U");
        InputViewValidator.validateBridgeStep("D");
    }

    @DisplayName("재시작 명령어가 R 또는 Q인지 확인한다.")
    @Test
    void validateRestartCommand() {
        assertThrows(IllegalArgumentException.class, () -> InputViewValidator.validateRestartCommand("123"));
        assertThrows(IllegalArgumentException.class, () -> InputViewValidator.validateRestartCommand("RQ"));
        assertThrows(IllegalArgumentException.class, () -> InputViewValidator.validateRestartCommand("RR"));
        assertThrows(IllegalArgumentException.class, () -> InputViewValidator.validateRestartCommand("QQ"));
        assertThrows(IllegalArgumentException.class, () -> InputViewValidator.validateRestartCommand("QR"));
        assertThrows(IllegalArgumentException.class, () -> InputViewValidator.validateRestartCommand("rq"));
        InputViewValidator.validateRestartCommand("R");
        InputViewValidator.validateRestartCommand("Q");

    }
}