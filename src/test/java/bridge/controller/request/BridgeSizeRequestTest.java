package bridge.controller.request;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeSizeRequestTest {

    @Test
    @DisplayName("다리 길이에 대한 옳바른 입력값 확인")
    void VALIDATION() {

        assertAll(
                () -> assertThatThrownBy(() -> new BridgeSizeRequest("ABC"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("길이는 숫자타입이어야 합니다."),
                () -> assertThatThrownBy(() -> new BridgeSizeRequest("1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("길이는 3 이상이어야 합니다."),
                () -> assertThatThrownBy(() -> new BridgeSizeRequest("21"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("길이는 20 이하이어야 합니다.")
        );

    }

}