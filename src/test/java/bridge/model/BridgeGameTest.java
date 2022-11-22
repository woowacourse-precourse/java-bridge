package bridge.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import bridge.data.Glass;
import bridge.data.Message;
import bridge.data.State;
import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @Test
    void 다리_생성_테스트() {
        List<String> inputBridge = List.of(Glass.UP.MOVE(), Glass.DOWN.MOVE());
        List<Glass> outputBridge = List.of(Glass.UP, Glass.DOWN);
        BridgeGame bridgeGame = new BridgeGame(List.of());

        assertThat(bridgeGame.buildBridge(inputBridge)).isEqualTo(outputBridge);

    }

}