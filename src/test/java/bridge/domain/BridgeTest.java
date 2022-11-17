package bridge.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeTest {
    @Test
    public void bridgeKeepTest() {
        Bridge bridge = Bridge.of(List.of("U","U","U","D"));
        assertThat(bridge.play(Bridge.of(List.of("U")))).isEqualTo(Result.KEEP);
    }
    @Test
    public void bridgeLoseTest() {
        Bridge bridge = Bridge.of(List.of("U","U","U","D"));
        assertThat(bridge.play(Bridge.of(List.of("U","D")))).isEqualTo(Result.LOSE);
    }
    @Test
    public void bridgeWinTest() {
        Bridge bridge = Bridge.of(List.of("U","U","U","D"));
        assertThat(bridge.play(Bridge.of(List.of("U","U","U","D")))).isEqualTo(Result.WIN);
    }
}
