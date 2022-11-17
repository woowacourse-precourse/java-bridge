package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeGameTest {
    BridgeGame bridgeGame = new BridgeGame();


    @DisplayName("다리가 위 칸일 때, 사용자가 U과 D을 입력한 경우 테스트")
    @Test
    void saveStageWhenBridgeStageIsUp() {
        bridgeGame.move("U", "U");
        bridgeGame.move("D", "U");

        Assertions.assertThat(userStages.getPositions()).isEqualTo(List.of(List.of(" ", "O"), List.of("X", " ")));
    }

    @DisplayName("다리가 아래 칸일 때, 사용자가 U과 D을 입력한 경우 테스트")
    @Test
    void saveStageWhenBridgeStageIsDown() {
        bridgeGame.move("U", "D");
        bridgeGame.move("D", "D");

        Assertions.assertThat(userStages.getPositions()).isEqualTo(List.of(List.of(" ", "X"), List.of("O", " ")));
    }


    @DisplayName("재시작하는 경우 초기화 확인 테스트")
    @Test
    void retryThenCurrentMapClear() {
        bridgeGame.move("D", "U");
        bridgeGame.move("D", "D");
        bridgeGame.retry();

        Assertions.assertThat(userStages.getPositions()).isEmpty();
    }
}
