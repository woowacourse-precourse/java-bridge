package bridge;

import bridge.util.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();

    @ParameterizedTest
    @DisplayName("다리 길이 입력값이 3~20 을 벗어나는 경우 오류")
    @ValueSource(strings = {"2", "21", "-3", "a", "bb"})
    void validateBridgeLengthTest(String input) {
        assertThatThrownBy(()->inputValidator.validateBridgeLength(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("이동할 칸의 입력이 D,U 가 아닐 경우 오류")
    @ValueSource(strings = {"G", "A", "123", "~!"})
    void validateMovingTest(String input) {
        assertThatThrownBy(()->inputValidator.validateMoving(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("게임 재시작 여부 입력이 R,Q가 아닌 경우 오류")
    @ValueSource(strings = {"A","E","3","~!"})
    void validateGameCommand(String input) {
        assertThatThrownBy(()->inputValidator.validateGameCommand(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    

}