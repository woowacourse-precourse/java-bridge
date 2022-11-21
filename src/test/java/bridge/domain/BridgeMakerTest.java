package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeMakerTest {
    private BridgeMaker bridgeMaker;

    @Test
    @DisplayName("다리의 길이가 size만큼 생성되는지 확인하는 테스트")
    void 다리_길이_테스트() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        for (int i = 3; i < 20; i++) {
            List<String> bridge = bridgeMaker.makeBridge(i);
            Assertions.assertThat(bridge.size()).isEqualTo(i);
        }
    }

}