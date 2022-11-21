package bridge;

import bridge.domain.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    private BridgeGame bridgeGame;
    private List<String> rightBridgeWay;

    @BeforeEach
    public void setup() {
        bridgeGame = new BridgeGame();
        rightBridgeWay = Arrays.asList("D", "D", "U");
    }

    @Test
    void 위쪽다리_출력_테스트() {
        String answer = rightBridgeWay.get(0);
        String movingValue = "D";

        List<String> upperBridgeTest = bridgeGame.makeUpperBridge(answer, movingValue);
        assertEquals(1, upperBridgeTest.size());
    }

    @Test
    void 아래쪽다리_출력_테스트() {
        String answer = rightBridgeWay.get(0);
        String movingValue = "D";

        List<String> lowerBridgeTest = bridgeGame.makeLowerBridge(answer, movingValue);
        assertEquals(1, lowerBridgeTest.size());
    }

    @Test
    void 입력값에_따른_오엑스_테스트() {
        String answer = bridgeGame.compareValue("D", "D");
        assertThat(answer).contains("O");
    }

    @Test
    void 재시도_테스트() {
        assertThat(bridgeGame.retry("R")).isTrue();
        assertThat(bridgeGame.retry("Q")).isFalse();
    }
}