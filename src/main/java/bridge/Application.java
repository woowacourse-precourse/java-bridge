package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static boolean move_Status = true;
    public static void main(String[] args) {
        List<String> bridge;
        int num = 0;
        String currentMoving;
        List<String> result = new ArrayList<>();

        OutputView OV = new OutputView();
        OV.startGuidance();
        InputView IV = new InputView();
        BridgeNumberGenerator BNG = new BridgeRandomNumberGenerator();
        BridgeMaker BM = new BridgeMaker(BNG);
        bridge = BM.makeBridge(IV.readBridgeSize());
        BridgeGame BG = new BridgeGame();
        System.out.println(bridge);
        while(move_Status && num <bridge.size()) {
            OV.moveGuidance();
            currentMoving = IV.readMoving();
            List<String> movement = BG.move(bridge.get(num), currentMoving);
            result.add(movement.get(0));
            result.add(movement.get(1));
            OV.printMap(result, num);
            num++;
        }
//        OV.printMap(BG.move(bridge.get(num), currentMoving));
    }
}
