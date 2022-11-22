package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {
    private static BridgeMaker bridgeMaker;
    private static GameHelper gameHelper;

    @BeforeEach
    void set() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(5));
        gameHelper = new GameHelper(bridgeGame);
    }

    @DisplayName("입력값과 생성된 다리길이 비교 테스트")
    @Test
    void bridgeSizeTest() {
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(5));
        assertThat(bridgeGame.getBridgeSize()).isEqualTo(5);
    }

    @DisplayName("재시작 시 처음 다리와 동일한지 확인 테스트")
    @Test
    void sameBridgeTest() {
        List<String> bridge = gameHelper.getBridge();
        gameHelper.restart();
        assertThat(gameHelper.getBridge()).isEqualTo(bridge);
    }

    @DisplayName("재시작 시 게임 시도 횟수 증가 확인 테스트")
    @Test
    void trialCountTest() {
        new BridgeGame(bridgeMaker.makeBridge(3));
        gameHelper.restart();
        gameHelper.restart();
        assertThat(gameHelper.getTrialCount()).isEqualTo(3);
    }

    @DisplayName("끝에 도달하면 게임이 종료하는지 확인 테스트")
    @Test
    void reachEndTest() {
        List<String> bridge = gameHelper.getBridge();
        for (String moving : bridge) {
            gameHelper.initGame(moving);
        }
        assertThat(gameHelper.reachEnd()).isTrue();
    }
}