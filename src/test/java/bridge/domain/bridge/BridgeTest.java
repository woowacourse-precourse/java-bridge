package bridge.domain.bridge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BridgeTest {

    BridgeNumberGenerator bridgeNumberGenerator;

    @BeforeAll
    void init() {
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    }

    @DisplayName("다리 생성")
    @Test
    void createBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        int size = 3;
        List<String> bridgeInformation = bridgeMaker.makeBridge(size);

        Bridge bridge = new Bridge(bridgeInformation);

        assertThat(bridge.getSize()).isEqualTo(3);
        assertThat(bridge.toString()).satisfiesAnyOf(
                bridgeParam -> assertThat(bridgeParam).contains("U"),
                bridgeParam -> assertThat(bridgeParam).contains("D")
        );
    }
}