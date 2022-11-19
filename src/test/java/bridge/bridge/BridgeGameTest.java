package bridge.bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * BridgeGame 클래스에 관련된 테스트 클래스입니다.
 */
class BridgeGameTest {

    /**
     * 정상적으로 다리가 생성되는지에 관련된 테스트입니다.
     */
    @Test
    void makeBridge() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.makeBridge(6);
        assertThat(bridgeGame.getBridge().size()).isEqualTo(6);
    }

    /**
     * 정상적으로 사용자의 움직임이 반영되는지에 관련된 테스트입니다.
     */
    @Test
    void move() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.makeBridge(6);
        bridgeGame.move("U");
        assertThat(bridgeGame.getUserInput().get(0)).isEqualTo("U");
    }

    /**
     * 정상적으로 게임의 초기화가 이루어지는지에 관련된 테스트입니다.
     */
    @Test
    void retry() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.makeBridge(6);
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.retry();
        assertThat(bridgeGame.getUserInput().size()).isEqualTo(0);
    }

}