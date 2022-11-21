package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeGameTest {

    private BridgeGame bridgeGame;


    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame();
        bridgeGame.createBridge(List.of("U", "D", "U"));
    }

    @AfterEach
    void afterEach() {
        bridgeGame = null;
    }

    @DisplayName("이동 결과 기록을 반환한다.")
    @Test
    void getRecordByMoveTest() {
        List<List<String>> bridgeRecord = bridgeGame.getRecordByMove("U");
        List<String> upBridge = bridgeRecord.get(0);
        List<String> downBridge = bridgeRecord.get(1);

        Assertions.assertThat(upBridge).isEqualTo(List.of("O"));
        Assertions.assertThat(downBridge).isEqualTo(List.of(" "));
    }
}