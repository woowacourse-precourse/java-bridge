package bridge.cache;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeStatusSaverTest {

    @DisplayName("안에 데이터가 없을 때 요청시 예외 발생")
    @Test
    void throwExceptionWhenDataNotExist() {
        // given
        BridgeStatusSaver bridgeStatusSaver = new BridgeStatusSaver();

        // expect
        assertThatThrownBy(bridgeStatusSaver::getBridgeStatus).isInstanceOf(IllegalStateException.class);
    }
}