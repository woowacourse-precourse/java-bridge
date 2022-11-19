package bridge;

import bridge.BridgeMaker.BridgeMaker;
import bridge.BridgeMaker.NumberGenerator.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {
    @DisplayName("길이가 3인 다리를 생성하는 메서드를 호출하면 그 결과로 길이가 3인 다리가 생성되어야 한다.")
    @Test
    void makeBridgeSize3ToSuccessful() {
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        assertThat(bridgeMaker.makeBridge(3).size() == 3);
    }
}
