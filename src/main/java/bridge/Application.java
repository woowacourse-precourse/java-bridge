package bridge;

import bridge.view.InputView;
import java.util.List;


public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

        BridgeMaker user = new BridgeMaker(bridgeNumberGenerator);
        int size = InputView.readBridgeSize();
        List<String> userBridge = user.makeBridge(size);
        System.out.println(userBridge);
        for (int index = 0; index < size; index++) {
            String userDirection = InputView.readMoving();
            BridgeGame.move(userDirection,userBridge,index);
        }
    }
}
