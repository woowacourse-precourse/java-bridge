package bridge.controller;

import bridge.BridgeMaker;
import bridge.domain.bridge.Bridge;
import bridge.domain.operator.BridgeGame;
import bridge.domain.player.Player;
import bridge.utils.OutputMessage;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final OutputView outputView;
    private final InputView inputView;
    private final Player player;
    private final GameStatus gameStatus;
    private final BridgeGame bridgeGame;

    public BridgeGameController(BridgeMaker bridgeMaker) {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.player = new Player();
        this.gameStatus = new GameStatus();
        this.bridgeGame = new BridgeGame(new Bridge(bridgeMaker.makeBridge(inputBridgeSize())), player, gameStatus);
    }

    public void run() {
        while (gameStatus.isRunning()) {
            tryCross(player, bridgeGame);
            if (gameStatus.isSuccess()) {
                break;
            }
            checkRetry(gameStatus, bridgeGame);
        }
        outputView.printResult(bridgeGame.getBridgeResult(), gameStatus);
    }

    private int inputBridgeSize() {
        outputView.printMessage(OutputMessage.START);
        outputView.printMessage(OutputMessage.REQUEST_BRIDGE_SIZE);
        return inputView.readBridgeSize();
    }

    private void checkRetry(GameStatus gameStatus, BridgeGame bridgeGame) {
        outputView.printMessage(OutputMessage.REQUEST_GAME_COMMAND);
        if (inputView.readGameCommand().equals("R")) {
            bridgeGame.retry();
            return;
        }
        gameStatus.setRunning(false);
    }

    private void tryCross(Player player, BridgeGame bridgeGame) {
        while (player.isCross()) {
            outputView.printMessage(OutputMessage.REQUEST_MOVING);
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getBridgeResult());
            if (bridgeGame.isClear()) {
                return;
            }
        }
    }
}
