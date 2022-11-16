package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    private BridgeMaker bridgeMaker;

    @BeforeEach
    private void init() {
        bridgeMaker=new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @Test
    void makeBridge() {
        List<String> bridge = bridgeMaker.makeBridge(10);
        System.out.println(bridge);
    }
}