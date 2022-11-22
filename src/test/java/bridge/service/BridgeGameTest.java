package bridge.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

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

    @DisplayName("다리 건너기에 성공했다면 게임 상태에 O와 공백 한 칸을 추가하고 false를 반환한다.")
    @Test
    public void failToCrossTheBridge() {
        assertThat(bridgeGame.move(gameStatus, bridge, "U")).isTrue();
        assertThat(gameStatus.topBridge.get(0)).isEqualTo("O");
        assertThat(gameStatus.bottomBridge.get(0)).isEqualTo(" ");
    }

    @DisplayName("다리 건너기에 실패했다면 게임 상태에 X와 공백 한 칸을 추가하고 false를 반환한다.")
    @Test
    public void SucceedToCrossTheBridge() {
        assertThat(bridgeGame.move(gameStatus, bridge, "D")).isFalse();
        assertThat(gameStatus.topBridge.get(0)).isEqualTo(" ");
        assertThat(gameStatus.bottomBridge.get(0)).isEqualTo("X");
    }

    @DisplayName("재시도 하면 게임 상태는 초기화 되고, tryCount는 1 증가한다.")
    @Test
    public void retryToCrossTheBride() {
        assertThat(gameStatus.getTryCount()).isEqualTo(1);
        gameStatus.resetGameStatus();
        assertThat(gameStatus.getTryCount()).isEqualTo(2);
        assertThat(gameStatus.topBridge.size()).isEqualTo(0);
    }
}