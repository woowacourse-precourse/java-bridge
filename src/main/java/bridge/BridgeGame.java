package bridge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BridgeGame {

    static int count = 0;
    static String select = "";
    static Map<Integer, String> firstStorage = new HashMap<>();
    static Map<Integer, String> secondStorage = new HashMap<>();

    public String[] move(List<String> firstBridge, List<String> secondBridge, String move) {
        bridgeSet(firstBridge, secondBridge);
        String firstBridgeMap = moveFirstBridge(firstBridge, move);
        String secondBridgeMap = moveSecondBridge(secondBridge, move);
        String bridgeMap[] = {firstBridgeMap, secondBridgeMap};
        count++;
        select = "";
        return bridgeMap;
    }

    private void bridgeSet(List<String> firstBridge, List<String> secondBridge) {
        for (int i = 0; i < firstBridge.size(); i++) {
            if (firstBridge.get(i).equals("U")) {
                firstBridge.set(i, "O");
                secondBridge.set(i, "X");
            }
            if (firstBridge.get(i).equals("D")) {
                firstBridge.set(i, "X");
                secondBridge.set(i, "O");
            }
        }
    }

    private String moveFirstBridge(List<String> firstBridge, String move) {
        StringBuilder firstSb = new StringBuilder();
        firstStorage.put(-1, "");
        firstSb.append(firstStorage.get(count - 1));
        firstBridgeMoveDown(firstSb, move);
        firstBridgeMoveUp(firstSb, firstBridge, move);
        firstStorage.put(count, firstSb.toString());
        return firstSb.toString();
    }

    private String moveSecondBridge(List<String> secondBridge, String move) {
        secondStorage.put(-1, "");
        StringBuilder secondSb = new StringBuilder();
        secondSb.append(secondStorage.get(count - 1));
        secondBridgeMoveDown(secondSb, secondBridge, move);
        secondBridgeMoveUp(secondSb, move);
        secondStorage.put(count, secondSb.toString());
        return secondSb.toString();
    }

    private void firstBridgeMoveUp(StringBuilder firstSb, List<String> firstBridge, String move) {
        if (move.equals("U")) {
            if (count != 0) {
                firstSb.append(" | ");
                firstSb.append(firstBridge.get(count));
            }
            if (count == 0) {
                firstSb.append(firstBridge.get(count));
            }
        }
    }

    private void firstBridgeMoveDown(StringBuilder firstSb, String move) {
        if (move.equals("D")) {
            if (count != 0) {
                firstSb.append(" | ");
                firstSb.append(" ");
            }
            if (count == 0) {
                firstSb.append(" ");
            }
        }
    }

    private void secondBridgeMoveUp(StringBuilder secondSb, String move) {
        if (move.equals("U")) {
            if (count != 0) {
                secondSb.append(" | ");
                secondSb.append(" ");
            }
            if (count == 0) {
                secondSb.append(" ");
            }
        }
    }

    private void secondBridgeMoveDown(StringBuilder secondSb, List<String> secondBridge, String move) {
        if (move.equals("D")) {
            if (count != 0) {
                secondSb.append(" | ");
                secondSb.append(secondBridge.get(count));
            }
            if (count == 0) {
                secondSb.append(secondBridge.get(count));
            }
        }
    }

    public void retry() {
        InputView inputView = new InputView();
        String command = inputView.readGameCommand();
        if (command.equals("R")) {
            count = 0;
            firstStorage.clear();
            secondStorage.clear();
            select = "R";
        }
        if (command.equals("Q")) {
            select = "Q";
        }
    }

    public int count(int i, int bridgeSize) {
        if (select.equals("R")) {
            return -1;
        }
        if (select.equals("Q")) {
            return bridgeSize - 1;
        }
        return i;
    }
}
