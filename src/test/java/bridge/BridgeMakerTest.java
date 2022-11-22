package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    @Test
    void makeBridge() {
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());

        List<String> result = maker.makeBridge(3);

        assertThat(result.size()).isEqualTo(3);

        assertThat(result.contains("U") || result.contains("D")).isTrue();
    }
}