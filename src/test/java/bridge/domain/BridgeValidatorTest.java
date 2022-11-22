package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeValidatorTest {

    @DisplayName("[예외 발생] 다리 길이가 3~20 사이의 숫자가 아닌 문자열일 경우 IllegalArgumentException 발생")
    @Test
    void validateBridgeSizeByString() {
        String size = "asdf";
        BridgeValidator validator = new BridgeValidator();
        assertThatThrownBy(() -> validator.validateBridgeSize(size)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("[예외 발생] 다리 길이가 3~20의 숫자 범위를 벗어나는 경우 IllegalArumentException 발생")
    @Test
    void validateBridgeSizeByNumberRange() {
        String size = "21";
        BridgeValidator validator = new BridgeValidator();
        assertThatThrownBy(() -> validator.validateBridgeSize(size)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("[예외 발생] 이동 방향이 U나 D가 아닌 경우 IllegalArumentException 발생")
    @Test
    void validateMovingDirection() {
        String direction = "A";
        BridgeValidator validator = new BridgeValidator();
        assertThatThrownBy(() -> validator.validateMovingDirection(direction)).isInstanceOf(
            IllegalArgumentException.class);
    }
}
