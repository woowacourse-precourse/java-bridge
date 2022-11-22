package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {
    @DisplayName("유저 입력과 결과가 같은지 확인")
    @Test
    void updateCheck() {
        Bridge bridge = new Bridge(List.of("U", "D"));
        assertThat(bridge.update("U")).isEqualTo(true);
        assertThat(bridge.update("U")).isEqualTo(false);
    }
}
