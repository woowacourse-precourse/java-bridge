package bridge.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeSizeExceptionTest {

    private BridgeSizeException bridgeSizeException = new BridgeSizeException();

    @Test
    @DisplayName("숫자로만 이루어져야 합니다.")
    void isBridgeSizeConsistOfOnlyNumber() {
        assertThatThrownBy(() -> bridgeSizeException.isBridgeSizeConsistOfNumber("a")).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("3이상 20이하의 숫자여야 합니다.")
    void isBridgeSizeInRightRange() {
        assertThatThrownBy(() -> bridgeSizeException.isBridgeSizeInRange(23)).isInstanceOf(
                IllegalArgumentException.class);
    }
}