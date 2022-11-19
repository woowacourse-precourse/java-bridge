package bridge.domain;

import bridge.enums.Key;
import bridge.enums.ViewMessage;

import java.text.MessageFormat;

public class Result {
    private static final char O_FLAG = 'O';
    private static final char X_FLAG = 'X';
    private static final String WIN = "성공";
    private static final String FAIL = "실패";

    private final ResultInformation resultInformation;

    public Result(int size) {
        this.resultInformation = new ResultInformation(size);
    }

    void handleUpBridge(Key input, Position position) {
        if (Key.matchUp(input)) {
            resultInformation.updateUpBridge(position, O_FLAG);
            return;
        }
        resultInformation.updateUpBridge(position, X_FLAG);
        position.fail();
    }

    void handleDownBridge(Key input, Position position) {
        if (Key.matchDown(input)) {
            resultInformation.updateDownBridge(position, O_FLAG);
            return;
        }
        resultInformation.updateDownBridge(position, X_FLAG);
        position.fail();
    }

    void clear() {
        resultInformation.clear();
    }

    String printStatus(int tryCount) {
        return resultInformation.toString(tryCount);
    }

    @Override
    public String toString() {
        if (resultInformation.isWin()) {
            return MessageFormat.format(ViewMessage.OUTPUT_PRINT_FINAL_RESULT.getValue(), WIN, resultInformation.getTryCount());
        }
        return MessageFormat.format(ViewMessage.OUTPUT_PRINT_FINAL_RESULT.getValue(), FAIL, resultInformation.getTryCount());
    }
}
