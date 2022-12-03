package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.model.GameStatus;
import bridge.model.GameVariable;
import bridge.model.RoundStatus;
import bridge.model.bridge.Bridge;
import bridge.model.bridge.BridgeDirection;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.Iterator;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private GameStatus gameStatus;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameStatus = GameStatus.SETTING_GAME;
    }

    public void play() {
        try {
            // SETTING_GAME
            outputView.printStartGame();

            // CREATING_BRIDGE
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            Bridge bridge = Bridge.from(bridgeMaker.makeBridge(inputView.readBridgeSize()));

            // INITIALIZING_GAME_VARIABLE
            GameVariable gameVariable = GameVariable.byInitialValue();

            // START_GAME
            BridgeGame bridgeGame = new BridgeGame(gameVariable);

            Iterator<BridgeDirection> bridgeSignIterator = bridge.getBridgeIterator();
            while (gameStatus.isContinueGame()) {
                RoundStatus roundStatus = bridgeGame.move(bridgeSignIterator.next(), BridgeDirection.from(inputView.readMoving()));
                updateGameStatus(roundStatus);
                outputView.printMap(gameVariable.getMaps());
            }

        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
        }
    }

    private void updateGameStatus(RoundStatus roundStatus) {
        gameStatus = GameStatus.findGameStatus(roundStatus);
    }

}
