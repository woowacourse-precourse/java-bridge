package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMapMakerTest {
    private static final List<String> bridge = List.of("U", "D", "D");
    private static final BridgeMapMaker bridgeMapMaker = new BridgeMapMaker(bridge);

    @DisplayName("건널 수 있는 부분을 나타낸 다리 지도를 반환한다")
    @Test
    void successBridgeMapTest() {
        PlayerMap expected = new PlayerMap(
                List.of("O", " ", " "),
                List.of(" ", "O", "O")
        );
        assertThat(bridgeMapMaker.makeSuccessBridgeMap())
                .isEqualTo(expected);
    }

    @DisplayName("건널 수 없는 부분을 나타낸 다리 지도를 반환한다")
    @Test
    void failureBridgeMapTest() {
        PlayerMap expected = new PlayerMap(
                List.of(" ", "X", "X"),
                List.of("X", " ", " ")
        );
        assertThat(bridgeMapMaker.makeFailureBridgeMap())
                .isEqualTo(expected);
    }
}
