package bridge;

import java.util.List;

import static bridge.Check.checkBridge;

public class Application {
    
    private static InputView inputView;
    private static BridgeMaker bridgeMaker;
    

    public static void main(String[] args) {
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        String step = inputView.readMoving();
        boolean check = checkBridge(step, bridge);
        
    }
}
