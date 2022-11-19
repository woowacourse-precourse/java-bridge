package bridge.views;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void validateBridgeSize_숫자_아닌_입력_예외_발생() {
        assertThatThrownBy(() -> Validator.validateBridgeSize("4d"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자를 입력해주세요.");
    }

    @Test
    void validateBridgeSize_음수_입력_예외_발생() {
        assertThatThrownBy(() -> Validator.validateBridgeSize("-2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이는 3부터 20사이의 숫자여야 합니다.");
    }

    @Test
    void validateBridgeSize_범위_벗어난_입력_예외_발생() {
        assertThatThrownBy(() -> Validator.validateBridgeSize("23"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이는 3부터 20사이의 숫자여야 합니다.");
    }
}