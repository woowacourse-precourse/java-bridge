package bridge;

import bridge.service.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @DisplayName("다리 길이 입력 중 문자 입력시, 에러 발생 테스트")
    @Test
    void checkNotIntegerTest() {
        assertThatThrownBy(() -> Validator.checkInteger("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 입력 중 음수 입력시, 에러 발생 테스트")
    @Test
    void checkNotPositiveTest() {
        assertThatThrownBy(() -> Validator.checkRange(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 입력 중 양수 입력이지만 범위 벗어난 경우, 에러 발생 테스트")
    @Test
    void checkNotRangeTest() {
        assertThatThrownBy(() -> Validator.checkRange(21))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸 입력 중 U나 D가 아닌 경우, 에러 발생 테스트")
    @Test
    void checkMoveUpDownTest() {
        assertThatThrownBy(() -> Validator.checkUpDown("UU"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다시 시도 여부 입력 중 R이나 Q가 아닌 경우, 에러 발생 테스트")
    @Test
    void checkRetryQuitTest() {
        assertThatThrownBy(() -> Validator.checkRetryQuit("RR"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}