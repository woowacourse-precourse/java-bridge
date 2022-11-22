package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
    @DisplayName("다리 생성하는 기능 테스트")
    @Test
    public void 다리_생성() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int size = 8;
        List<String> bridge = bridgeMaker.makeBridge(size);
        assertThat(bridge.size()).isEqualTo(size);
        assertThat(bridge.stream().allMatch(b -> b.matches("[DU]"))).isTrue();
    }
}