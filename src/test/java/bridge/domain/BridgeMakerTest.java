package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    BridgeMaker bridgeMaker;

    private void initMockBridgeNumberGenerator(Queue<Integer> numbers) {
        bridgeMaker = new BridgeMaker(numbers::poll);
    }

    @Test
    void 다리_만들기_성공() throws Exception {
        Queue<Integer> numbers = new LinkedList<>(Arrays.asList(1, 0, 1, 1, 0));
        initMockBridgeNumberGenerator(numbers);
        List<String> bridge = bridgeMaker.makeBridge(5);
        assertThat(bridge).containsExactly("1", "0", "1", "1", "0");
    }
}