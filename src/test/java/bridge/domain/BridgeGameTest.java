package bridge.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    private int bridgeSize = 5;
    List<String> sampleBridge = List.of("U", "D", "U", "D", "U");
    BridgeGame bridgeGame = new BridgeGame(sampleBridge, new MoveLog(sampleBridge.size()));

    @DisplayName("입력한 길이의 다리를 생성하는지 확인")
    @Test
    void checkBridgeSize() {
        Assertions.assertThat(bridgeGame.getBridgeSize()).isEqualTo(bridgeSize);
    }

}