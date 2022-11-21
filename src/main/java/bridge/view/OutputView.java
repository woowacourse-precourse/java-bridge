package bridge.view;

import bridge.domain.GameResult;

public class OutputView {
    private static final String FINAL_RESULT_MESSAGE = "최종 게임 결과";
    private static final String SUCCESS_OR_FAILURE = System.lineSeparator() + "게임 성공 여부: ";
    private static final String TOTAL_PLAY_COUNT = "총 시도한 횟수: ";
    private static final String START_SUFFIX = "[ ";
    private static final String END_SUFFIX = " ]";

    public void printMap(GameResult gameResult) {
        System.out.println(START_SUFFIX + gameResult.getTopResult() + END_SUFFIX);
        System.out.println(START_SUFFIX + gameResult.getBottomResult() + END_SUFFIX + System.lineSeparator());
    }

    public void printResult(GameResult gameResult) {
        System.out.println(FINAL_RESULT_MESSAGE);
        System.out.println(START_SUFFIX + gameResult.getTopResult() + END_SUFFIX);
        System.out.println(START_SUFFIX + gameResult.getBottomResult() + END_SUFFIX);
        System.out.println(SUCCESS_OR_FAILURE + gameResult.successOrFailure());
        System.out.println(TOTAL_PLAY_COUNT + gameResult.totalPlayCount());
    }
}
