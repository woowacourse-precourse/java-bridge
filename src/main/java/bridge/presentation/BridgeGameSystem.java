package bridge.presentation;

import bridge.BridgeMaker;
import bridge.application.BridgeGame;
import bridge.domain.Bridge;
import bridge.domain.GameCommand;
import bridge.domain.GameStatus;
import bridge.domain.Moving;
import bridge.domain.Result;
import bridge.presentation.view.InputView;
import bridge.presentation.view.OutputView;

public class BridgeGameSystem {

    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeGameSystem(BridgeMaker bridgeMaker, InputView inputView, OutputView outputView) {
        this.bridgeMaker = bridgeMaker;
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = initBridgeGame();
    }

    public void play() {
        Moving moving;
                GameStatus gameStatus;
        do {
            moving = move();
            gameStatus = getGameStatus(moving);
        } while (gameStatus.equals(GameStatus.NEXT) || gameStatus.equals(GameStatus.RETRY));
    }

    private Moving move() {
        Moving moving = bridgeGame.move(inputView.readMoving());
        outputView.printMap(moving);
        return moving;
    }

    private GameStatus getGameStatus(Moving moving) {
        if (moving.getResult() == Result.FAIL) {
            GameCommand gameCommand = inputView.readGameCommand();
            return bridgeGame.getGameStatusByGameCommand(gameCommand);
        }
        return GameStatus.NEXT;
    }

    private BridgeGame initBridgeGame() {
        outputView.printGameStart();
        int bridgeSize = inputView.readBridgeSize();
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        return new BridgeGame(bridge);
    }

}
