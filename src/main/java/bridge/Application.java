package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<String> bridge;
        int num = 0;
        OutputView OV = new OutputView();
        OV.startGuidance();
        InputView IV = new InputView();
        BridgeNumberGenerator BNG = new BridgeRandomNumberGenerator();
        BridgeMaker BM = new BridgeMaker(BNG);
        bridge = BM.makeBridge(IV.readBridgeSize());
        OV.moveGuidance();
        String currentMoving = IV.readMoving();
        BridgeGame BG = new BridgeGame();
        List<String> movement = BG.move(bridge.get(num), currentMoving);
        OV.printMap(movement);
//        OV.printMap(BG.move(bridge.get(num), currentMoving));
    }
}
