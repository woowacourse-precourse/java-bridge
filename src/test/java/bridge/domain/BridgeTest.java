package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @DisplayName("위 칸을 건널 수 있는 경우 U, 아래 칸을 건널 수 있는 경우 D값으로 다리를 생성하는 테스트")
    @Test
    void createByBridgeShapeValue() {
        Bridge actual = Bridge.createByBridgeShapeValue(List.of("U", "D", "U"));

        assertThat(actual).isEqualTo(new Bridge(List.of(BridgeShape.UP, BridgeShape.DOWN, BridgeShape.UP)));
    }
}
