package bridge.view.input;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 입력이_숫자와_문자가_섞여있다면_예외_발생() {
        assertThatThrownBy(() -> InputValidator.checkBridgeSizeOrElseThrowException("12k"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력이_문자라면_예외_발생() {
        assertThatThrownBy(() -> InputValidator.checkBridgeSizeOrElseThrowException("sdgds"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력이_공백이라면_예외_발생() {
        assertThatThrownBy(() -> InputValidator.checkBridgeSizeOrElseThrowException("     "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력이_아무것도_없다면_예외_발생() {
        assertThatThrownBy(() -> InputValidator.checkBridgeSizeOrElseThrowException(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력이_범위를_벗어난_양수라면_예외_발생() {
        assertThatThrownBy(() -> InputValidator.checkBridgeSizeOrElseThrowException("50"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력이_범위를_벗어난_음수라면_예외_발생() {
        assertThatThrownBy(() -> InputValidator.checkBridgeSizeOrElseThrowException("-124"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력이_범위내의_숫자라면_성공() {
        assertThatNoException()
                .isThrownBy(() -> InputValidator.checkBridgeSizeOrElseThrowException("15"));
    }
}