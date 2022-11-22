package bridge.model.domain;


import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BridgesTest {

    @Test
    void findBridgeByPosition() {
        Bridges bridges = new Bridges(List.of("U", "U", "D"));

        String bridge = bridges.findBridgeByPosition(1);

        Assertions.assertThat(bridge)
                .isEqualTo("U");
    }

    @Test
    void findBridgeMapByPosition() {
        Bridges bridges = new Bridges(List.of("U", "U", "D"));

        List<String> bridgeMap = bridges.findBridgeMapByPosition(1);

        Assertions.assertThat(bridgeMap)
                .containsExactly("U", "U");
    }

    @Test
    void size() {
        Bridges bridges = new Bridges(List.of("U", "U", "D"));

        int size = bridges.size();

        Assertions.assertThat(size)
                .isEqualTo(3);
    }
}