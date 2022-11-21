package bridge;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class BridgeMakerTest {

    BridgeMaker bridgeMaker;

    @BeforeEach
    void setUP() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("다리 길이로 n을 입력하면 문자열 'U' 또는 'D'로 구성된 길이 n의 다리가 생성")
    @Test
    void makeBridge() {
        int bridgeSize = 3;

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        System.out.println(bridge);
        assertThat(bridge.size()).isEqualTo(3);
        assertThat(bridge).containsAnyOf("U", "D");
    }
}