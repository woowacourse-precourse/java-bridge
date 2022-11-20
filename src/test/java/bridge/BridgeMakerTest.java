package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class BridgeMakerTest {


    BridgeMaker bridgeMaker;
    private final int size = 10;

    @BeforeEach
    void init(){
        bridgeMaker = new BridgeMaker(new BridgeTestNumberGenerator());
    }

    @Test
    void checkBridgeSize(){
        List<String> bridge = bridgeMaker.makeBridge(size);
        assertThat(bridge.size()).isEqualTo(size);
    }

    @Test
    void checkBridgeHasOnlyD(){
        int size = 10;
        List<String> bridge = bridgeMaker.makeBridge(size);
        assertThat(bridge.contains("U")).isEqualTo(false);
    }

    @Test
    void checkBridgeListBySameStringList(){
        int size = 10;
        List<String> bridge = bridgeMaker.makeBridge(size);
        assertThat(bridge).isEqualTo(List.of("D","D","D","D","D","D","D","D","D","D"));
    }

}