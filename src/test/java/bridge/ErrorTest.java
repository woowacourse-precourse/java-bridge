package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ErrorTest {

    @DisplayName("다리 길이 입력이 숫자가 아닌 경우")
    @Test
    void validateBridgeSizeNotNum() {
        assertThatThrownBy(() -> Error.validateBridgeSizeIsWrong("ㄱ"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 입력이 범위 내의 값이 아닌 경우")
    @Test
    void validateBridgeSizeNotInBoundary() {
        assertThatThrownBy(() -> Error.validateBridgeSizeIsWrong("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
