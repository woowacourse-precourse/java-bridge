package bridge.model.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    @DisplayName("한 칸씩 이동하고 결과가 일치하는지 확인한다.")
    @Test
    void move() {
        assertRandomNumberInRangeTest(() -> {
            BridgeGame bridgeGame = BridgeGame.getInstance();
            bridgeGame.init(3);
            assertThat(bridgeGame.move("U", 0)).isTrue();
            assertThat(bridgeGame.move("U", 1)).isTrue();
            assertThat(bridgeGame.move("U", 2)).isFalse();
        }, 1, 1, 0);
    }

    @DisplayName("게임을 재시도한다.")
    @Test
    void retry() {
        assertRandomNumberInRangeTest(() -> {
            BridgeGame bridgeGame = BridgeGame.getInstance();
            bridgeGame.init(3);
            bridgeGame.move("D", 0);
            bridgeGame.retry("R");
            bridgeGame.move("U", 0);
            bridgeGame.move("D", 1);
            bridgeGame.retry("Q");
            assertThat(bridgeGame.gameResultToString()).isEqualTo("최종 게임 결과\n" +
                    "[ O |   ]\n" +
                    "[   | X ]\n" +
                    "\n" +
                    "게임 성공 여부: 실패\n" +
                    "총 시도한 횟수: 2");
        }, 1, 1, 0);
    }

    @DisplayName("다리 건너기에 성공한다.")
    @Test
    void isSuccess() {
        assertRandomNumberInRangeTest(() -> {
            BridgeGame bridgeGame = BridgeGame.getInstance();
            bridgeGame.init(3);
            bridgeGame.move("D", 0);
            bridgeGame.move("U", 1);
            bridgeGame.move("D", 2);
            assertThat(bridgeGame.isSuccess()).isTrue();
        }, 0, 1, 0);
    }
}