package bridge.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void setup() {
        bridgeGame = new BridgeGame(List.of("U", "D", "D"));
    }

    @DisplayName("다리를 건너는 경우 테스트")
    @Test
    void moveSuccessTest() {
        assertThat(bridgeGame.move("U")).isTrue();
        assertThat(bridgeGame.move("D")).isTrue();
        assertThat(bridgeGame.move("D")).isTrue();
    }

    @DisplayName("다리를 건너지 못하는 경우 테스트")
    @Test
    void moveFailTest() {
        assertThat(bridgeGame.move("D")).isFalse();
        assertThat(bridgeGame.move("U")).isFalse();
        assertThat(bridgeGame.move("U")).isFalse();
    }

    @DisplayName("다리 길이를 넘어서 움직여 다리를 건너지 못하는 경우 테스트")
    @Test
    void overMoveTest() {
        assertThat(bridgeGame.move("U")).isTrue();
        assertThat(bridgeGame.move("D")).isTrue();
        assertThat(bridgeGame.move("D")).isTrue();
        assertThat(bridgeGame.move("U")).isFalse();
        assertThat(bridgeGame.move("D")).isFalse();
    }

    @DisplayName("게임 재시작 테스트")
    @Test
    void retryTest() {
        bridgeGame.retry();

        assertThat(bridgeGame.getCurrentGameStages()).isEmpty();
        assertThat(bridgeGame.getNumberOfMoving()).isEqualTo(0);
    }

    @DisplayName("다리를 끝까지 건넌 경우 테스트")
    @Test
    void crossBridgeTest() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");

        assertThat(bridgeGame.isAllCrossed()).isTrue();
    }

    @DisplayName("다리를 끝까지 건너지 못한 경우 테스트")
    @Test
    void notCrossBridgeTest() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");

        assertThat(bridgeGame.isAllCrossed()).isFalse();
    }

    @DisplayName("현재까지의 게임 stage 확인하는 테스트")
    @Test
    void getCurrentGameStagesTest() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        List<BridgeGameStage> currentGameStages = bridgeGame.getCurrentGameStages();

        assertThat(currentGameStages.size()).isEqualTo(3);
        assertThat(currentGameStages.get(0)).extracting("bridgeBlock").isEqualTo("U");
        assertThat(currentGameStages.get(0)).extracting("status").isEqualTo(Status.CROSSED);
        assertThat(currentGameStages.get(1)).extracting("bridgeBlock").isEqualTo("D");
        assertThat(currentGameStages.get(1)).extracting("status").isEqualTo(Status.CROSSED);
        assertThat(currentGameStages.get(2)).extracting("bridgeBlock").isEqualTo("D");
        assertThat(currentGameStages.get(2)).extracting("status").isEqualTo(Status.NOT_CROSSED);
    }
}
