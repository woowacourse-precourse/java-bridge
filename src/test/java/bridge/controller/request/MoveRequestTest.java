package bridge.controller.request;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoveRequestTest {

    @Test
    @DisplayName("사용자 이동 입력시 입력값 검증 테스트")
    void VALIDATION() {
        assertThatThrownBy(() -> new MoveRequest("A"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동시 입력값은 U, D 만 가능합니다.");
    }

}