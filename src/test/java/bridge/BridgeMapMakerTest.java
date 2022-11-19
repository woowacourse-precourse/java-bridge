package bridge;

import bridge.domain.BridgeMapMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMapMakerTest {
    @Test
    @DisplayName("다리 구성 테스트(건널 수 있는 경우)")
    void validateCanCrossBridge() {
        final BridgeMapMaker bridgeMapMaker = new BridgeMapMaker();
        final List<String> movingStatus = List.of("D", "U", "D");
        final String side = "D";
        final String bridgeMap = bridgeMapMaker
                .makeBridgeMap(movingStatus, side)
                .toString();
        assertThat(bridgeMap).isEqualTo("[ O |   | O ]");
    }

    @Test
    @DisplayName("다리 구성 테스트(건널 수 없는 경우)")
    void validateCannotCrossBridge() {
        final BridgeMapMaker bridgeMapMaker = new BridgeMapMaker();
        final List<String> movingStatus = List.of("U", "D", "-D");
        final String movingKey = "D";
        final String bridgeMap = bridgeMapMaker
                .makeBridgeMap(movingStatus, movingKey)
                .toString();
        assertThat(bridgeMap).isEqualTo("[   | O | X ]");
    }
}
