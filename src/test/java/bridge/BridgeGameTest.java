package bridge;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    private final BridgeGame bridgeGame = new BridgeGame();
    private final List<String> rightBridgeWay = Arrays.asList("D", "D", "U");

    @Test
    void 위쪽다리_출력_테스트() {
        String answer = rightBridgeWay.get(0);
        String movingValue = "D";

        List<String> upperBridgeTest = bridgeGame.makeUpperBridge(answer, movingValue);
        assertEquals(upperBridgeTest.size(),1);
    }

    @Test
    void 아래쪽다리_출력_테스트() {
        String answer = rightBridgeWay.get(0);
        String movingValue = "D";

        List<String> lowerBridgeTest = bridgeGame.makeLowerBridge(answer, movingValue);
        assertEquals(lowerBridgeTest.size(),1);
    }

    @Test
    void 입력값에_따른_오엑스_테스트() {
        String answer = bridgeGame.compareValue("D","D");
        assertThat(answer).contains("O");
    }

    @Test
    void retry() {

        bridgeGame.retry();
    }
}