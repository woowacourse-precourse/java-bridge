package bridge.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeTest {
    @Test
    public void bridgeTest() {
        Bridge bridge = Bridge.of(List.of("U","U","U","D"));
        assertThat(bridge.play(Bridge.of("U"))).isEqualTo(Result.KEEP);
    }
}
