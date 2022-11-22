package bridge.View;

import bridge.Domain.GameResult;
import bridge.Utils.Message;

import java.util.List;

public class OutputView {

    static final String BRIDGE_LINK = " | ";
    static final String BRIDGE_FRONT = "[ ";
    static final String BRIDGE_TAIL = " ]";

    public void printGameStart() {
        System.out.println(Message.GAME_START_MESSAGE);
        System.out.println();
    }

    public void printMap(GameResult gameResult) {
        showBridgeResult(gameResult.getUpBridge());
        showBridgeResult(gameResult.getDownBridge());
    }

    public static void showBridgeResult(List<String> bridge) {
        System.out.println(BRIDGE_FRONT + String.join(BRIDGE_LINK, bridge) + BRIDGE_TAIL);
    }

    public void printResult(GameResult gameResult, int round) {
        System.out.println();
        System.out.println(Message.FINAL_RESULT_MESSAGE);
        printMap(gameResult);
        System.out.println();
        System.out.println(Message.FINAL_GAME_STATUS_MESSAGE + gameResult.getGameStatus().getStatus());
        System.out.println(Message.FINAL_ROUND_COUNT_MESSAGE + round);
    }
}
