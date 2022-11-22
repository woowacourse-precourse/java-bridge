package bridge;

import bridge.domain.BridgeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.Controller.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    @DisplayName("칸 이동 테스트")
    @Test
    void move() {
        assertRandomNumberInRangeTest(() -> {
            BridgeGame bridgeGame = new BridgeGame(3);
            assertThat(bridgeGame.move("U", 0)).isEqualTo(GAME_SUCCESS);
            assertThat(bridgeGame.move("D", 0)).isEqualTo(GAME_FAIL);
            assertThat(bridgeGame.move("U", 2)).isEqualTo(GAME_FINISH);

        }, 1, 0, 1);
    }

    @DisplayName("다시 시도 테스트")
    @Test
    void retry() {
        BridgeGame bridgeGame = new BridgeGame(3);
        assertThat(bridgeGame.retry("R")).isEqualTo(true);
        assertThat(bridgeGame.getTryCount()).isEqualTo(2);
    }
}
