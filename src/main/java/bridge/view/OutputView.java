package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.GameResult;
import bridge.domain.MoveResult;

public class OutputView {
    private static final String FINAL_RESULT_MESSAGE = "최종 게임 결과";
    private static final String SUCCESS_OR_FAILURE = System.lineSeparator() + "게임 성공 여부: ";
    private static final String TOTAL_PLAY_COUNT = "총 시도한 횟수: ";
    private static final String START_SUFFIX = "[ ";
    private static final String END_SUFFIX = " ]";
    private static final String LINE = " | ";

    public void printMap(BridgeGame bridgeGame) {
        System.out.println(START_SUFFIX + getTopResult(bridgeGame) + END_SUFFIX);
        System.out.println(START_SUFFIX + getBottomResult(bridgeGame) + END_SUFFIX);
    }

    public void printResult(BridgeGame bridgeGame) {
        System.out.println(FINAL_RESULT_MESSAGE);
        System.out.println(START_SUFFIX + getTopResult(bridgeGame) + END_SUFFIX);
        System.out.println(START_SUFFIX + getBottomResult(bridgeGame) + END_SUFFIX);
        System.out.println(SUCCESS_OR_FAILURE + successOrFailure(bridgeGame));
        System.out.println(TOTAL_PLAY_COUNT + bridgeGame.getPlayCount());
    }

    public String getTopResult(BridgeGame bridgeGame) {
        String result = "";
        for (MoveResult top : bridgeGame.getTop()) {
            result += top.getValue() + LINE;
        }
        result = removeLastLine(result);
        return result;
    }

    public String getBottomResult(BridgeGame bridgeGame) {
        String result = "";
        for (MoveResult bottom : bridgeGame.getBottom()) {
            result += bottom.getValue() + LINE;
        }
        result = removeLastLine(result);
        return result;
    }

    public String removeLastLine(String result) {
        return result.substring(0, result.length() - 3);
    }

    public String successOrFailure(BridgeGame bridgeGame) {
        GameResult result = bridgeGame.isClear();
        return result.getValue();
    }
}
