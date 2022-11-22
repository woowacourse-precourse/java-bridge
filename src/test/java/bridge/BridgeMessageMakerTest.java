package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class BridgeMessageMakerTest {
    BridgeMessageMaker bridgeMessageMaker = new BridgeMessageMaker(List.of("U", "D", "D", "U"));

    @DisplayName("다리 상태 메시지 생성 검증")
    @Test
    public void checkBridgeMessageMaking() {
        assertThat(bridgeMessageMaker.makeBridgeMessage("D", 2))
                .isEqualTo("[ O |   |   ]\n[   | O | O ]");
    }
}
