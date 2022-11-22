package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {


    @DisplayName("다리를 이동할 할 때마다의 결과 테스트")
    @Test
    void moveTest() {
        BridgeGame bridgeGame = new BridgeGame();
        String moving = "D";
        List<String> correctBridge = List.of("U", "D", "U");
        int currentIndex = 1;
        String result = bridgeGame.move(moving, correctBridge, currentIndex);
        assertThat(result).isEqualTo("O");
    }

    @DisplayName("게임 재시도시 이동한 부분 초기화 테스트")
    @Test
    void retryTest() {
        BridgeGame bridgeGame = new BridgeGame();
        List<String> upBridge = List.of("O", " ", "X");
        List<String> downBridge = List.of(" ", "O", " ");
        bridgeGame.getUpBridge().addAll(upBridge);
        bridgeGame.getDownBridge().addAll(downBridge);
        bridgeGame.retry();
        assertThat(bridgeGame.getUpBridge().size()).isEqualTo(0);
        assertThat(bridgeGame.getDownBridge().size()).isEqualTo(0);
    }
}