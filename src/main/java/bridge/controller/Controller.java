package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.GameRule;
import bridge.domain.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final Player player = new Player();

    public void generate() {
        outputView.printStart();
        BridgeGame bridgeGame = createBridgeGame();
        playBridgeGame(bridgeGame);
        outputView.printResult(bridgeGame);
    }

    public BridgeGame createBridgeGame() {
        int size = inputBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);

        return new BridgeGame(bridge, player);
    }

    private int inputBridgeSize() {
        try {
            return GameRule.getBridgeSize(inputView.readBridgeSize());

        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }

        return inputBridgeSize();
    }

    public void playBridgeGame(BridgeGame bridgeGame) {
        while (!bridgeGame.isCompletedOrStopped()) {
            moveByInput(bridgeGame);
            outputView.printMap(bridgeGame);

            decideToKeepPlaying(bridgeGame);
        }
    }

    public void moveByInput(BridgeGame bridgeGame) {
        String playerMoving = inputPlayerMoving();
        bridgeGame.move(playerMoving);
    }

    public String inputPlayerMoving() {
        try {
            return GameRule.getPlayerMoving(inputView.readMoving());

        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
        return inputPlayerMoving();
    }

    public void decideToKeepPlaying(BridgeGame bridgeGame) {
        if (player.isFailed()) { //이동결과 실패하면, 명령 받기
            String command = inputCommand();
            bridgeGame.executeCommand(command);
        }
    }

    public String inputCommand() {
        try {
            return GameRule.getCommand(inputView.readGameCommand());

        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
        return inputCommand();
    }

}
