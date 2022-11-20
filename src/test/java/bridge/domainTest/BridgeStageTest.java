package bridge.domainTest;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeStage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeStageTest {
    @Test
    void nextStageTest() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U","D"));



        int stage = bridgeGame.getStage();
        Assertions.assertThat(stage).isEqualTo(1);
    }
}
