package bridge;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {
    @Test
    void makeBridge_given_length() {
        List<String> result = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(10);
        assertThat(result).hasSize(10);

        int u = (int) result.stream().filter(e -> e.equals("U")).count();
        int d = (int) result.stream().filter(e -> e.equals("D")).count();

        assertThat(u + d).isEqualTo(10);
    }

}