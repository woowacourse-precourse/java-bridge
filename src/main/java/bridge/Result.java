package bridge;

public class Result {
    private static final char O_SIGN = 'O';
    private static final char X_SIGN = 'X';

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

}
