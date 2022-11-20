package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        InputView input = new InputView();
        int BridgeSize = 0;
        while (BridgeSize == 0){
            BridgeSize = input.readBridgeSize();
        }

        BridgeNumberGenerator rn = new BridgeRandomNumberGenerator();
        BridgeMaker answer_bridge = new BridgeMaker(rn);
        answer_bridge.makeBridge(BridgeSize);

        // TODO: 프로그램 구현
    }
}
