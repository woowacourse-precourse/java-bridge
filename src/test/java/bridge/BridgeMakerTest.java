package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BridgeMakerTest {

    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    @DisplayName("입력된 숫자만큼 랜덤 다리 생성")
    @Test
    void makeRandomBridge() {

        assertThat(bridgeMaker.makeBridge(3).size()).isEqualTo(3);
    }

}