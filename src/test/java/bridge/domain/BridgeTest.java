package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @Test
    @DisplayName("다리 정상 생성 테스트입니다.")
    void bridgeCreatingTest() {
        assertThat(new Bridge(List.of("U", "D", "D")))
                .isInstanceOf(Bridge.class);
    }

    @Test
    @DisplayName("다리는 길이가 3이상 20이하여야 합니다.")
    void bridgeLengthErrorTest() {
        assertThatThrownBy(() -> new Bridge(List.of("U", "D")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}