package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeGameTest {

    @DisplayName("첫 번째 이동 결과 O , 두 번째 이동 결과 X")
    @Test
    void movingTest1() {
        BridgeGame bridgeGame = new BridgeGame(List.of("D", "D", "U"));

        String fristMovingResult = bridgeGame.move(1, "D");
        String fristResult = "O";

        String secondMovingResult = bridgeGame.move(2, "U");
        String scondResult = "X";

        Assertions.assertThat(fristMovingResult).isEqualTo(fristResult);
        Assertions.assertThat(secondMovingResult).isEqualTo(scondResult);
    }

    @DisplayName("첫 번째 이동 결과 O , 두 번째 이동 결과 O")
    @Test
    void movingTest2() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "U", "U"));

        String fristMovingResult = bridgeGame.move(1, "U");
        String fristResult = "O";

        String secondMovingResult = bridgeGame.move(2, "U");
        String secondResult = "O";

        Assertions.assertThat(fristMovingResult).isEqualTo(fristResult);
        Assertions.assertThat(secondMovingResult).isEqualTo(secondResult);
    }

    @DisplayName("첫 번째 이동 결과 O , 두 번째 이동 결과 O, 새 번째 이동 결과 실패")
    @Test
    void movingTest3() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "U", "U"));

        String fristMovingResult = bridgeGame.move(1, "U");
        String fristResult = "O";

        String secondMovingResult = bridgeGame.move(2, "U");
        String secondResult = "O";

        String ThridMovingResult = bridgeGame.move(3, "D");
        String ThridResult = "X";

        Assertions.assertThat(fristMovingResult).isEqualTo(fristResult);
        Assertions.assertThat(secondMovingResult).isEqualTo(secondResult);
        Assertions.assertThat(ThridMovingResult).isEqualTo(ThridResult);
    }


}