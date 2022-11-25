package bridge.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.domain.Bridge;
import bridge.domain.GameStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    Bridge bridge;
    BridgeGame bridgeGame;
    GameStatus gameStatus;

    @BeforeEach
    public void setting() {
        bridge = new Bridge(newArrayList("U", "D", "D"));
        bridgeGame = new BridgeGame();
        gameStatus = new GameStatus();
    }

    @DisplayName("다리 건너기에 성공할 때 테스트")
    @Test
    public void failToCrossTheBridge() {
        assertThat(bridgeGame.move(gameStatus, bridge, "U")).isTrue();
        assertThat(gameStatus.getTopBridge().getDataForOutput(0)).isEqualTo("O");
        assertThat(gameStatus.getBottomBridge().getDataForOutput(0)).isEqualTo(" ");
    }

    @DisplayName("다리 건너기에 실패할 때 테스트")
    @Test
    public void SucceedToCrossTheBridge() {
        assertThat(bridgeGame.move(gameStatus, bridge, "D")).isFalse();
        assertThat(gameStatus.getTopBridge().getDataForOutput(0)).isEqualTo(" ");
        assertThat(gameStatus.getBottomBridge().getDataForOutput(0)).isEqualTo("X");
    }

    @DisplayName("재시도 하면 게임 상태는 초기화 되고, numberOfTry는 1 증가한다.")
    @Test
    public void retryToCrossTheBride() {
        assertThat(gameStatus.getNumberOfTry()).isEqualTo(1);
        gameStatus.resetGameStatus();
        assertThat(gameStatus.getNumberOfTry()).isEqualTo(2);
        assertThat(gameStatus.getTopBridge().getSize()).isEqualTo(0);
    }
}