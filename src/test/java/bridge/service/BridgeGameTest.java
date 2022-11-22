package bridge.service;

import static org.assertj.core.api.Assertions.*;

import bridge.domain.Bridge;
import bridge.domain.TryCount;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    @Test
    void 이동_메소드_실행시_위치_1추가() {
        Bridge bridge = new Bridge(0, List.of("U", "D", "U"));
        BridgeGame.move(bridge);
        assertThat(bridge.getBridgePosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("재시작시 시도 횟수 증가")
    void retry_removeFailSpot() {
        Bridge bridge = new Bridge(0, List.of("U", "D", "U"));
        bridge.addResult("D");
        TryCount tryCount = TryCount.initCount();
        TryCount newTryCount = BridgeGame.retry(bridge, tryCount);
        assertThat(newTryCount.getCount()).isEqualTo(2);
    }
}
