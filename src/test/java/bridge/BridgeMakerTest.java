package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    @DisplayName("다리 길이가 주어지면 다리를 정상적으로 생성한다.")
    @Test
    void 다리를_정상적으로_만드는_경우() {
        // given
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        // when
        List<String> bridge = bridgeMaker.makeBridge(10);

        // then
        assertThat(bridge).hasSize(10);
        bridge.stream()
                .forEach(elem -> assertThat(elem).isIn(new String[]{"U", "D"}));
    }
}