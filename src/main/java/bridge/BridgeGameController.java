package bridge;

import java.util.List;

import static bridge.BridgeGameMessage.*;


public class BridgeGameController {

    private final ReInput reInput = new ReInput();
    private final Move move = new Move();
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
            move.moving(stage, reInput.reGetMoveString());
            Move.printMoving();
            if (move.checkWrong()) {
                return;
            }
        }
        isClear = false;
    }

    public void playTheGaming() {
        List<String> bridge = gameSet(reInput.reGetBridgeLength());
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
        Move.printMoving();
        OutputView.printResult(returnSuccessOrFailure(!isClear), TRY_COUNT);
    }
}
