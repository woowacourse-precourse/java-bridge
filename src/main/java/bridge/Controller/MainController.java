package bridge.Controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.Enum.CrossResult;
import bridge.Enum.GameStatus;
import bridge.Model.BridgeGame;
import bridge.Model.WrappingType.*;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private BridgeGame bridgeGame;

    public void initGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        BridgeSize bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize.getSize());
        List<ChoiceDirection> choiceDirections = new ArrayList<>();
        List<CrossResult> crossResults = new ArrayList<>();
        bridgeGame = new BridgeGame(bridge, choiceDirections, crossResults);
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
