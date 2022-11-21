package bridge;

import bridge.domain.BridgeGameManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameManagerTest {
    private BridgeGameManager bridgeGameManager;

    @BeforeEach
    void setBridgeGameManager() {
        bridgeGameManager = new BridgeGameManager();
    }

    @Test
    void 생성_테스트() {
        assertThat(bridgeGameManager.getCount()).isEqualTo(1);
        assertThat(bridgeGameManager.getStep()).isEqualTo(0);
    }

    @Test
    void 횟수_테스트() {
        bridgeGameManager.increaseCount();
        assertThat(bridgeGameManager.getCount()).isEqualTo(2);
    }

    @Test
    void 위치_테스트() {
        bridgeGameManager.increaseStep();
        assertThat(bridgeGameManager.getStep()).isEqualTo(1);
    }
}
