package bridge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 20})
    void makeBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> result = bridgeMaker.makeBridge(size);
        assertThat(result.size()).isEqualTo(size);
        assertThat(result.stream().filter(
                block -> block.equals("U") || block.equals("D")).count()
        ).isEqualTo(size);
    }
}