package bridge.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserExceptionTest {

    @Test
    void 다리_길이_문자_예외_테스트() {
        assertThatThrownBy(() -> UserException.parseInt("3s"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리_길이_범위_예외_테스트() {
        assertThatThrownBy(() -> UserException.numberRange(21))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동_입력_예외_테스트() {
        assertThatThrownBy(() -> UserException.movingException("T"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시도_입력_예외_테스트() {
        assertThatThrownBy(() -> UserException.reGameException("T"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}