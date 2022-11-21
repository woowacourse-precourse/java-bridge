package bridge;

import enumCollections.GameStatus;
import enumCollections.GuideMessage;
import enumCollections.Side;

public class Controller {
    private final OutputView outputView;
    private final InputView  inputView;

    public Controller(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void startGame(final BridgeGame bridgeGame) {
        outputView.printGuideMessage(GuideMessage.START);
        generateBridge(bridgeGame);
        play(bridgeGame, GameStatus.CONTINUE);
    }

    private void generateBridge(final BridgeGame bridgeGame) {
        outputView.printGuideMessage(GuideMessage.GET_BRIDGE_LENGTH);
        bridgeGame.generateBridge(this.inputView.readBridgeSize());
    }

    public GameStatus play(final BridgeGame bridgeGame, GameStatus gameStatus) {
        Map map = new Map();
        while (gameStatus == GameStatus.CONTINUE) {
            movePlayer(bridgeGame);
            getProgress(bridgeGame);
            gameStatus = getGameStatus(bridgeGame, bridgeGame.isPlayerInRightSide());
        }
        getResult(gameStatus, bridgeGame, bridgeGame.getMap());
        return gameStatus;
    }

    private void getProgress(BridgeGame bridgeGame) {
        bridgeGame.updateMap();
        outputView.printMap(bridgeGame.getMap());
    }

    private void movePlayer(final BridgeGame bridgeGame) {
        outputView.printGuideMessage(GuideMessage.GET_MOVING);
        bridgeGame.move(inputView.readMoving());
    }

    private GameStatus getGameStatus(final BridgeGame bridgeGame, boolean moved) {
        if (!moved) {
            return askRestartGame(bridgeGame);
        }
        return bridgeGame.isSuccess();
    }

    private GameStatus askRestartGame(final BridgeGame bridgeGame) {
        outputView.printAskGameCommand();
        return bridgeGame.retry(inputView.readGameCommand());
    }

    private void getResult(GameStatus gameResult, BridgeGame bridgeGame, Map map) {
        outputView.printGuideMessage(GuideMessage.RESULT_PRINT);
        outputView.printMap(map);
        outputView.printNewline();
        outputView.printResult(gameResult);
        outputView.printGuideMessage(GuideMessage.GAME_TRIAL, bridgeGame.getTrial());
    }
}
