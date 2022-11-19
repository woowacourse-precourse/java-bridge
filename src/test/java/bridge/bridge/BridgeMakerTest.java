package bridge.bridge;

import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.Test;
import java.util.List;

import static java.util.Collections.frequency;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * BridgeMaker 클래스에 관련된 테스트 클래스입니다.
 * @version 1.0.0
 * @author CHO Min Ho
 */
class BridgeMakerTest {

    /**
     * makeBridge 메서드 (다리 생성 메서드)에 관련된 테스트 메서드입니다.
     */
    @Test
    void makeBridgeTest() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(6);

        // 1. 6개의 칸을 가진 다리가 생성되는지
        assertThat(bridge.size()).isEqualTo(6);

        // 2. U 또는 D로만 이루어져 있는지
        assertThat(frequency(bridge, "U") + frequency(bridge, "D")).isEqualTo(6);
    }
}