package bridge.controller;

import java.util.List;

public class Judgement {

    public static boolean judgeUserMovement(List<Boolean> compareResult) {
        if (compareResult.size() == 0) {
            return true;
        }
        return compareResult.get(compareResult.size() - 1);
    }
}
