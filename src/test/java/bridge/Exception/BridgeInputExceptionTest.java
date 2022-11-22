package bridge.Exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BridgeInputExceptionTest {

    BridgeInputException bridgeInputException = new BridgeInputException();

    @ParameterizedTest
    @ValueSource(strings = {"A", "1", "끝", "", " "})
    @DisplayName("재시작/종료 여부가 R 또는 Q가 아닌 다른 문자일 때 예외 처리")
    void validInputFormRetry(String retry) {
        assertThatThrownBy(() -> bridgeInputException.validBridgeRetry(retry))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"RQ", "RR", "R ", "Q "})
    @DisplayName("재시작/종료 여부가 두글자 이상의 문자일 때 예외 처리")
    void validInputSizeRetry(String retry) {
        assertThatThrownBy(() -> bridgeInputException.validBridgeRetry(retry))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"k", "five", " ", "삼"})
    @DisplayName("다리 길이가 숫자가 아닐 때 예외 처리")
    void validInputFormLength(String length) {
        assertThatThrownBy(() -> bridgeInputException.validBridgeLength(length))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2999", "21", "2"})
    @DisplayName("다리 길이가 3 이상 20 이하가 아니면 예외 처리")
    void validInputRangeLength(String length) {
        assertThatThrownBy(() -> bridgeInputException.validBridgeLength(length))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"앞", "u", "d", "1", " "})
    @DisplayName("사용자의 이동 방향이 U 또는 D가 아닌 문자일 때 예외 처리")
    void validInputFormMove(String move) {
        assertThatThrownBy(() -> bridgeInputException.validMoveDirection(move))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"UU", "DD", "UD", "UDU"})
    @DisplayName("사용자의 이동 방향이 두글자 이상의 문자일 때 예외처리")
    void validInputSizeMove(String move) {
        assertThatThrownBy(() -> bridgeInputException.validMoveDirection(move))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

