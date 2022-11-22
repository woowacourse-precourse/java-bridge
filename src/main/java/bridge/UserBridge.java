package bridge;

import java.util.ArrayList;
import java.util.List;

public class UserBridge {
    private List<String> upBridge = new ArrayList<>();
    private List<String> downBridge = new ArrayList<>();

    public void markUpResult(String userPick, boolean result) {
        String marker = "X";
        if(result) marker = "O";

        if(userPick.equals("U")){
            upBridge.add(marker);
            downBridge.add(" ");
            return;
        }
        if (userPick.equals("D")) {
            downBridge.add(marker);
            upBridge.add(" ");
            return;
        }
    }

    @Override
    public String toString() {
        String upperString = "[";
        for (String s : upBridge) {
            upperString += " " + s + " |";
        }
        upperString = upperString.substring(0, upperString.length() - 1) + "]\n";

        String lowerString = "[";
        for (String s : downBridge) {
            lowerString += " " + s + " |";
        }
        lowerString = lowerString.substring(0, lowerString.length() - 1) + "]";

        return upperString + lowerString;
    }
}
