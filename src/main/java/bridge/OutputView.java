package bridge;

import java.util.List;

public class OutputView {

    public void printMap(List<String> userBridge, boolean restart) {
        printUpStairs(userBridge, restart);
        printDownStairs(userBridge, restart);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> userBridge, boolean restart, int countGame) {
        System.out.println(BridgeConstant.END_GAME_RESULT.getValue());
        printMap(userBridge, restart);
        if (!restart) {
            System.out.println(BridgeConstant.GAME_NOT_SUCCESS.getValue());
            System.out.println(BridgeConstant.TOTAL_GAME_PLAYS.getValue() + countGame);
        }

    }

    public void printStart() {
        System.out.println(BridgeConstant.GAME_START.getValue());
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

}
