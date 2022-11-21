package bridge.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class BridgeControllerTest {
    ValidateInput validate;
    @BeforeEach
    void beforeEach() {
        validate = new ValidateInput();
    }

    @DisplayName("다리의 길이를 숫자로 입력 받지 않는 경우 예외처리.")
    @Test
    void inputBridgeLengthByNotNumeric() {
        assertThatThrownBy(() -> validate.checkNumeric("h"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("이동할 때 다른 문자가 입력 되는 경우 이중 예외처리.")
    @Test
    void inputMoveLetterByAnotherLetter() {
        assertThatThrownBy(() -> validate.checkLetter("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임이 실패 하고 다른 문자가 입력 되는 경우 예외처리.")
    @Test
    void inputEndLetterByAnotherLetter() {
        assertThatThrownBy(() -> validate.checkEndLetter("b"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}