package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    @Test
    @DisplayName("총 3칸 건넌 경우")
    void move_MoveThreeSteps_TryCount3() {
        BridgeGame bridgeGame = new BridgeGame(Arrays.asList("U", "D", "U", "D", "U", "U"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        assertThat(bridgeGame.getTryCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("총 5칸 건넌 경우")
    void move_MoveFiveSteps_TryCount5() {
        BridgeGame bridgeGame = new BridgeGame(Arrays.asList("U", "D", "U", "D", "D", "U", "D"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        assertThat(bridgeGame.getTryCount()).isEqualTo(5);
    }

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
}