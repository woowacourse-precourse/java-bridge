package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BridgeTest {

    @DisplayName("다리의 길이가 3보다 작을 시 예외가 발생한다.")
    @Test
    void createBridgeByUnderSize() {
        Assertions.assertThatThrownBy(() -> new Bridge(List.of("U", "D")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이가 20보다 클 때 예외가 발생한다.")
    @Test
    void createBridgeByOverSize() {
        List<String> bridge = new ArrayList<>();
        int size = 21;

        for (int spaceIndex = 0; spaceIndex < size; spaceIndex++) {
            bridge.add("U");
        }
        Assertions.assertThatThrownBy(() -> new Bridge(bridge))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void compareSpace() {
    }

    @Test
    void size() {
    }
}