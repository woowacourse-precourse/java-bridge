package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {

    private BridgeMaker bridgeMaker;

    @BeforeEach
    void init() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("입력받은 input과 같은 길이의 bridge를 만든다.")
    @ParameterizedTest
    @ValueSource(ints = {3,11,15,20})
    void makeBridgeTest1(int input) {
        List<String> bridge = bridgeMaker.makeBridge(input);
        assertThat(bridge.size()).isEqualTo(input);
    }

    @DisplayName("생성된 다리는 U 또는 D 로만 이루어져있다.")
    @Test
    void makeBridgeTest2() {
        List<String> bridge = bridgeMaker.makeBridge(20);
        assertThat(bridge).containsOnly("U","D");
    }
}
