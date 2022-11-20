package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class BridgeGameResultTest {

    @Test
    void addResult() {
        BridgeGameResult bridgeGameResult = new BridgeGameResult();
        bridgeGameResult.addResult("U", "O");
        bridgeGameResult.addResult("D", "O");
        bridgeGameResult.addResult("D", "X");

        assertThat(bridgeGameResult.getUpBridge()).isEqualTo(Arrays.asList("O", " ", " "));
        assertThat(bridgeGameResult.getDownBridge()).isEqualTo(Arrays.asList(" ", "O", "X"));
    }
}