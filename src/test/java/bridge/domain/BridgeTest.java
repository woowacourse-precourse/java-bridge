package bridge.domain;

import bridge.type.PositionType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BridgeTest {

    @Test
    void 인스턴스_생성_톄스트() {
        // given
        List<String> passBridges = List.of("U", "D", "D");

        // when
        Bridge bridge = new Bridge(passBridges);

        // then
        assertThat(bridge.size()).isEqualTo(3);
        assertThat(bridge.currentPosition(1)).isEqualTo(PositionType.DOWN);
    }
}