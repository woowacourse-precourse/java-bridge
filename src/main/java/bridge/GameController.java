package bridge;

import bridge.enums.BridgeMove;
import bridge.enums.GameCommand;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {

    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame game;

    public GameController() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void initGame() {
        outputView.printGameStart();
        while(true) {
            try {
                List<String> bridges = bridgeMaker.makeBridge(inputView.readBridgeSize());
                this.game = new BridgeGame(bridges);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void run() {
        playGameOnce();
        while ((!game.isCleared()) && (isWantRestart())) {
            game.retry();
            playGameOnce();
        }
        outputView.printResult(game);
    }

    private void playGameOnce() {
        while (!game.isCleared()) {
            boolean isMoveSuccess = game.move(readMove());
            outputView.printMap(game.getGameBridges());
            if (!isMoveSuccess) {
                return;
            }
        }
    }

    private BridgeMove readMove() {
        while(true) {
            try {
                return inputView.readMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean isWantRestart() {
        while(true) {
            try {
                GameCommand gameCommand = inputView.readGameCommand();
                return gameCommand.isGameRestart();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
