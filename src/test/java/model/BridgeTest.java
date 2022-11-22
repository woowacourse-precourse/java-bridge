package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BridgeTest {
    @Test
    void 다리_추가() {
        List<String> status = new ArrayList<>();
        status.add("O");
        Bridge bridge = new Bridge(status);
        bridge.addBridge("X");
        assertEquals(2, bridge.getSize());
    }
}
