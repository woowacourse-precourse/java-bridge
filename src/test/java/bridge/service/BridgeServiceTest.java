package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeMaker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
}
