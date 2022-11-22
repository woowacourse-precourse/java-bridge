package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeMakerTest {

    private final BridgeMaker bridgeMaker;

    public BridgeMakerTest() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @Test
    void 다리_생성_크기_테스트() {
        List<List<String>> bridges = new ArrayList<>();
        List<Integer> sizes = Arrays.asList(3, 4, 5, 6, 7);

        for (int i = 3; i < 7; i++) {
            List<String> bridge = bridgeMaker.makeBridge(i);
            bridges.add(bridge);
        }

        for (int i = 0; i < bridges.size(); i++) {
            Assertions.assertThat(bridges.get(i).size()).isEqualTo(sizes.get(i));
        }
    }

    @Test
    void 다리_생성_칸_테스트() {
        List<String> bridge = bridgeMaker.makeBridge(20);

        for (int i = 0; i < bridge.size(); i++) {
            String element = bridge.get(i);
            Assertions.assertThat(element).containsAnyOf("U", "D");
        }
    }
}
