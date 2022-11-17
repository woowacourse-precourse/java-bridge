package bridge;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateUserInputTest {
    ValidateUserInput validateUserInput = new ValidateUserInput();

    @DisplayName("다리 길이가 유효한지에 대한 검사")
    @Test
    void checkBridgeLength() {
        String bridgeLength = "2,1";
        assertThatThrownBy(() -> validateUserInput.checkBridgeLength(bridgeLength))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void checkReadMoving() {
        String moveButton = "Uk";
        assertThatThrownBy(() -> validateUserInput.checkReadMoving(moveButton))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}