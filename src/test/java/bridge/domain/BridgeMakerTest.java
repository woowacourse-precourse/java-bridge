package bridge.domain;

import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {

    @DisplayName("리스트에 U와 D가 포함되는지 검증")
    @Test
    void makeBridgeTest() {
        BridgeMaker bridgeMaker;
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(5);
        assertThat(bridge).containsOnly("U","D");
    }
}
