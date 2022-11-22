package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    private final BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("게임을 시작하면 시도 횟수가 1증가 함을 확인")
    @Test
    void checkIncreaseTryCount() {
        bridgeGame.start();
        int tryCount = bridgeGame.getBridgeGameResult().getTryCount();
        assertThat(tryCount).isEqualTo(1);
    }

    @DisplayName("입력 길이만큼 다리 생성 확인")
    @Test
    void makeBridge() {
        bridgeGame.make(3);
        int bridgeSize = bridgeGame.getBridge().size();
        assertThat(bridgeSize).isEqualTo(3);
    }
}
