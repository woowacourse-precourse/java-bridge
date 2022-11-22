package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.model.BridgeGame;
import bridge.model.Player;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    List<String> bridge;
    BridgeGame bridgeGame;
    Player player;

    @BeforeEach
    void setup() {
        bridge = List.of("U", "D", "U");
        bridgeGame = new BridgeGame(bridge);
        player = new Player();
    }

    @DisplayName("올바른 경로로 이동한 경우")
    @Test
    void moveSuccess() {
        bridge.forEach(dir -> {
            // when
            player.chooseDir(dir);

            //then
            assertThat(bridgeGame.move(player)).isEqualTo(false);
        });
    }

    @DisplayName("게임 다시 시작을 선택한 경우 시도횟수를 증가시키고 true를 반환")
    @Test
    void retrySuccess() {
        // given
        String retry = "R";
        int times = 2;

        // when
        boolean result = bridgeGame.retry(retry);

        // then
        assertThat(result).isEqualTo(true);
        assertThat(bridgeGame.getTimes()).isEqualTo(times);
    }

    @DisplayName("게임이 아직 남았으면 true를 반환")
    @Test
    void isGameLeft() {
        // then
        assertThat(bridgeGame.isGameLeft(player)).isEqualTo(true);
    }
}
