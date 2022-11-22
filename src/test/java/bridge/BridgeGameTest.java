package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    @DisplayName("사용자의 입력에 따른 다리가 잘 생성되었는지")
    @Test
    void addPlayerBridge_correct() {
        BridgeGame bridgeGame = new BridgeGame(3);
        bridgeGame.addPlayerBridge("U");
        assertThat(bridgeGame.getPlayerBridge().get(0).get(1)).isEqualTo(bridgeGame.getCurrentIsCorrect());
    }

}