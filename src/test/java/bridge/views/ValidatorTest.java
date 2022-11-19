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

    @Test
    void isUOrD_다른_영문자_입력_예외_발생() {
        assertThatThrownBy(() -> Validator.isUOrD("X"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] (위: U, 아래: D) 두 영어 대문자 중 하나를 입력해주세요.");
    }

    @Test
    void isUOrD_소문자_입력_예외_발생() {
        assertThatThrownBy(() -> Validator.isUOrD("d"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] (위: U, 아래: D) 두 영어 대문자 중 하나를 입력해주세요.");
    }

    @Test
    void isROrQ_다른_영문자_입력_예외_발생() {
        assertThatThrownBy(() -> Validator.isROrQ("Y"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] (재시도: R, 종료: Q) 두 영어 대문자 중 하나를 입력해주세요.");
    }

    @Test
    void isROrQ_소문자_입력_예외_발생() {
        assertThatThrownBy(() -> Validator.isROrQ("q"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] (재시도: R, 종료: Q) 두 영어 대문자 중 하나를 입력해주세요.");
    }
}