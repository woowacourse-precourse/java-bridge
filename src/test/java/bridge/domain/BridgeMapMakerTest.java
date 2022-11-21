package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMapMakerTest {
    private final BridgeMapMaker bridgeMapMaker = new BridgeMapMaker();
    private final String SIDE = "D";

    @Test
    @DisplayName("다리 구성 테스트(건널 수 있는 경우)")
    void validateCanCrossBridge() {
        final List<String> movingStatus = List.of("D", "U", "D", "D");
        final String bridgeMap = bridgeMapMaker
                .makeBridgeMap(movingStatus, SIDE)
                .toString();
        assertThat(bridgeMap).isEqualTo("[ O |   | O | O ]");
    }

    @Test
    @DisplayName("다리 구성 테스트(건널 수 없는 경우)")
    void validateCannotCrossBridge() {
        final List<String> movingStatus = List.of("U", "D", "D", "-D");
        final String bridgeMap = bridgeMapMaker
                .makeBridgeMap(movingStatus, SIDE)
                .toString();
        assertThat(bridgeMap).isEqualTo("[   | O | O | X ]");
    }
}
