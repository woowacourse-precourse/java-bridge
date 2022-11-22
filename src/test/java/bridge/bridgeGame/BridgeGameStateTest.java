package bridge.bridgeGame;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.bridge.BridgePosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameStateTest {
    final private List<String> finalState = new ArrayList<>(Arrays.asList("U", "D", "U", "D", "D"));
    private BridgeGameState bridgeGameState;
    @BeforeEach
    public void beforeEach() {
        bridgeGameState = new BridgeGameState(finalState);
        bridgeGameState.move(BridgePosition.BRIDGE_UP);
        bridgeGameState.move(BridgePosition.BRIDGE_DOWN);
        bridgeGameState.move(BridgePosition.BRIDGE_DOWN);
    }


    @Test
    public void bridgeSizeTest() throws Exception {
        // given

        // when
        Integer bridgeSize = bridgeGameState.bridgeSize();

        // then
        assertThat(bridgeSize).isEqualTo(5);
    }

    @Test
    public void currentSizeTest() throws Exception {
        // given

        // when
        Integer currentSize = bridgeGameState.currentSize();

        // then
        assertThat(currentSize).isEqualTo(3);
    }

    @Test
    public void moveTest() throws Exception {
        // given
        bridgeGameState.move(BridgePosition.BRIDGE_UP);

        // when
        String currentAt = bridgeGameState.getCurrentAt(0);

        // then
        assertThat(currentAt).isEqualTo("U");
    }

    @Test
    public void clearCurrentTest() throws Exception {
        // given

        // when
        bridgeGameState.clearCurrent();

        // then
        assertThat(bridgeGameState.currentSize()).isEqualTo(0);
    }

    @Test
    public void getCurrentAtTest() throws Exception {
        // given

        // when
        String currentAt0 = bridgeGameState.getCurrentAt(0);
        String currentAt1 = bridgeGameState.getCurrentAt(1);

        // then
        assertThat(currentAt0).isEqualTo("U");
        assertThat(currentAt1).isEqualTo("D");
    }

    @Test
    public void getMatchedTest() throws Exception {
        // given

        // when
        boolean matchedAt0 = bridgeGameState.getMatched(0);
        boolean matchedAt1 = bridgeGameState.getMatched(1);
        boolean matchedAt2 = bridgeGameState.getMatched(2);

        // then
        assertThat(matchedAt0).isEqualTo(true);
        assertThat(matchedAt1).isEqualTo(true);
        assertThat(matchedAt2).isEqualTo(false);
    }
}