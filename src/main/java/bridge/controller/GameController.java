package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.GameStatus;
import bridge.model.GameVariable;
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
            Iterator<BridgeDirection> bridgeSignIterator = bridge.getBridgeIterator();
            while (bridgeSignIterator.hasNext()) {
                BridgeDirection movingDirection = BridgeDirection.from(inputView.readMoving());
                boolean isRoundSuccess = BridgeDirection.isSame(bridgeSignIterator.next(), movingDirection);
            }

        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
        }
    }
}
