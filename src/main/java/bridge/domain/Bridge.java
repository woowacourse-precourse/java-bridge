package bridge.domain;

import bridge.Constants;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean validateMove(String userDirection, int index) {
        if (bridge.get(index).equals(userDirection)) {
            return true;
        }
        return false;
    }

    public String returnCertainIndexUpOrDown(int index) {
        return bridge.get(index);
    }


    public static String upperOrDown(int randomNum) { // 위인지 아래인지 고르는 메서드
        if (randomNum == 1) {
            return Constants.UserChoices.UP_UPPERSTRING;
        }
        return Constants.UserChoices.DOWN_UPPERSTRING;
    }
}
