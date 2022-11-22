package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeMakerTest {
    /**
     * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
     */
    @Test
    void 다리_길이_테스트() {
        BridgeRandomNumberGenerator randomNum = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(randomNum);
        List<String> yourBridge = bridgeMaker.makeBridge(3);
        assertThat(yourBridge.size()).isEqualTo(3);
    }
}