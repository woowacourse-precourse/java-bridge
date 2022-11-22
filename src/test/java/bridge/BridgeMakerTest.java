package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeMakerTest {

    @Test
    void TestMakeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> list = bridgeMaker.makeBridge(3);
        assertThat(list).hasSize(3);
        List<String> list2 = bridgeMaker.makeBridge(14);
        assertThat(list2).hasSize(14);
    }
}