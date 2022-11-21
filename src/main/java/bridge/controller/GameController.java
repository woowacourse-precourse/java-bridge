package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Moving;
import bridge.model.ReEnter;
import bridge.views.OutputView;

import java.util.List;

import static bridge.enums.Sentence.*;

public class GameController {

    private final Moving moving = new Moving();
    private final ReEnter reEnter = new ReEnter();
    private boolean isTrue = true;
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

    public void playTheGaming() {
        List<String> bridge = gameSet(reEnter.reGetBridgeLength());
        while (isTrue) {
            gamingSet(bridge);
            if (!isClear) {
                printMovingAndResult();
                break;
            }
            isTrue = BridgeGame.retry();
        }
    }

    public static void printMovingAndResult() {
        System.out.println(RESULT.getValue());
        Moving.printMoving();
        OutputView.printResult(returnSuccessOrFailure(!isClear), TRY_COUNT);
    }
}
