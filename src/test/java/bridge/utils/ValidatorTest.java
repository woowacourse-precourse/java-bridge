package bridge.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidatorTest {
    @Test
    void validateBridgeSize_숫자_아닌_입력_예외_발생() {
        assertThatThrownBy(() -> Validator.validateBridgeSize("4d"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.NOT_NUMBER_EXCEPTION);
    }

    @Test
    void validateBridgeSize_음수_입력_예외_발생() {
        assertThatThrownBy(() -> Validator.validateBridgeSize("-2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.INVALID_RANGE_EXCEPTION);
    }

    @Test
    void validateBridgeSize_범위_벗어난_입력_예외_발생() {
        assertThatThrownBy(() -> Validator.validateBridgeSize("23"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.INVALID_RANGE_EXCEPTION);
    }

    @Test
    void isUOrD_다른_영문자_입력_예외_발생() {
        assertThatThrownBy(() -> Validator.isUOrD("X"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.INVALID_UP_OR_DOWN_EXCEPTION);
    }

    @Test
    void isUOrD_소문자_입력_예외_발생() {
        assertThatThrownBy(() -> Validator.isUOrD("d"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.INVALID_UP_OR_DOWN_EXCEPTION);
    }

    @Test
    void isROrQ_다른_영문자_입력_예외_발생() {
        assertThatThrownBy(() -> Validator.isROrQ("Y"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.INVALID_RESTART_OR_QUIT_EXCEPTION);
    }

    @Test
    void isROrQ_소문자_입력_예외_발생() {
        assertThatThrownBy(() -> Validator.isROrQ("q"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.INVALID_RESTART_OR_QUIT_EXCEPTION);
    }
}