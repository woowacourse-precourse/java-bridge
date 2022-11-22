package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @DisplayName("다리에서 이동하는 칸이 건널 수 있다.")
    @ParameterizedTest
    @CsvSource({"0, U", "1, D", "2, U"})
    void compareSpaceIsTrue(int position, String selectedSpace) {
        List<String> bridgePrototype = List.of("U", "D", "U");
        Bridge bridge = new Bridge(bridgePrototype);

        Movable movable = bridge.compareSpace(position, selectedSpace);

        Assertions.assertThat(movable.isMovable()).isTrue();
    }

    @DisplayName("다리에서 이동하는 칸이 건널 수 없다.")
    @ParameterizedTest
    @CsvSource({"0, D", "1, U", "2, D"})
    void compareSpaceIsFalse(int position, String selectedSpace) {
        List<String> bridgePrototype = List.of("U", "D", "U");
        Bridge bridge = new Bridge(bridgePrototype);

        Movable movable = bridge.compareSpace(position, selectedSpace);

        Assertions.assertThat(movable.isMovable()).isFalse();
    }

    @DisplayName("다리의 끝을 알린다..")
    @ParameterizedTest
    @CsvSource({"4, true", "3, false"})
    void isEndOfBridge(int position, boolean result) {
        List<String> bridgePrototype = List.of("U", "D", "U", "D");
        Bridge bridge = new Bridge(bridgePrototype);

        boolean isEndOfBridge = bridge.isEndOfBridge(position);

        Assertions.assertThat(isEndOfBridge).isEqualTo(result);
    }
}