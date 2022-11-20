package bridge;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeRestartTest {

    @Test
    void restartCheckTestCase() {
        String playerCommand = "R";
        int result = 0;
        BridgeRestart bridgeRestart = new BridgeRestart();
        assertThat(bridgeRestart.bridgeRestartCheck(playerCommand)).isEqualTo(result);
    }

    @Test
    void quitCheckTestCase() {
        String playerCommand = "Q";
        int result = 1;
        BridgeRestart bridgeRestart = new BridgeRestart();
        assertThat(bridgeRestart.bridgeRestartCheck(playerCommand)).isEqualTo(result);
    }

}