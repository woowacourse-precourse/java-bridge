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
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("업 다운 버튼이 유효한지에 대한 검사")
    @Test
    void checkReadMoving() {
        String moveButton = "Uk";
        assertThatThrownBy(() -> validateUserInput.checkReadMoving(moveButton))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("재시작 종료 버튼이 유효한지에 대한 검사")
    @Test
    void checkGameCommand() {
        String commandButton = "12";
        assertThatThrownBy(() -> validateUserInput.checkGameCommand(commandButton))
                .isInstanceOf(IllegalArgumentException.class);
    }
}