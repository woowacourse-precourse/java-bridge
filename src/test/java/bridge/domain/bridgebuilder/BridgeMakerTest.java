package bridge.domain.bridgebuilder;

import bridge.BridgeRandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    private static final int BRIDGE_SIZE_INPUT = 5;

    BridgeMaker bridgeMaker;

    @BeforeEach
    void setBridgeMaker() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("만든 List가 String으로 이루어진게 맞는지 확인하는 테스트")
    @Test
    void makeUDBridgeTest() {
        Assertions.assertThat(bridgeMaker.makeBridge(BRIDGE_SIZE_INPUT).get(2))
                .isInstanceOf(String.class);
    }

    @DisplayName("만든 List가 size에 맞게 만들어졌는지 확인하는 테스트")
    @Test
    void checkSizeOfBridgeTest() {
        Assertions.assertThat(bridgeMaker.makeBridge(BRIDGE_SIZE_INPUT).size())
                .isEqualTo(BRIDGE_SIZE_INPUT);
    }
}