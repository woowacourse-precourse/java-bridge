package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.Player;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController extends AbstractGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private BridgeGame bridgeGame;

    @Override
    public void startGame() {
        Player player = new Player();
        outputView.printStartGame();

        Bridge bridge = new Bridge(makeBridge());
        outputView.printNewline();

        bridgeGame = new BridgeGame(player, bridge);
    }

    private List<String> makeBridge() {
        outputView.printPleaseInputBridgeLength();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return (bridgeMaker.makeBridge(inputView.readBridgeSize()));
    }

    @Override
    public void playGame() {
        do {
            bridgeGame.initPlayer();
            if (movePlayer()) {
                return;
            }
            outputView.printPleaseInputRetry();
        } while (bridgeGame.retry(inputView.readGameCommand()));
    }

    private boolean movePlayer() {
        while (!bridgeGame.isClearGame()) {
            outputView.printChoiceMove();
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getPlayer());
            if (!bridgeGame.isPlayerMove()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void endGame() {
        outputView.printResult(bridgeGame.getPlayer());
    }
}
