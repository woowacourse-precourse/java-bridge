package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {
    @Test
    void testBridge() {
        Bridge bridge = new Bridge(List.of("U", "U", "D", "U"));
        assertThat(bridge.toString()).isEqualTo("UUDU");
    }

    @Test
    void addBlock_아래() {
        Bridge bridge = new Bridge(new ArrayList<>(List.of("U", "U", "D", "U")));
        bridge.addBlock("D");
        assertThat(bridge.toString()).isEqualTo("UUDUD");
    }

    @Test
    void addBlock_위() {
        Bridge bridge = new Bridge(new ArrayList<>(List.of("U", "U", "D", "U")));
        bridge.addBlock("U");
        assertThat(bridge.toString()).isEqualTo("UUDUU");
    }

    @Test
    void addBlock_잘못된입력예외처리() {
        Bridge bridge = new Bridge(new ArrayList<>(List.of("U", "U", "D", "U")));
        assertThrows(IllegalArgumentException.class, () -> {
            bridge.addBlock("A");
        });
    }

    @DisplayName("정상 다리 길이 입력")
    @ValueSource(ints = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20})
    @ParameterizedTest
    void goodCommand(int n) {
        Bridge.validateLength(n);
    }

    @DisplayName("비정상 다리 길이 입력")
    @ValueSource(ints = {-1, 0, 1, 2, 21, 22, 210000000})
    @ParameterizedTest
    void badCommand(int n) {
        assertThrows(IllegalArgumentException.class, () -> {
            Bridge.validateLength(n);
        });
    }
}