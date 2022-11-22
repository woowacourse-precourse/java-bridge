package bridge.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeServiceTest {
    private final BridgeService bridgeService = new BridgeService();

    @DisplayName("다리를 생성해주는 makeBridge 테스트")
    @Test
    public void makeBridgeTest() {
        // given
        int bridgeSize = 5;

        // when
        List<String> bridge = bridgeService.makeBridgeGame(bridgeSize);

        // then
        assertThat(bridge.size()).isEqualTo(bridgeSize);
        assertThat(bridge.contains("U") || bridge.contains("D")).isEqualTo(true);
    }
}
