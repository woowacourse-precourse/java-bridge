package bridge.view.input;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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


    @ParameterizedTest
    @ValueSource(strings = {"u", "   ", " U", "d", "A", "B", "S", "s", "b", "a"})
    void 방향_입력이_U_또는_D가_아니라면_예외_발생(String direction) {
        assertThatThrownBy(() -> InputValidator.checkDirectionOrElseThrowException(direction))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 방향_입력이_U_라면_성공() {
        assertThatNoException()
                .isThrownBy(() -> InputValidator.checkDirectionOrElseThrowException("U"));

    }

    @Test
    void 방향_입력이_D_라면_성공() {
        assertThatNoException()
                .isThrownBy(() -> InputValidator.checkDirectionOrElseThrowException("D"));

    }

    @ParameterizedTest
    @ValueSource(strings = {"u", "   ", " R", "Q  ", "d", "A", "B", "S", "s", "b", "a"})
    void 재시작_입력이_R_또는_Q가_아니라면_예외_발생(String retry) {
        assertThatThrownBy(() -> InputValidator.checkRetryOrElseThrowException(retry))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 재시작_입력이_R_이라면_성공() {
        assertThatNoException()
                .isThrownBy(() -> InputValidator.checkRetryOrElseThrowException("R"));
    }

    @Test
    void 재시작_입력이_Q_이라면_성공() {
        assertThatNoException()
                .isThrownBy(() -> InputValidator.checkRetryOrElseThrowException("Q"));
    }
}