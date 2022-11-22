package bridge.controller.request;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import bridge.domain.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameRequestTest {

    @Test
    @DisplayName("재시도 여부를 붇는 메시지 검증 확인 테스트")
    void VALIDATION() {
        assertThatThrownBy(() -> new GameRequest("A"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 R, Q 만 가능합니다.");
    }

    @Test
    @DisplayName("재시도 여부를 확인하는 기능 테스트")
    void USER_WANT_RETRY() {
        GameRequest request = new GameRequest("R");
        assertThat(request.wantRetry()).isEqualTo(true);
    }

}