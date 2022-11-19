package bridge;

import enumCollections.GameStatus;
import enumCollections.GuideMessage;

public class Controller {
    OutputView outputView;
    InputView  inputView;

    public Controller(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void startGame(BridgeGame bridgeGame) {
        bridgeGame.generateBridge(getBridgeSize());
        play(bridgeGame, GameStatus.CONTINUE);
    }

    private int getBridgeSize() {
        new OutputView().printGuideMessage(GuideMessage.START);
        return this.inputView.readBridgeSize();
    }

    private GameStatus play(BridgeGame bridgeGame, GameStatus gameStatus) {
        while (gameStatus == GameStatus.CONTINUE) {
            gameStatus = bridgeGame.tryMoveTo(getMoving());
        }
    }

    private String getMoving() {
        outputView.printGuideMessage(GuideMessage.GET_MOVING);
        return inputView.readMoving();
    }
}
