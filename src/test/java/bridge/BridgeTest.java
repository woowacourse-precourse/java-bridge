package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.Bridge.ValidBridgeInput;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeTest {
    @DisplayName("Bridge 길이가 숫자가 아닌 경우 예외가 발생한다")
    @Test
    void bridgeSizeNotNumeric() {
        assertThatThrownBy(() -> {
            ValidBridgeInput.checkBridgeSizeNumeric("bridgeSizeInput");
            ValidBridgeInput.checkBridgeSizeValid("bridgeSizeInput");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Bridge 길이가 3~20의 범위를 벗어날 경우 예외가 발생한다")
    @Test
    void bridgeSizeOutOfRange() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> {
            ValidBridgeInput.checkBridgeSizeNumeric("30");
            ValidBridgeInput.checkBridgeSizeValid("30");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
}
