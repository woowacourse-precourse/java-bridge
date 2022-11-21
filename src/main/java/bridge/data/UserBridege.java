package bridge.data;

import java.util.ArrayList;
import java.util.List;

public class UserBridege {
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
