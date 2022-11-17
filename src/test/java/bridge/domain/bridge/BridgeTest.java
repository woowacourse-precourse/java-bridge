package bridge.domain.bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @Test
    @DisplayName("다리를 생성할 때, 다리모양숫자들에 맞게 다리가 생성된다.")
    void checkBridgeShapeTest() {
        //given
        List<String> bridgeShapeNumbers = List.of("0", "1");

        //when
        Bridge bridge = new Bridge(bridgeShapeNumbers);

        //then
        List<String> generatedBridge = bridge.getBridge();
        assertThat(generatedBridge.get(0)).isEqualTo("D");
        assertThat(generatedBridge.get(1)).isEqualTo("U");
    }
}
