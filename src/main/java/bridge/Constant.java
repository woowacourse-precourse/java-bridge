package bridge;

public class Constant {
    public static final int minBridgeLength = 3;
    public static final int maxBridgeLength = 20;

    public static final String retryCommand = "R";
    public static final String quitCommand = "Q";

    public static final String startRangeOutput = "[";
    public static final String endRangeOutput = "]";
    public static final String correctLineOutput = " O |";
    public static final String incorrectLineOutput = " X |";
    public static final String notChosenLineOutput = "   |";

    public static final String finalResultOutput = "최종 게임 결과";
    public static final String gameSuccessOutput = "게임 성공 여부: ";
    public static final String totalAttemptOutput = "총 시도한 횟수: ";
}
