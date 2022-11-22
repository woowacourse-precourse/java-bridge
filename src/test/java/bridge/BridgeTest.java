package bridge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeTest {

    private final Bridge bridge = new Bridge(List.of("U", "D", "U"));
    private final BridgeGame bridgeGame = new BridgeGame();

    @CsvSource({"'U', true", "'D', false"})
    @ParameterizedTest(name = "이동 성공 여부 테스트{index}")
    void checkMoveTest(String userSelect, boolean result) {
        bridgeGame.move(userSelect);
        assertThat(bridge.moveCheck(userSelect, bridgeGame)).isEqualTo(result);
    }
}