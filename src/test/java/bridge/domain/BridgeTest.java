package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {
    Bridge bridge;

    @BeforeEach
    void beforeEach() {
        bridge = Bridge.getInstance();
    }


    @Test
    void getBridgeInstanceTest() {
        assertThat(bridge).isInstanceOf(Bridge.class);
    }

    @Test
    void getBridgeInfoTest() {
        List<String> expect = List.of("U", "D", "U");

        bridge.init(List.of("U", "D", "U"));
        assertThat(bridge.getBridgeInfo()).isEqualTo(expect);

    }
}
