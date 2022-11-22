package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    BridgeMaker bridgeMaker;

    @BeforeEach
    void setting() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("다리는 U, D만 포함해야 한다.")
    @Test
    void makeBridgeTest() {
        Assertions.assertThat(bridgeMaker.makeBridge(20)).containsOnly("U", "D");
    }
}