package bridge.view;

import bridge.model.BridgeGame;

import java.util.List;

import static bridge.view.ViewEnum.*;

public class OutputView {
    private static final String PRINT_U = "U";
    private static final String PRINT_D = "D";

    public static void printGameStart() {
        System.out.println(OUTPUT_GAME_START_MESSAGE.getMessage());
    }

    public static void printMap(BridgeGame bridgeGame) {
        printBridge(bridgeGame.getUpPresentBridge(),bridgeGame.getUserMoveList(),PRINT_U);
        printBridge(bridgeGame.getDownPresentBridge(),bridgeGame.getUserMoveList(),PRINT_D);
    }

    private static void printBridge(List<String> presentBridge,List<String> userMoveList,String userNumber){
        printContinueBridge(presentBridge,userMoveList,userNumber);
        printEndBridge(presentBridge,userMoveList,userNumber);
    }


    private static void printContinueBridge(List<String> presentBridge,List<String> userMoveList,String userNumber){
        System.out.print(PRINT_START_BRIDGE.getMessage());
        for (int i = 0; i < presentBridge.size()- 1; i++) {
            if (userMoveList.get(i).equals(userNumber)) {
                System.out.printf(PRINT_CONTINUE_HAVE_BRIDGE.getMessage(), presentBridge.get(i));
                continue;
            }
            System.out.print(PRINT_CONTINUE_BRIDGE.getMessage());
        }
    }

    private static void printEndBridge(List<String> presentBridge,List<String> userMoveList,String userNumber){
        if (userMoveList.get(presentBridge.size() - 1).equals(userNumber)) {
            System.out.printf(PRINT_END_HAVE_BRIDGE.getMessage(), presentBridge.get(presentBridge.size() - 1));
            return;
        }
            System.out.printf(PRINT_END_BRIDGE.getMessage());
    }


    public static void printResult(BridgeGame bridgeGame) {
        System.out.println(OUTPUT_GAME_RESULT_MAP_PRINT_MESSAGE.getMessage());

        printMap(bridgeGame);

        System.out.printf(OUTPUT_GAME_RESULT_MESSAGE.getMessage(), bridgeGame.getGameBoolean());
        System.out.printf(OUTPUT_TOTAL_GAME_COUNT_MESSAGE.getMessage(), bridgeGame.getGameCount());
    }
}
