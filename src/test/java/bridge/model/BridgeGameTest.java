package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameTest {
    BridgeGame bridgeGame = new BridgeGame();


    @DisplayName("다리가 위 칸일 때, 사용자가 U과 D을 입력한 경우 테스트")
    @Test
    void saveStageWhenBridgeStageIsUp() {
        List<List<String>> currentMap = new ArrayList<>();
        bridgeGame.move("U", "U");
        currentMap.addAll(bridgeGame.move("U", "D"));

        Assertions.assertThat(currentMap).isEqualTo(List.of(List.of(" ", "O"), List.of(" ", "X")));
    }

    @DisplayName("다리가 아래 칸일 때, 사용자가 U과 D을 입력한 경우 테스트")
    @Test
    void saveStageWhenBridgeStageIsDown() {
        List<List<String>> currentMap = new ArrayList<>();
        bridgeGame.move("D", "U");
        currentMap.addAll(bridgeGame.move("D", "D"));

        Assertions.assertThat(currentMap).isEqualTo(List.of(List.of("X", " "), List.of("O", " ")));
    }


    @DisplayName("재시작 여부로 R을 입력하는 경우 테스트")
    @Test
    void retryThenCurrentMapClear() {
        List<List<String>> currentMap = new ArrayList<>();
        bridgeGame.move("D", "U");
        bridgeGame.move("D", "D");
        bridgeGame.retry("R");
        currentMap.addAll(bridgeGame.move("D", "U"));

        Assertions.assertThat(currentMap).isEqualTo(List.of(List.of("X", " ")));
    }
}
