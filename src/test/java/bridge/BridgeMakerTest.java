package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    @DisplayName("다리가 잘 생성되는지에 대한 검사")
    @Test
    void makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = new ArrayList<>();
        bridge = bridgeMaker.makeBridge(5);
        System.out.println(bridge);
    }
}