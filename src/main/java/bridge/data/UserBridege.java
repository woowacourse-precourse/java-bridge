package bridge.data;

import java.util.ArrayList;
import java.util.List;

public class UserBridege {
    private List<String> upBridge = new ArrayList<>();
    private List<String> downBridge = new ArrayList<>();

    public void makeUpBridge(String userInput, boolean correct) {
       
    }

    private String compareInput(String upserInput, String standard, boolean correct) {
        if (standard.equals(upserInput) && correct == true) {
            return "O";
        }
        if (standard.equals(upserInput) && correct == false) {
            return "X";
        }
        return " ";
    }
}
