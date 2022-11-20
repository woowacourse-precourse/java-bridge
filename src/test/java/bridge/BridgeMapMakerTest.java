package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMapMakerTest {
    BridgeMapMaker bridgeMapMaker = new BridgeMapMaker(List.of("U", "D", "D"));

    @DisplayName("건널 수 있는 부분을 나타낸 다리 지도를 반환한다")
    @Test
    void successBridgeMapTest() {
        BridgeMap expected = new BridgeMap(
                List.of("O", " ", " "),
                List.of(" ", "O", "O")
        );
        assertThat(bridgeMapMaker.getSuccessBridgeMap())
                .isEqualTo(expected);
    }

    @DisplayName("건널 수 없는 부분을 나타낸 다리 지도를 반환한다")
    @Test
    void failureBridgeMapTest() {
        BridgeMap expected = new BridgeMap(
                List.of(" ", "X", "X"),
                List.of("X", " ", " ")
        );
        assertThat(bridgeMapMaker.getFailureBridgeMap())
                .isEqualTo(expected);
    }
}
