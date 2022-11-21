package bridge.model;

import bridge.controller.GameController;

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

    public void resetHole(){
        upSideBridgeResult = new ArrayList<>();
        downSideBridgeResult = new ArrayList<>();
        progressCount = 0;
        succeed = true;
    }

    private void isBridgeAnswerMatch(List<String> bridge, String choice, int index) {
        if (choice.equals("U") && bridge.get(index).equals(choice)) {
            addAnswer("O", " ");
            succeed = true;
            return;
        }

        if (choice.equals("D") && bridge.get(index).equals(choice)) {
            addAnswer(" ", "O");
            succeed = true;
        }
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
        return GameController.BRIDGE_LENGTH == progressCount;
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
