package bridge;

import java.text.MessageFormat;

public class Result {
    private static final char O_SIGN = 'O';
    private static final char X_SIGN = 'X';
    private static final char BLANK = ' ';
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private static final String FINAL_RESULT_FORM = "\n게임 성공 여부: {0}\n총 시도한 횟수: {1}";

    private final ResultInformation resultInformation;

    public Result(int size) {
        this.resultInformation = new ResultInformation(size);
    }

    public void handleUpBridge(int position, boolean isCorrect) {
        resultInformation.updateUpBridge(position, isCorrect ? O_SIGN : X_SIGN);
        resultInformation.updateDownBridge(position, BLANK);
    }

    public void handleDownBridge(int position, boolean isCorrect) {
        resultInformation.updateUpBridge(position, BLANK);
        resultInformation.updateDownBridge(position, isCorrect ? O_SIGN : X_SIGN);
    }

    public void clear() {
        resultInformation.clear();
    }

    public String printStatus(int position) {
        return resultInformation.makeMap(position);
    }

    @Override
    public String toString() {
        if (resultInformation.isPossibility()) {
            return MessageFormat.format(FINAL_RESULT_FORM, SUCCESS, resultInformation.getTryCount());
        }
        return MessageFormat.format(FINAL_RESULT_FORM, FAIL, resultInformation.getTryCount());
    }

}
