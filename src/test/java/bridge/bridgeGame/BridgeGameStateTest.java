package bridge.bridgeGame;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.bridge.BridgePosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeGameStateTest {
    @Test
    public void bridgeSizeTest() throws Exception {
        // given
        List<String> finalState = new ArrayList<>(Arrays.asList("U", "D", "U", "D", "D"));
        BridgeGameState bridgeGameState = new BridgeGameState(finalState);

        // when
        Integer bridgeSize = bridgeGameState.bridgeSize();

        // then
        assertThat(bridgeSize).isEqualTo(5);
    }

    @Test
    public void currentSizeTest() throws Exception {
        // given
        List<String> finalState = new ArrayList<>(Arrays.asList("U", "D", "U", "D", "D"));
        BridgeGameState bridgeGameState = new BridgeGameState(finalState);
        bridgeGameState.move(BridgePosition.BRIDGE_UP);
        bridgeGameState.move(BridgePosition.BRIDGE_DOWN);
        bridgeGameState.move(BridgePosition.BRIDGE_DOWN);

        // when
        Integer currentSize = bridgeGameState.currentSize();

        // then
        assertThat(currentSize).isEqualTo(3);
    }
}