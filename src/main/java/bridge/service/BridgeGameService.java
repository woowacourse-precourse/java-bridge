package bridge.service;

import bridge.model.Bridge;
import bridge.model.GameScore;
import bridge.utils.BridgeMaker;
import bridge.utils.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameService {

    private final OutputView outputView;
    private final InputView inputView;
    private final BridgeMaker bridgeMaker;
    private final GameScore gameScore;

    public BridgeGameService() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.gameScore = new GameScore();
    }

    public Bridge getRandomBridge() {
        int size = getInputBridgeSize();
        return generateBridge(size);
    }

    public void gameStart(Bridge randomBridge) {
        BridgeGame bridgeGame = new BridgeGame(randomBridge);
        while (!bridgeGame.isGameOver()) {
            play(bridgeGame);
        }
        outputView.printResult(gameScore);
    }

    public void play(BridgeGame bridgeGame) {
        String move = getInputBridgeMove();
        if (!bridgeGame.check(move)) {
            String command = getInputGameRetry();
            bridgeGame.retry(command);
            return;
        }
        bridgeGame.move(move);
        gameScore.setGameScore(bridgeGame.isSuccess(), bridgeGame.getCount(), bridgeGame.getPlayerBridge().getBrdige());
        outputView.printMap(gameScore);
    }

    private int getInputBridgeSize() {
        outputView.printGameStart();
        outputView.printInputBridgeLine();
        return inputView.readBridgeSize();
    }

    private String getInputBridgeMove() {
        outputView.printInputBridgeMove();
        return inputView.readMoving();
    }

    private String getInputGameRetry() {
        outputView.printInputRetryGameStart();
        return inputView.readGameCommand();
    }

    private Bridge generateBridge(int size) {
        return Bridge.of(bridgeMaker.makeBridge(size));
    }
}
