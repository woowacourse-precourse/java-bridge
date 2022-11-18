package bridge;

import bridge.model.Error;
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

    @DisplayName("다리 이동이 U,D가 아닌 경우")
    @Test
    void validatePlayerMove() {
        assertThatThrownBy(() -> Error.validatePlayerMove("R"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("종료 재시작 선택이 R,Q가 아닌 경우")
    @Test
    void validateGameProgress() {
        assertThatThrownBy(() -> Error.validateGameProgress("U"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
