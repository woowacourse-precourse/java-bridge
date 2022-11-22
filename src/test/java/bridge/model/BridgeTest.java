package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {
    public InputStream getPlayerInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @ParameterizedTest
    @DisplayName("다리 생성")
    @ValueSource(strings = {"3", "6"})
    void checkSetBridge(String input) {

        InputStream in = getPlayerInput(input);
        System.setIn(in);


    }

    @Test
    @DisplayName("다리 생성")
    void generateBridge() {
        Bridge bridge;
        bridge = new Bridge(new ArrayList<>(List.of("U", "D", "D")));

        Assertions.assertThat(bridge.getBridge().size()).isEqualTo(3);
    }
}
