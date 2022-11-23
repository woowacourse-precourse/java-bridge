package bridge.domain;

public class ResultGenerator {

    private ResultGenerator(){}

    public static final String IS_SUCCESS = "게임 성공 여부: ";
    public static final String SUCCESS = "성공";
    public static final String FAIL = "실패";
    public static final String TRIAL = "총 시도한 횟수: ";
    public static final String NEWLINE = "\n";

    private static String isSuccess(boolean isEnd) {
        if (isEnd) {
            return SUCCESS;
        }
        return FAIL;
    }

    public static String generateResult(boolean isEnd, int trial) {
        return IS_SUCCESS + isSuccess(isEnd) + NEWLINE + TRIAL + trial;
    }
}
