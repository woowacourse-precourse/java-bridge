package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidateInputTest {

    private ValidateInput validateInput;

    @BeforeEach
    void setUp() {
        validateInput = new ValidateInput();
    }

    @Test
    void 다리_길이가_3부터_20사이의_숫자가_아니라면_예외_발생() {
        assertThatThrownBy(() -> validateInput.validateBetween("25"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    @Test
    void 다리_길이가_숫자가_아닌_문자를_입력_하였을_경우_예외_발생() {
        assertThatThrownBy(() -> validateInput.validateNumber("d"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 문자를 입력 하였습니다.");
    }

    @Test
    void 이동할_칸을_입력시_U_D가_아닌_다른값을_입력하였다면_예외_발생() {
        assertThatThrownBy(() -> validateInput.validateUpAndDownCharacter("H"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("U/D중 하나의 문자를 입력할 수 있습니다.");
    }

    @Test
    void 게임을_다시_시도할지_R_Q가_아닌_다른값을_입력하였다면_예외_발생() {
        assertThatThrownBy(() -> validateInput.validateRestartAndEndCharacter("U"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("R/Q중 하나의 문자를 입력할 수 있습니다.");
    }
}