package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeTest {

    @Test
    public void makeBridgeTest() {
        List<Integer> bridgeNumbers = List.of(1,0,1,0,1);
        BridgeMaker bridgeMaker = makeTestBridge(bridgeNumbers);
        List<String> bridge = bridgeMaker.makeBridge(bridgeNumbers.size());
        assertThat(bridge).isEqualTo(new ArrayList<>(List.of("D", "U", "D", "U", "D")));
    }

    private BridgeMaker makeTestBridge(List<Integer> bridge){
        return new BridgeMaker(new testBridgeGenerator(bridge));
    }
}

class testBridgeGenerator implements BridgeNumberGenerator{
    private final List<Integer> bridge;
    private int pointer;

    testBridgeGenerator(List<Integer> bridge) {
        this.bridge = bridge;
        this.pointer = 0;
    }

    @Override
    public int generate() {
        return bridge.get(pointer++);
    }
}