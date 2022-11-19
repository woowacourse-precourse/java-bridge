package bridge;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @Test
    void 위쪽다리_출력_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        List<String> rightBridgeWay = Arrays.asList("D,D,U");
        String movingValue = "D";  // 미완성
    }

    @Test
    void 입력값에_따른_오엑스_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
//        String answer = bridgeGame.compareValue("D","D");
//        assertThat(answer).contains("X"); //일단 보류
    }
}