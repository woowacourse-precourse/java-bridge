package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    private BridgeGame bridgeGame = new BridgeGame(new Bridge());

    @BeforeEach
    void initBridgeGameTest() {
        bridgeGame = new BridgeGame(new Bridge());
    }

    @DisplayName("게임을 재시작 하면서 게임 총 시도 횟수 증가 성공")
    @Test
    void increaseRetryTotalGame() {
        int beforeResult = bridgeGame.getTotalGame();
        bridgeGame.retry();
        int afterResult = bridgeGame.getTotalGame();
        assertThat(beforeResult).isNotEqualTo(afterResult);
    }
}
