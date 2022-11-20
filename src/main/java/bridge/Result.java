package bridge;

import java.text.MessageFormat;

public class Result {
    private static final char O_SIGN = 'O';
    private static final char X_SIGN = 'X';
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";

    private final ResultInformation resultInformation;

    public Result(int size) {
        this.resultInformation = new ResultInformation(size);
    }

    void handleUpBridge(Key input, Position position) {
        if (Key.matchUp(input)) {
            resultInformation.updateUpBridge(position, O_SIGN);
            return;
        }
        resultInformation.updateUpBridge(position, X_SIGN);
        position.fail();
    }

    void handleDownBridge(Key input, Position position) {
        if (Key.matchDown(input)) {
            resultInformation.updateDownBridge(position, O_SIGN);
            return;
        }
        resultInformation.updateDownBridge(position, X_SIGN);
        position.fail();
    }

    void clear() {
        resultInformation.clear();
    }

    String printStatus(int tryCount) {
        return resultInformation.makeMap(tryCount);
    }

    @Override
    public String toString() {
        if (resultInformation.isPossibility()) {
            return MessageFormat.format("\n게임 성공 여부: {0}\n총 시도한 횟수: {1}", SUCCESS, resultInformation.getTryCount());
        }
        return MessageFormat.format("\n게임 성공 여부: {0}\n총 시도한 횟수: {1}", FAIL, resultInformation.getTryCount());
    }

}
