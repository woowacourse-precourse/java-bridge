package bridge;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @Test
    void makeBridge() {
        int size = 10;
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        List<String> strings = bridgeMaker.makeBridge(size);

        Assertions.assertThat(strings).hasSize(size);
    }
}