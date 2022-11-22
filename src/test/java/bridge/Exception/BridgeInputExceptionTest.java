package bridge.Exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BridgeInputExceptionTest {

    BridgeInputException bridgeInputException = new BridgeInputException();

    @ParameterizedTest
    @ValueSource(strings = {"A", "1", "끝", " "})
    @DisplayName("재시작/종료 여부가 R 또는 Q가 아닌 다른 문자일 때 예외 처리")
    void validInputFormRetry(String retry) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> bridgeInputException.validBridgeRetry(retry));
        assertEquals("[ERROR] 재시작/종료 여부는 R 또는 Q만 입력하세요", e.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"RQ", "RR", "RRR", "QRQ"})
    @DisplayName("재시작/종료 여부가 두글자 이상의 문자일 때 예외 처리")
    void validInputSizeRetry(String retry) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> bridgeInputException.validBridgeRetry(retry));
        assertEquals("[ERROR] 재시작/종료 여부는 한 문자로 입력하세요.", e.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"k", "five", " ", "삼"})
    @DisplayName("다리 길이가 숫자가 아닐 때 예외 처리")
    void validInputFormLength(String length) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> bridgeInputException.validBridgeLength(length));
        assertEquals("[ERROR] 다리의 길이는 숫자만 입력하세요.", e.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"2999", "21", "2"})
    @DisplayName("다리 길이가 3 이상 20 이하가 아니면 예외 처리")
    void validInputRangeLength(String length) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> bridgeInputException.validBridgeLength(length));
        assertEquals("[ERROR] 다리의 길이는 3 이상 20 이하의 숫자입니다.", e.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"앞", "u", "d", "1", " "})
    @DisplayName("사용자의 이동 방향이 U 또는 D가 아닌 문자일 때 예외 처리")
    void validInputFormMove(String move) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> bridgeInputException.validMoveDirection(move));
        assertEquals("[ERROR] 이동할 칸은 U 또는 D만 입력하세요.", e.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"UU", "DD", "UD", "UDU"})
    @DisplayName("사용자의 이동 방향이 두글자 이상의 문자일 때 예외처리")
    void validInputSizeMove(String move) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> bridgeInputException.validMoveDirection(move));
        assertEquals("[ERROR] 이동할 칸은 한 문자만 입력하세요.", e.getMessage());
    }
}

