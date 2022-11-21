package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {
    @Test
    void 브릿지_생성_테스트() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        List<String> bridges = bridgeMaker.makeBridge(3);
        Assertions.assertThat(bridges)
                .hasSize(3)
                .isSubsetOf("U", "D");
    }
}
