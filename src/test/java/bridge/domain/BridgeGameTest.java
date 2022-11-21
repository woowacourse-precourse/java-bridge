package bridge.domain;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    BridgeGame bridgeGame = new BridgeGame(Arrays.asList("U"));

    @DisplayName("UP 방향으로 이동 테스트")
    @Test
    void moveUpTest() {
        bridgeGame = new BridgeGame(Arrays.asList("U"));
        Assertions.assertThat(bridgeGame.move(Direction.UP)).isTrue();
    }

    @DisplayName("DOWN 방향으로 이동 테스트")
    @Test
    void moveDownTest() {
        bridgeGame = new BridgeGame(Arrays.asList("D"));
        Assertions.assertThat(bridgeGame.move(Direction.DOWN)).isTrue();
    }

    @DisplayName("retry 테스트")
    @Test
    void retryTest() {
        Assertions.assertThat(bridgeGame.retry(GameCommand.RETRY)).isTrue();
    }

    @DisplayName("quit 테스트")
    @Test
    void quitTest() {
        Assertions.assertThat(bridgeGame.retry(GameCommand.QUIT)).isFalse();
    }

}