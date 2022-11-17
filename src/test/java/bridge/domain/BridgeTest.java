package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeTest {
    private Bridge bridge;
    private ExpectedBridge expectedBridge;
    @BeforeEach
    public void setUp() {
        bridge = Bridge.of(List.of("U","D"));
        expectedBridge = ExpectedBridge.newInstance();
    }
    @Test
    public void bridgeKeepTest() {
        expectedBridge.expect("U");
        assertThat(bridge.play(expectedBridge)).isEqualTo(Result.KEEP);
    }
    @Test
    public void bridgeLoseTest() {
        expectedBridge.expect("D");
        assertThat(bridge.play(expectedBridge)).isEqualTo(Result.LOSE);
    }
    @Test
    public void bridgeWinTest() {
        expectedBridge.expect("U");
        expectedBridge.expect("D");
        assertThat(bridge.play(expectedBridge)).isEqualTo(Result.WIN);
    }
}
