package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BridgeTest {

    @Test
    @DisplayName("다리의 길이는 3이 나와야 한다.")
    void createBridge_getCount() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        assertThat(bridge.getCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("생성된 다리의 안전지역이 같아야 한다.")
    void createBridge_getBridges() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        assertThat(bridge.getBridges().toString()).isEqualTo(List.of("U", "D", "D").toString());
    }
}
