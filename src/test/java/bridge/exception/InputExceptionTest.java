package bridge.exception;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputExceptionTest {

    @DisplayName("다리 길이 입력이 정상 작동한다.")
    @Test
    void bridgeSizeInputError_테스트() {
        int testBridgeSize = InputException.bridgeSizeInputError("7");
        assertEquals(testBridgeSize, 7);
    }

    @DisplayName("다리 길이 입력이 숫자가 아닐 때 예외를 발생한다.")
    @Test
    void bridgeSizeTypeError_에외_테스트() {
        assertThatThrownBy(() -> InputException.bridgeSizeTypeError("3a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 입력이 범위를 벗어날 때 예외를 발생한다.")
    @Test
    void bridgeSizeRangeError_예외_테스트() {
        assertThatThrownBy(() -> InputException.bridgeSizeRangeError(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸 입력 오류 시 예외를 발생한다.")
    @Test
    void movingInputError_예외_테스트() {
        assertThatThrownBy(() -> InputException.movingInputError("X"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시도 여부 입력 오류 시 예외를 발생한다.")
    @Test
    void gameCommandInputError_예외_테스트() {
        assertThatThrownBy(() -> InputException.gameCommandInputError("O"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}