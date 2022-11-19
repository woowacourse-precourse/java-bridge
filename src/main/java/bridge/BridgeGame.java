package bridge;

import java.util.List;

import static bridge.InputView.*;
import static bridge.enums.Sentence.*;

public class BridgeGame {

    private final Move move = new Move();
    private final OutputView outputView = new OutputView();
    private boolean isTrue = true;
    //private boolean isClear = true;

    public static List<String> gameSet(int userInput) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(userInput);
    }

    public void gamingSet(List<String> bridge) {
        for (int i = 0; i < bridge.size(); i++) {
            String userMoveInput = getMoveString();
            move.moving(bridge.get(i), userMoveInput);
            move.printMoving();
            if (move.checkWrong()) {
                return;
            }
        }
    }

    public static boolean move(String computer, String userInput) {
        return computer.equals(userInput);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
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
        outputView.printResult();
    }
}
