package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private static final String LINE = " | ";
    private final BridgeGame bridgeGame;

    public GameResult(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public String getTopResult() {
        String result = "";
        for (String top : bridgeGame.getTop()) {
            result += top + LINE;
        }
        result = removeLastLine(result);
        return result;
    }

    public String getBottomResult() {
        String result = "";
        for (String bottom : bridgeGame.getBottom()) {
            result += bottom + LINE;
        }
        result = removeLastLine(result);
        return result;
    }

    public int totalPlayCount() {
        return bridgeGame.getPlayCount();
    }

    public String successOrFailure() {
        if (!bridgeGame.isClear()) {
            return FAIL;
        }
        return SUCCESS;
    }

    public String removeLastLine(String result) {
        return result.substring(0, result.length() - 3);
    }
}
