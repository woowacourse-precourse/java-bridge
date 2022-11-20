package bridge.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {
    @Test
    void testBridge() {
        List<String> list = new ArrayList<String>();
        list.add("U");
        list.add("U");
        list.add("D");
        list.add("U");
        Bridge bridge = new Bridge(list);
        assertThat(bridge.toString()).isEqualTo("UUDU");
    }

    @Test
    void addBlock() {
        List<String> list = new ArrayList<String>();
        list.add("U");
        list.add("U");
        list.add("D");
        list.add("U");
        Bridge bridge = new Bridge(list);
        bridge.addBlock("D");
        assertThat(bridge.toString()).isEqualTo("UUDUD");
    }

    @Test
    void addBlock2() {
        List<String> list = new ArrayList<String>();
        list.add("U");
        list.add("U");
        list.add("D");
        list.add("U");
        Bridge bridge = new Bridge(list);
        assertThrows(IllegalArgumentException.class, () -> {
            bridge.addBlock("A");
        });
    }
}