package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    private BridgeGame bridgeGame;
    private BridgeMap bridgeMap;
    private Bridge bridge;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame();
        bridgeMap = new BridgeMap();
        bridge = new Bridge();

        bridge.registerBridge(List.of("U", "D", "U", "U"));
    }




}
