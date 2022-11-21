package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class BridgeMakerTest {
    private BridgeMaker bridgeMaker;

    @BeforeEach
    public void setup() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("다리 생성")
    @ParameterizedTest
    @ValueSource(strings = {"3", "10", "15"})
    public void createBridge(int size) {
        assertThat(bridgeMaker.makeBridge(size)).containsAnyOf("U", "D");
    }
}