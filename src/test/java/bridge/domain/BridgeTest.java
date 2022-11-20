package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BridgeTest {
    List<String> bridgeTest = new ArrayList<>(List.of("U", "D", "D"));
    Bridge bridge = new Bridge(bridgeTest);

    @Test
    void 횡단_성공을_알리는_지_테스트() {
        assertThat(bridge.isRightTrack(2, "D")).isEqualTo(BridgeCrossingStatus.SUCCESS);
    }

    @Test
    void 횡단_실패를_알리는_지_테스트() {
        assertThat(bridge.isRightTrack(0, "D")).isEqualTo(BridgeCrossingStatus.FAIL);
    }

    @Test
    void 횡단_진행_중임을_알리는_지_테스트() {
        assertThat(bridge.isRightTrack(1, "D")).isEqualTo(BridgeCrossingStatus.PROGRESS);
    }
}
