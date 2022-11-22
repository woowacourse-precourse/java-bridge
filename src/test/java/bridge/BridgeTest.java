package bridge;

import model.Bridge;
import model.Moving;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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
