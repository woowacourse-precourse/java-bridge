package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeMaker;
import bridge.model.Bridge;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeServiceTest {
    static BridgeService bridgeService;

    @BeforeAll
    static void setBridgeService() {
        bridgeService = new BridgeService(new BridgeMaker(new BridgeRandomNumberGenerator()));
    }

    @Test
    void getCanShapeTest() {
        assertThat(bridgeService.getCanShape(true)).isEqualTo("O");
        assertThat(bridgeService.getCanShape(false)).isEqualTo("X");
    }

    @ParameterizedTest
    @ValueSource(ints = {3,4,5,6,7})
    void makeBridgeTest(int size) {
        assertThat(bridgeService.makeBridge(size)).isInstanceOf(Bridge.class);

        Bridge bridge = bridgeService.makeBridge(size);
        assertThat(bridge.getBridge().size()).isEqualTo(size);

    }
}
