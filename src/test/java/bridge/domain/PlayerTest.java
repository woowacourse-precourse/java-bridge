package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
    private final List<String> bridge = List.of("U", "D", "U");
    private final BridgeGameAnswer gameAnswer = new BridgeGameAnswer(bridge);
    private final BridgeGame bridgeGame = new BridgeGame(gameAnswer);

    @Test
    @DisplayName("[정상] 플레이어가 움직이다.")
    void move_SUCCESS() {
        Player player = new Player();
        player.move(bridgeGame, Move.UP);
        assertThatNoException();
    }

    @Test
    @DisplayName("[정상] 플레이어가 움직이다.")
    void move_FAIL() {
        Player player = new Player();
        player.move(bridgeGame, Move.DOWN);
        assertThatNoException();
    }

    @Test
    @DisplayName("[정상] 플레이어 재시도하다.")
    void retry() {
        Player player = new Player();
        player.retry();

        assertThat(player.getGamePlayCount()).isEqualTo(2);
    }
}
