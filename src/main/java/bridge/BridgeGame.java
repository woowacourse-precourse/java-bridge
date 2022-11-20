package bridge;

import java.util.List;

import static bridge.InputView.*;
import static bridge.enums.Sentence.*;

public class BridgeGame {

    private final Move move = new Move();
    private final OutputView outputView = new OutputView();
    private boolean isTrue = true;
    private boolean isClear = true;
    private int TRY_COUNT = 0;

    public static List<String> gameSet(int userInput) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(userInput);
    }

    public void gamingSet(List<String> bridge) {
        TRY_COUNT++;
        for (int i = 0; i < bridge.size(); i++) {
            String userMoveInput = getMoveString();
            move.moving(bridge.get(i), userMoveInput);
            move.printMoving();
            if (move.checkWrong()) {
                return;
            }
        }
        isClear = false;
    }

    public void playTheGaming() {
        List<String> bridge = gameSet(reGetBridgeLength());
        while (isTrue) {
            gamingSet(bridge);
            if (!isClear) {
                printMovingAndResult();
                break;
            }
            retry();
        }
    }

    public static boolean move(String computer, String userInput) {
        return computer.equals(userInput);
    }

    public boolean retry() {
        System.out.println(RESTART_OF_END.getValue());
        if (getExitOrRestart().equals("R")) {
            move.clearMoving();
            return isTrue = true;
        }
        printMovingAndResult();
        return isTrue = false;
    }

    public void printMovingAndResult() {
        System.out.println(RESULT.getValue());
        move.printMoving();
        outputView.printResult(returnSuccessOrFailure(!isClear), TRY_COUNT);
    }

}
