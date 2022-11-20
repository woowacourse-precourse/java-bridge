package bridge.model;

import bridge.controller.BridgeGame;

import java.util.ArrayList;
import java.util.List;

public class Referee {

    public static boolean succeed = true;
    private List<String> upSideBridgeResult = new ArrayList<>();
    private List<String> downSideBridgeResult = new ArrayList<>();
    private int progressCount = 0;

    public void addPlayerChoiceResult(List<String> bridge, String choice, int index) {
        isBridgeAnswerMatch(bridge, choice, index);
        isBridgeNotMatch(bridge, choice, index);
    }

    private boolean isBridgeAnswerMatch(List<String> bridge, String choice, int index) {
        if (choice.equals("U") && bridge.get(index).equals(choice)) {
            addAnswer("O", " ");
            succeed = true;
            return true;
        }

        if (choice.equals("D") && bridge.get(index).equals(choice)) {
            addAnswer(" ", "O");
            succeed = true;
            return true;
        }
        return false;
    }

    private boolean isBridgeNotMatch(List<String> bridge, String choice, int index) {
        if (choice.equals("U") && !bridge.get(index).equals(choice)) {
            addAnswer("X", " ");
            succeed = false;
            return false;
        }

        if (choice.equals("D") && !bridge.get(index).equals(choice)) {
            addAnswer(" ", "X");
            succeed = false;
            return false;
        }
        return true;
    }

    private void addAnswer(String first, String second) {
        upSideBridgeResult.add(first);
        downSideBridgeResult.add(second);
    }

    public boolean isClear() {
        return BridgeGame.BRIDGE_LENGTH == progressCount;
    }

    public List<String> getUpSideBridgeResult() {
        return upSideBridgeResult;
    }

    public List<String> getDownSideBridgeResult() {
        return downSideBridgeResult;
    }

    public int getProgressCount() {
        return progressCount;
    }

    public void addProgressCount() {
        progressCount++;
    }
}
