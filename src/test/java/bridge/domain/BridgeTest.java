package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {
    @DisplayName("다리의 결과가 잘 생성되어 반환 되는지 테스트한다.")
    @Test
    void getBridge() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        assertThat(bridge.getBridge()).isEqualTo(List.of("U", "D", "D"));
    }
}