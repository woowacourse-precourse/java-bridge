package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.GameStatus;
import bridge.model.GameVariable;
import bridge.model.bridge.Bridge;
import bridge.model.bridge.BridgeSign;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.Iterator;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final GameStatus gameStatus;

    public GameController(InputView inputView, OutputView outputView, GameStatus gameStatus) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameStatus = gameStatus;
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
            Iterator<BridgeSign> bridgeSignIterator = bridge.getBridgeIterator();
            while (bridgeSignIterator.hasNext()) {
                BridgeSign movingDirection = BridgeSign.from(inputView.readMoving());
                boolean isRoundSuccess = BridgeSign.isSame(bridgeSignIterator.next(), movingDirection);
            }

        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
        }
    }
}
