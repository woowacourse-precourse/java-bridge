package bridge.service;

import bridge.GameStatus;
import bridge.TestBridgeNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame();
        bridgeGame.createBridge(6, new TestBridgeNumberGenerator(newArrayList(1, 1, 0, 1, 0, 1)));
    }

    @DisplayName("플레이어가 한 라운드 플레이하면 게임 계속 가능 결과 반환")
    @Test
    void moveResultContinue() {
        GameStatus gameStatus = bridgeGame.move(1, "U");
        assertThat(gameStatus.isContinue()).isTrue();
    }

    @DisplayName("플레이어가 한 라운드 플레이하면 게임 실패 결과 반환")
    @Test
    void moveResultFail() {
        GameStatus gameStatus = bridgeGame.move(3, "U");
        assertThat(gameStatus.isFail()).isTrue();
    }
}
