package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    @DisplayName("넘버가010이면 브릿지쉐이프는 DUD으로 리턴")
    @Test
    void makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeSequenceNumberGenerator(List.of(0, 1, 0)));

        List<String> bridgeShape = bridgeMaker.makeBridge(3);
        Assertions.assertThat(bridgeShape).isEqualTo(List.of("D", "U", "D"));
    }
}