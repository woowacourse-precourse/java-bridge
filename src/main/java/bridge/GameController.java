package bridge;

import bridge.views.OutputView;

import java.util.List;

import static bridge.enums.Sentence.RESULT;
import static bridge.enums.Sentence.returnSuccessOrFailure;

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
        for (String s : bridge) {
            String userMoveInput = reEnter.reGetMoveString();
            moving.moving(s, userMoveInput);
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
