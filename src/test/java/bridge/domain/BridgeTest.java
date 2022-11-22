package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BridgeTest {

    @DisplayName("생성자 테스트")
    @Test
    public void BridgeConstructorAndGetterTest() {
        // given
        List<String> list = List.of("U", "D", "D");

        // when
        Bridge bridge = new Bridge(list);

        // then
        assertThat(bridge.isLastBlock()).isEqualTo(false);
        assertThat(bridge.getCurrentBlock()).isEqualTo(0);
    }

    @DisplayName("reset 테스트")
    @Test
    public void resetTest() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        bridge.move();
        bridge.move();
        bridge.move();

        // when
        bridge.retry();

        // then
        assertThat(bridge.getCurrentBlock()).isEqualTo(0);
    }

    @DisplayName("move 테스트")
    @Test
    public void currentBlockTest() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "D"));

        // when
        bridge.move();

        // then
        assertThat(bridge.getCurrentBlock()).isEqualTo(1);
    }
}