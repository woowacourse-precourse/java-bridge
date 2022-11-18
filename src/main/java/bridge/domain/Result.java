package bridge.domain;

import bridge.enums.InputKey;
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

    public void handleUpBridge(String input, Position position) {
        if (InputKey.isUp(input)) {
            resultInformation.updateUpBridge(position, O_FLAG);
            return;
        }
        resultInformation.updateUpBridge(position, X_FLAG);
        position.fail();
    }

    public void handleDownBridge(String input, Position position) {
        if (InputKey.isDown(input)) {
            resultInformation.updateDownBridge(position, O_FLAG);
            return;
        }
        resultInformation.updateDownBridge(position, X_FLAG);
        position.fail();
    }

    public void clear() {
        resultInformation.clear();
    }

    public String printStatus(int tryCount) {
        return resultInformation.toString(tryCount);
    }

    @Override
    public String toString() {
        boolean flag = resultInformation.isWin();
        if (flag) {
            return MessageFormat.format(ViewMessage.OUTPUT_PRINT_FINAL_RESULT.getValue(), WIN, resultInformation.getTryCount());
        }
        return MessageFormat.format(ViewMessage.OUTPUT_PRINT_FINAL_RESULT.getValue(), FAIL, resultInformation.getTryCount());
    }
}
