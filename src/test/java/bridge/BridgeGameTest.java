package bridge;

import bridge.Model.Bridge;
import bridge.Model.BridgeGame;
import bridge.Model.BridgeMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();

    @DisplayName("입력에 대해 move가 정상적으로 작동하는지 확인")
    @Test
    void 정답과_오답을_입력하고_이동(){
        List<String> bridgeAnswer = List.of("U", "D");
        Bridge bridge = new Bridge(bridgeAnswer);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        BridgeMap bridgeMap = new BridgeMap();
        bridgeMap.updateMap(1, true);
        bridgeMap.updateMap(1, false);
        List<String> movements = List.of("U", "U");
        for(String s: movements)
            bridgeGame.move(s);
        assertThat(bridgeGame.getBridgeMap().getMap()).isEqualTo(bridgeMap.getMap());
    }

    @DisplayName("retry 후 round 수 확인")
    @Test
    void retry_4번_시도(){
        List<String> bridgeAnswer = List.of("U");
        Bridge bridge = new Bridge(bridgeAnswer);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        for(int i = 0; i<4; i++)
            bridgeGame.isExit("R");
        assertThat(bridgeGame.getRound()).isEqualTo(5);
    }
}
