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
        Bridge bridgeGame = new Bridge(list);

        // then
        assertThat(bridgeGame.isLastBlock()).isEqualTo(false);
        assertThat(bridgeGame.getLastBlock()).isEqualTo(0);
    }
}