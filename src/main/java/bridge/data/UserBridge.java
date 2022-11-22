package bridge.data;

import java.util.ArrayList;
import java.util.List;

public class UserBridge {
    private List<String> upBridge = new ArrayList<>();
    private List<String> downBridge = new ArrayList<>();

    public void makeUpBridge(String userInput, boolean correct) {
       upBridge.add(compareInput(userInput, "U", correct));
    }

    public void makeDownBridge(String userInput, boolean correct) {
        downBridge.add(compareInput(userInput, "D", correct));
    }

    public List<String> getUpBridge() {
        return upBridge;
    }

    public List<String> getDownBridge() {
        return downBridge;
    }

    public void makeClearUpBridge() {
        upBridge.clear();
    }

    public void makeClearDownBridge() {
        downBridge.clear();
    }

    private String compareInput(String userInput, String standard, boolean correct) {
        if (standard.equals(userInput) && correct == true) {
            return "O";
        }
        if (standard.equals(userInput) && correct == false) {
            return "X";
        }
        return " ";
    }
}
