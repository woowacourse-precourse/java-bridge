package bridge;

import java.text.MessageFormat;

import static bridge.ResultConstants.*;

public class Result {

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


    public String toString() {
        if (resultInformation.isPossibility()) {
            return MessageFormat.format(FINAL_RESULT_FORM, SUCCESS, resultInformation.getTryCount());
        }
        return MessageFormat.format(FINAL_RESULT_FORM, FAIL, resultInformation.getTryCount());
    }

}
