package bridge.view;

import bridge.constants.InGameMessage;
import bridge.domain.Bridge;
import bridge.domain.GameStatus;

public class OutputView {

    private static final String BRIDGE_DIVISION = " | ";
    private static final String OUTPUT_FORM = "[ %s ]\n";

    public void printMap(GameStatus gameStatus) {
        System.out.printf(OUTPUT_FORM, bridgeToMap(gameStatus.topBridge));
        System.out.printf(OUTPUT_FORM, bridgeToMap(gameStatus.bottomBridge));
        printNewLine();
    }

    public void printResult(GameStatus gameStatus) {
        System.out.println(InGameMessage.FINAL_GAME_RESULT);
        printMap(gameStatus);
        System.out.println(InGameMessage.WHETHER_GAME_IS_SUCCESSFUL + gameStatus.getGameResult());
        System.out.println(InGameMessage.TOTAL_TRY_COUNT + Integer.toString(gameStatus.getTryCount()));
    }

    public String bridgeToMap(Bridge bridge) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < bridge.getSize() - 1; i++) {
            str.append(bridge.getDataForOutput(i));
            str.append(BRIDGE_DIVISION);
        }

        str.append(bridge.getDataForOutput(bridge.getSize() - 1));
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

    public void printNewLine() {
        System.out.println();
    }
}
