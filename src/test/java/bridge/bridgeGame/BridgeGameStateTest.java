package bridge.bridgeGame;

import static org.assertj.core.api.Assertions.assertThat;

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
}