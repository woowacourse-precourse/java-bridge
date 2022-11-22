package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest {

    @DisplayName("숫자가 아닌 경우")
    @Test
    void validateBridgeSizeNotNum() {
        assertThatThrownBy(() -> Exception.validateBridgeSize("ㄱ"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력이 범위 값이 아닌 경우")
    @Test
    void validateBridgeSizeNotInBoundary() {
        assertThatThrownBy(() -> Exception.validateBridgeSize("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("U,D 가 아닌 경우")
    @Test
    void validatePlayerMove() {
        assertThatThrownBy(() -> Exception.validatePlayerMove("R"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("R, Q가 아닌 경우")
    @Test
    void validateGameProgress() {
        assertThatThrownBy(() -> Exception.validateGameProgress("U"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
