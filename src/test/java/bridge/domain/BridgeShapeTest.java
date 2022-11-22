package bridge.domain;

import bridge.view.OutputView;
import org.junit.jupiter.api.*;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


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
