package bridge.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import static org.assertj.core.api.Assertions.assertThat;



class BridgeGameTest {
    private static final String SELECTION_UP = "U";
    private static final int SELECTION_UP_NUMBER = 1;
    private static final String SELECTION_DOWN = "D";
    private static final int SELECTION_DOWN_NUMBER = 0;
    @DisplayName("잘못된 발판을 밟았을 때 죽는지 확인")
    @Test
    void 잘못_움직여_사망() {
        assertRandomNumberInRangeTest(() -> {
            BridgeGame bridgeGame = new BridgeGame(3);
            bridgeGame.move(SELECTION_DOWN);

            assertThat(bridgeGame.isPlayerDead()).isTrue();
        }, SELECTION_UP_NUMBER, SELECTION_DOWN_NUMBER, SELECTION_DOWN_NUMBER);

    }
}