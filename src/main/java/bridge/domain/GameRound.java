package bridge.domain;

import bridge.service.validator.BridgeMove;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameRound {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMove bridgeMove;

    private final Bridge bridge;
    private int nth = 0; // n번째 칸

    public GameRound(InputView inputView, OutputView outputView, Bridge bridge) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMove = new BridgeMove(inputView);
        this.bridge = bridge;
    }

    public boolean winRound() {
        this.nth++;
        boolean isWin = isWin(bridgeMove.inputMoveBridge());
        outputView.printMap(bridge.myBridge(this.nth, isWin));

        return isWin;
    }

    public void end(boolean isWin, int tryCount) {
        String message = "실패";
        if (isWin) message = "성공";

        outputView.printResult(bridge.myBridge(this.nth, isWin), message, tryCount);
    }

    public boolean isWin(String move) {
        return bridge.isCorrect(nth, move.charAt(0));
    }

    public boolean isContinueRound() {
        if (bridge.getBridgeSize() == nth)
            return false;

        return true;
    }
}
