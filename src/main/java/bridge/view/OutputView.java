package bridge.view;

import java.util.ArrayList;
import java.util.Map;

import static bridge.State.isUP;
import static bridge.view.Message.*;

public class OutputView {

    StringBuilder top;
    StringBuilder down;

    public void printMap(Map<Integer, ArrayList<String>> playerBridge) {
        buildTop();
        printPlayerBridgeTop(playerBridge);
        printPlayerBridgeDown(playerBridge);
        buildBottom();
        System.out.println(top);
        System.out.println(down+"\n");
    }

    public void buildTop() {
        top = new StringBuilder();
        top.append(BRIDGE_OPEN);
        down = new StringBuilder();
        down.append(BRIDGE_OPEN);
    }

    public void buildBottom() {
        top.append(BRIDGE_CLOSE);
        down.append(BRIDGE_CLOSE);
    }

    public void printPlayerBridgeTop(Map<Integer, ArrayList<String>> playerBridge) {
        for (int i = 0; i < playerBridge.size(); i++) {
            checkUpper(playerBridge.get(i).get(0), playerBridge.get(i).get(1));

            if (i != (playerBridge.size() - 1)) {
                top.append(BRIDGE_DIV);
            }
        }
    }

    void checkUpper(String target, String target2) {
        if (isUP(target)) {
            top.append(target2);
            return;
        }
        top.append(BRIDGE_BLANK);
    }

    public void printPlayerBridgeDown(Map<Integer, ArrayList<String>> playerBridge) {
        for (int i = 0; i < playerBridge.size(); i++) {
            checkDowner(playerBridge.get(i).get(0), playerBridge.get(i).get(1));

            if (i != (playerBridge.size() - 1)) {
                down.append(BRIDGE_DIV);
            }
        }
    }

    void checkDowner(String target, String target2) {
        if (isUP(target)) {
            down.append(BRIDGE_BLANK);
            return;
        }
        down.append(target2);
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
