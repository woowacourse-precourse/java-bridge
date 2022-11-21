package bridge.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameValidationTest {
    private BridgeGameValidation bridgeGameValidation;

    @BeforeEach
    public void initialize() {
        bridgeGameValidation = new BridgeGameValidation();
    }

    @DisplayName("이동 가능한 칸이지만 이동하지 않은 경우, 예외가 발생한다.")
    @Test
    public void validateMoveWhenAvailableTest() {
        assertThatThrownBy(() -> bridgeGameValidation.validateMoveWhenAvailable("U", "U", List.of("X")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동 불가능한 칸으로 이동한 경우, 예외가 발생한다.")
    @Test
    public void validateNotMoveWhenUnavailableTest() {
        assertThatThrownBy(() -> bridgeGameValidation.validateNotMoveWhenUnavailable("U", "D", List.of("O")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
