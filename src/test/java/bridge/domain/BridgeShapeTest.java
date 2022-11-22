package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


public class BridgeShapeTest {

    BridgeShape bridgeShape;
    MyBridge myBridge;
    @DisplayName("input list에 따라 다리 모양을 생성한다.")
    @Test
    void makeBridgeShape() throws Exception{
        myBridge = new MyBridge(List.of("U", "U", "D", "D"), List.of("U"));
        bridgeShape.makeLines(myBridge);
    }
}
