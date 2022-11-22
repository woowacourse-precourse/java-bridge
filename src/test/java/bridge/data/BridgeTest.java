package bridge.data;

import static org.assertj.core.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BridgeTest {
    Bridge bridge = new Bridge(Arrays.asList("U", "D", "D"));

    @DisplayName("입력받는 다리의 순서와 사용자의 입력값을 가지고 다리의 값과 비교하여 같으면 true를 반환한다")
    @Test
    void createStateIsBoolean() {
        assertThat(bridge.state(2, "D")).isEqualTo(true);
    }
}
