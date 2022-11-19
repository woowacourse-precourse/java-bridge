package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    private List<String> upSideBridgeResult = new ArrayList<>();
    private List<String> downSideBridgeResult = new ArrayList<>();

    public void addPlayerChoiceResult(List<String> bridge, String choice, int index){
        isBridgeAnswerMatch(bridge, choice, index);
        isBridgeNotMatch(bridge, choice, index);
    }

    private boolean isBridgeAnswerMatch(List<String> bridge, String choice, int index) {
        if (choice.equals("U") && bridge.get(index).equals(choice)){
            addAnswer("O", " ");
            return true;
        }

        if (choice.equals("D") && bridge.get(index).equals(choice)){
            addAnswer(" ", "O");
            return true;
        }
        return false;
    }

    private  boolean isBridgeNotMatch(List<String> bridge, String choice, int index) {
        if (choice.equals("U") && !bridge.get(index).equals(choice)){
            addAnswer("X", " ");
            return false;
        }

        if (choice.equals("D") && !bridge.get(index).equals(choice)){
            addAnswer(" ", "X");
            return false;
        }
        return true;
    }



    private void addAnswer(String first, String second) {
        upSideBridgeResult.add(first);
        downSideBridgeResult.add(second);
    }

    public List<String> getUpSideBridgeResult() {
        return upSideBridgeResult;
    }

    public List<String> getDownSideBridgeResult() {
        return downSideBridgeResult;
    }
}
