package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    @DisplayName("다리 건너기를 실패하면 게임을 종료한다.")
    @Test
    void isGameEndTest_1() {
        assertRandomNumberInRangeTest(() -> {
            BridgeGame bridgeGame = new BridgeGame(4);
            bridgeGame.move("D");
            assertThat(bridgeGame.isGameFailed()).isEqualTo(true);
            assertThat(bridgeGame.isGameEnd()).isEqualTo(true);
        }, 1, 0, 0, 1);
    }

    @DisplayName("다리를 끝까지 건넜다면 게임을 종료한다.")
    @Test
    void isGameEndTest_2() {
        assertRandomNumberInRangeTest(() -> {
            BridgeGame bridgeGame = new BridgeGame(4);
            bridgeGame.move("U");
            bridgeGame.move("D");
            bridgeGame.move("D");
            bridgeGame.move("U");
            assertThat(bridgeGame.isGameFailed()).isEqualTo(false);
            assertThat(bridgeGame.isGameEnd()).isEqualTo(true);
        }, 1, 0, 0, 1);
    }
}
