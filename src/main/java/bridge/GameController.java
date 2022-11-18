package bridge;

import bridge.enums.GameCommand;
import bridge.view.InputView;
import java.util.List;

public class GameController {

    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private BridgeGame game;

    public GameController() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.inputView = new InputView();
    }

    public void initGame() {
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridges = bridgeMaker.makeBridge(bridgeSize);
        this.game = new BridgeGame(bridges);
    }

    public void run() {
        game.play();
        while ((!game.isCleared()) && (isWantRestart())) {
            game.retry();
        }
    }

    private boolean isWantRestart() {
        GameCommand gameCommand = inputView.readGameCommand();
        return gameCommand.isGameRestart();
    }
}
