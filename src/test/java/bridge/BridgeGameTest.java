package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class BridgeGameTest {
    @Test
    @DisplayName("총 3칸 건너고 앞에서부터 방향이 완전히 일치한 경우")
    void isCorrectChoice_EqualsFirstThreeSteps_ReturnTrue() {
        BridgeGame bridgeGame = new BridgeGame(Arrays.asList("U", "D", "U", "D", "U", "U"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        assertThat(bridgeGame.isCorrectChoice()).isEqualTo(true);
    }

    @Test
    @DisplayName("총 3칸 건넜지만 앞에서부터 방향이 완전히 일치하지 않는 경우")
    void isCorrectChoice_NotEqualsFirstThreeSteps_ReturnFalse() {
        BridgeGame bridgeGame = new BridgeGame(Arrays.asList("U", "D", "U", "D", "U", "U"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        assertThat(bridgeGame.isCorrectChoice()).isEqualTo(false);
    }

    @Test
    @DisplayName("다리를 처음부터 끝까지 정확히 건넌 경우")
    void isSuccess_EqualsAllSteps_ReturnTrue() {
        BridgeGame bridgeGame = new BridgeGame(Arrays.asList("U", "D", "U", "D", "U", "U"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        bridgeGame.move("U");
        assertThat(bridgeGame.isSuccess()).isEqualTo(true);
    }

    @Test
    @DisplayName("다리를 일부만 건넌 경우")
    void isSuccess_NotEqualsStepCount_ReturnFalse() {
        BridgeGame bridgeGame = new BridgeGame(Arrays.asList("U", "D", "U", "D", "U", "U"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        assertThat(bridgeGame.isSuccess()).isEqualTo(false);
    }

    @Test
    @DisplayName("다리를 처음부터 끝까지 건넜으나 방향이 불일치한게 있는 경우")
    void isSuccess_NotEqualsSteps_ReturnFalse() {
        BridgeGame bridgeGame = new BridgeGame(Arrays.asList("U", "D", "U", "D", "U", "U"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        bridgeGame.move("D");
        assertThat(bridgeGame.isSuccess()).isEqualTo(false);
    }

    @Test
    @DisplayName("게임 다시 시도시 다리가 그대로인지 테스트")
    void retry_PlayerCommandsClear_KeepAnswerBridge() {
        BridgeGame bridgeGame = new BridgeGame(Arrays.asList("U", "D", "D"));
        bridgeGame.move("D");
        bridgeGame.retry();
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        assertThat(bridgeGame.isSuccess()).isEqualTo(true);
    }

    @Test
    @DisplayName("게임 다시 시도시 시도한 횟수가 누적되는지 테스트")
    void retry_PlayerCommandsClear_KeepTryCount() {
        BridgeGame bridgeGame = new BridgeGame(Arrays.asList("U", "D", "D"));
        bridgeGame.move("D");
        bridgeGame.retry();
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        assertThat(bridgeGame.getTryCount()).isEqualTo(2);
    }
}