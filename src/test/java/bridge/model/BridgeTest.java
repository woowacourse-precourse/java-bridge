package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {

    @Test
    @DisplayName("다리 저장")
    void checkSetBridge() {
        Bridge bridge = new Bridge();
        bridge.setBridge(new ArrayList<>(List.of("U","D","D")));
        Assertions.assertThat(bridge.getBridge()).isEqualTo(new ArrayList<>(List.of("U", "D", "D")));
    }
}