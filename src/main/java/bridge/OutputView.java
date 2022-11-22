package bridge;

import java.util.List;

public class OutputView {

    public void printMap(List<String> userBridge, boolean restart) {
        printUpStairs(userBridge, restart);
        printDownStairs(userBridge, restart);
    }

    public void printResult(List<String> userBridge, boolean restart, int countGame) {
        System.out.println(BridgeConstant.END_GAME_RESULT.getValue());
        printMap(userBridge, restart);
        if (!restart) {
            printFailedResult(countGame);
            return;
        }
        printSuccessResult(countGame);
    }

    public void printStart() {
        System.out.println(BridgeConstant.GAME_START.getValue());
        System.out.println();
    }

    public void printLengthInput() {
        System.out.println(BridgeConstant.INPUT_BRIDGE_LENGTH.getValue());
    }

    public void printMovementInput() {
        System.out.println(BridgeConstant.GET_MOVEMENT.getValue());
    }

    public void printUpStairs(List<String> userBridge, boolean restart) {
        int index;
        System.out.print("[");
        for (index = 0; index < userBridge.size(); index++) {
            printXUp(index, userBridge, restart);
            printEdge(index, userBridge);
        }
        System.out.println("]");
    }

    public void printXUp(int index, List<String> userBridge, boolean restart) {
        if (index == userBridge.size() - 1) {
            if (!restart && userBridge.get(index).equals("U")) {
                System.out.print(" X ");
                return;
            }
        }
        printCircle(index, userBridge, "U");
    }

    public void printCircle(int index, List<String> userBridge, String UpDown) {
        if (userBridge.get(index).equals(UpDown)) {
            System.out.print(" O ");
            return;
        }
        System.out.print("   ");
    }

    public void printEdge(int index, List<String> userBridge) {
        if (index < userBridge.size() - 1) {
            System.out.print("|");
        }
    }

    public void printDownStairs(List<String> userBridge, boolean restart) {
        int index;
        System.out.print("[");
        for (index = 0; index < userBridge.size(); index++) {
            printXDown(index, userBridge, restart);
            printEdge(index, userBridge);
        }
        System.out.println("]");
        System.out.println();
    }

    public void printXDown(int index, List<String> userBridge, boolean restart) {
        if (index == userBridge.size() - 1) {
            if (!restart && userBridge.get(index).equals("D")) {
                System.out.print(" X ");
                return;
            }
        }
        printCircle(index, userBridge, "D");
    }

    public void printRetry() {
        System.out.println(BridgeConstant.RESTART.getValue());
    }

    public void printFailedResult(int countGame) {
        System.out.println(BridgeConstant.GAME_NOT_SUCCESS.getValue());
        System.out.println(BridgeConstant.TOTAL_GAME_PLAYS.getValue() + countGame);
    }

    public void printSuccessResult(int countGame) {
        System.out.println(BridgeConstant.GAME_SUCCESS.getValue());
        System.out.println(BridgeConstant.TOTAL_GAME_PLAYS.getValue() + countGame);
    }
}
