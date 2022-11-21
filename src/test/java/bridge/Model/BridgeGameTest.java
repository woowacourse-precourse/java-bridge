package bridge.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    @DisplayName("잘못된 발판을 밟았을 때 죽는지 확인")
    @Test
    void 잘못_움직여_사망() {
        assertRandomNumberInRangeTest(() -> {
            BridgeGame bridgeGame = new BridgeGame(3);
            bridgeGame.move("D");

            assertThat(bridgeGame.isPlayerDead()).isTrue();
        }, 1, 0, 0);

    }
}