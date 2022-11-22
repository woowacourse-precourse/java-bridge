package bridge;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class BridgeGameTest {
    List<String> bridge;
    BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = bridgeMaker.makeBridge(5);
        bridgeGame = new BridgeGame();
    }

    @Test
    void 이동_확인(){
        for(int i = 0 ; i < bridge.size() ; i++){
            assertThat(Objects.equals(bridge.get(i), "U")).isEqualTo(bridgeGame.move(bridge, i, "U"));
        }
    }
}