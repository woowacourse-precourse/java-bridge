package bridge;

public class BridgeOutput{

    public void printMap(Bridge bridgeState, boolean isRight) {
        OutputView.printMap(bridgeState, isRight);
    }
    public void printResult(Bridge bridgeState, int retCnt, String res) {
        OutputView.printResult(bridgeState, retCnt, res);
    }
}
