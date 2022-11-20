package bridge.Controller;

import bridge.Enum.GameStatus;
import bridge.Model.BridgeGame;
import bridge.Model.WrappingType.BridgeSize;
import bridge.Model.WrappingType.ChoiceDirection;
import bridge.Model.WrappingType.Command;
import bridge.View.InputView;
import bridge.View.OutputView;

public class MainController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BridgeGame bridgeGame;

    public void initGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        BridgeSize bridgeSize = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);
    }

    public void run() {
        GameStatus gameStatus = GameStatus.RUNNING;
        while (gameStatus.equals(GameStatus.RUNNING)) {
            ChoiceDirection choice = inputView.readMoving();
            bridgeGame.move(choice);
            gameStatus = bridgeGame.checkGameStatus();
            outputView.printMap(bridgeGame.getChoiceDirections(), bridgeGame.getCrossResults());
            gameStatus = checkKeepRunning(gameStatus);
        }
        outputView.printResult(bridgeGame.getChoiceDirections(), bridgeGame.getCrossResults(), gameStatus, bridgeGame.getTryCount());
    }

    private GameStatus checkKeepRunning(GameStatus gameStatus) {
        if (gameStatus.equals(GameStatus.FAIL)) {
            Command userCommand = inputView.readGameCommand();
            if (userCommand.isQuit()) {
                //pass
            } else if (userCommand.isRetry()) {
                bridgeGame.retry();
                gameStatus = GameStatus.RUNNING;
            }
        }
        return gameStatus;
    }
}
