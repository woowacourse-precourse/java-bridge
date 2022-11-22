package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BridgeTest {

    @DisplayName("입력받은 다리 길이만큼 다리 생성")
    @Test
    public void makeBridgeTest() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
       assertEquals(bridgeMaker.makeBridge(3).size(), 3);
    }

}
