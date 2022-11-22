package bridge.view;

import java.util.ArrayList;
import java.util.Map;

import static bridge.view.Message.PRINT_ACCESS_MESSAGE;
import static bridge.view.Message.PRINT_ATTEMPT_COUNT_MESSAGE;
import static bridge.view.Message.PRINT_FAIL_MESSAGE;
import static bridge.view.Message.PRINT_RESULT_MESSAGE;

public class OutputView {

    StringBuilder top;
    StringBuilder down;

    public void printMap(Map<Integer, ArrayList<String>> playerBridge) {
        buildTop();
        printPlayerBridgeTop(playerBridge);
        printPlayerBridgeDown(playerBridge);
        buildBottom();
        System.out.println(top);
        System.out.println(down);
        System.out.println("\n");
    }

    public void buildTop() {
        top = new StringBuilder();
        top.append("[ ");
        down = new StringBuilder();
        down.append("[ ");
    }

    public void buildBottom() {
        top.append(" ]");
        down.append(" ]");
    }

    public void printPlayerBridgeTop(Map<Integer, ArrayList<String>> playerBridge) {
        for (int i = 0; i < playerBridge.size(); i++) {
            checkUpper(playerBridge.get(i).get(0), playerBridge.get(i).get(1));

            if (i != (playerBridge.size() - 1)) {
                top.append(" | ");
            }
        }
    }

    void checkUpper(String target, String target2) {
        if (target.equals("U")) {
            top.append(target2);
        }
        if (target.equals("D")) {
            top.append(" ");
        }
    }

    public void printPlayerBridgeDown(Map<Integer, ArrayList<String>> playerBridge) {
        for (int i = 0; i < playerBridge.size(); i++) {
            checkDowner(playerBridge.get(i).get(0), playerBridge.get(i).get(1));

            if (i != (playerBridge.size() - 1)) {
                down.append(" | ");
            }
        }
    }

    void checkDowner(String target, String target2) {
        if (target.equals("U")) {
            down.append(" ");
        }
        if (target.equals("D")) {
            down.append(target2);
        }
    }

    public void printResult(Map<Integer, ArrayList<String>> playerBridge, boolean isSuccess) {
        System.out.println(PRINT_RESULT_MESSAGE);
        printMap(playerBridge);
        if (isSuccess) {
            System.out.println(PRINT_ACCESS_MESSAGE);
        }
        if (!isSuccess) {
            System.out.println(PRINT_FAIL_MESSAGE);
        }
    }

    public void printTotalAttempts(int attempts) {
        System.out.println(PRINT_ATTEMPT_COUNT_MESSAGE + attempts);
    }
}
