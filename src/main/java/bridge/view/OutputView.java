package bridge.view;

import bridge.constants.InGameMessage;
import bridge.domain.GameStatus;
import java.util.List;

public class OutputView {

    private static final String BRIDGE_DIVISION = " | ";
    private static final String OUTPUT_FORM = "[ %s ]\n";

    public void printMap(GameStatus gameStatus) {
        System.out.printf(OUTPUT_FORM, bridgeToMap(gameStatus.topBridge));
        System.out.printf(OUTPUT_FORM, bridgeToMap(gameStatus.bottomBridge));
    }

    public void printResult(GameStatus gameStatus) {
        System.out.println(InGameMessage.FINAL_GAME_RESULT);
        printMap(gameStatus);
        System.out.println(InGameMessage.WHETHER_GAME_IS_SUCCESSFUL + gameStatus.gameResult);
        System.out.println(InGameMessage.TOTAL_TRY_COUNT + Integer.toString(gameStatus.tryCount));
    }

    public String bridgeToMap(List<String> bridge) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < bridge.size() - 1; i++) {
            str.append(bridge.get(i));
            str.append(BRIDGE_DIVISION);
        }

        str.append(bridge.get(bridge.size() - 1));
        return str.toString();
    }

    public void askBridgeSize() {
        System.out.println(InGameMessage.BRIDGE_SIZE);
    }

    public void printStart() {
        System.out.println(InGameMessage.START);
    }

    public void askSpaceToMove() {
        System.out.println(InGameMessage.SPACE_TO_MOVE);
    }

    public void askWhetherToRetry() {
        System.out.println(InGameMessage.WHETHER_TO_RETRY);
    }
}
