package bridge.engine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    public void before() {
        bridgeGame = new BridgeGame();
    }

    @DisplayName("게임을 시작하면 다리가 생성되어야 한다.")
    @Test
    public void startBridgeGame() {
        int BRIDGE_SIZE = 5;

        bridgeGame.start(BRIDGE_SIZE);
        assertThat(bridgeGame.getBridge().size()).isEqualTo(BRIDGE_SIZE);
    }

    @DisplayName("게임을 시작하면 BridgeGame 상태는 Move 상태가 되야하고 moveCount가 증가해야한다.")
    @Test
    public void move() {
        int BRIDGE_SIZE = 5;

        bridgeGame.start(BRIDGE_SIZE);
        boolean isSuccess = bridgeGame.move("U");

        assertThat(bridgeGame.getMoveCount()).isEqualTo(1);
    }

    @DisplayName("retry 상태에서 Q를 입력하면 false를 반환한다.")
    @Test
    public void endGame() {
        bridgeGame.start(5);
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.setState(bridgeGame.getRetryState());

        boolean isRetry = bridgeGame.retry("Q");
        assertThat(isRetry).isEqualTo(false);
    }

    @DisplayName("게임을 retry하면 유저 기록이 초기화된다.")
    @Test
    public void retryGame() {
        bridgeGame.start(5);
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.setState(bridgeGame.getRetryState());

        boolean isRetry = bridgeGame.retry("R");
        assertThat(isRetry).isEqualTo(true);
        assertThat(bridgeGame.getUserDirection().size()).isEqualTo(0);
        assertThat(bridgeGame.getMoveCount()).isEqualTo(0);
    }
}