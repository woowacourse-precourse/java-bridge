package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Moving;
import bridge.model.ReEnter;

import java.util.List;

public class GameController {

    private final ReEnter reEnter = new ReEnter();
    private final Moving moving = new Moving();

    private static boolean isClear = true;
    private static int TRY_COUNT = 0;


    public static List<String> gameSet(int userInput) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(userInput);
    }

    public void gamingSet(List<String> bridge) {
        TRY_COUNT++;
        for (String stage : bridge) {
            moving.moving(stage, reEnter.reGetMoveString());
            Moving.printMoving();
            if (moving.checkWrong()) {
                return;
            }
        }
        isClear = false;
    }
}
