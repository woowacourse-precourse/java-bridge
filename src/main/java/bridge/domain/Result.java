package bridge.domain;

import bridge.utils.enums.GameResult;

public class Result {

    public String result(boolean isAnswer) {
        if (isAnswer) {
            return GameResult.SUCCESS.getValue();
        }
        return GameResult.FAIL.getValue();
    }
}
