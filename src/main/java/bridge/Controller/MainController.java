package bridge.Controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.Enum.GameStatus;
import bridge.Model.BridgeGame;
import bridge.Model.WrappingType.BridgeSize;
import bridge.Model.WrappingType.ChoiceDirection;
import bridge.Model.WrappingType.Command;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;

public class MainController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private BridgeGame bridgeGame;

    public void initGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        BridgeSize bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize.getSize());
        bridgeGame = new BridgeGame(bridge);
    }

    public void run() {
        GameStatus gameStatus = GameStatus.RUNNING;
        while (gameStatus.equals(GameStatus.RUNNING)) {
            ChoiceDirection choice = inputView.readMoving();
            bridgeGame.move(choice);
            gameStatus = bridgeGame.checkGameStatus();
            outputView.printMap(bridgeGame);
            gameStatus = checkKeepRunning(gameStatus);
        }
        outputView.printResult(bridgeGame, gameStatus);
    }

    private GameStatus checkKeepRunning(GameStatus gameStatus) {
        if (gameStatus.equals(GameStatus.FAIL)) {
            Command command = inputView.readGameCommand();
            if (command.isQuit()) {
                //pass
            } else if (command.isRetry()) {
                bridgeGame.retry();
                gameStatus = GameStatus.RUNNING;
            }
        }
        return gameStatus;
    }
}
