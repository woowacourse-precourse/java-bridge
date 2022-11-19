package bridge.validate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.validate.ValidateInput.validateBridgeSize;
import static org.junit.jupiter.api.Assertions.*;

class ValidateInputTest {

    @DisplayName("입력받은 다리 길이가 정수가 아니거나, 입력받은 3이상 20이하의 수가 아니라면 예외가 발생한다.")
    @Test
    void 다리길이가_정수가_아니거나_3이상_20이하의_수가_아니면_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            validateBridgeSize("10d");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            validateBridgeSize("21");
        });
    }


    @DisplayName("이동할 블럭을 입력 받을 때 1자리의 문자열이 아니거나, U 또는 D 이외의 문자 입력시 예외가 발생한다.")
    @Test
    void 이동할_블럭이_1자리_문자열이_아니거나_U_또는_D가_아니라면_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValidateInput.validateMovingBlock("UU");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            ValidateInput.validateMovingBlock("S");
        });
    }

    @DisplayName("게임 재시작 여부를 입력받을 때 1자리의 문자열이 아니거나, R 또는 Q 이외의 문자 입력시 예외가 발생한다.")
    @Test
    void 게임_재시작_여부가_1자리_문자열이_아니거나_R_또는_Q가_아니라면_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValidateInput.validateMovingBlock("RR");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            ValidateInput.validateMovingBlock("A");
        });
    }
}