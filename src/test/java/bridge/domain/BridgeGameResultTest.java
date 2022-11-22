package bridge.domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameResultTest {

    private Bridge bridge;
    private List<String> directions;
    private BridgeGameResult bridgeGameResult;

    @BeforeEach
    void init() {
        bridge = new Bridge(List.of("U", "U", "U"));
        directions = new ArrayList<>(List.of("U", "U", "D"));
        bridgeGameResult = new BridgeGameResult();
    }

    @DisplayName("이동 가능 여부에 따라 형식에 맞는 결과를 가진다.")
    @Test
    void compareBridgeGameResult() {
        for (int index = 0; index < bridge.getSize(); index++) {
            bridgeGameResult.makeMoveResult(bridge, index, directions.get(index));
        }
        assertThat(bridgeGameResult.getUpperBridge()).isEqualTo("[ O | O |   ]");
        assertThat(bridgeGameResult.getLowerBridge()).isEqualTo("[   |   | X ]");
    }
}