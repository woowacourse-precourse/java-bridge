package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static final int BRIDGE_SIZE = 10;
    private final Bridge bridge = new Bridge(bridgeMaker.makeBridge(BRIDGE_SIZE), new Player());
    private final BridgeGame bridgeGame = new BridgeGame(bridge);

    @DisplayName("정답을 입력했을경우 bridge의 location이 정상적으로 증가하는지 테스트")
    @Test
    void bridgeGameMoveTest() {
        String up = "U";
        String down = "D";
        bridgeGame.move(up);
        bridgeGame.move(down);
        assertThat(bridge.getPlayer().getLocation()).isGreaterThan(0);
    }

    @DisplayName("재시도 물어볼때 R 입력 시 tryCount가 정상적으로 증가하는지 테스트")
    @Test
    void bridgeGameRetryTest() {
        String input = "R";
        bridgeGame.retry(input);
        assertThat(bridgeGame.getTryCount()).isGreaterThan(1);
    }
}
