package bridge;

import enumCollections.GameStatus;
import enumCollections.GuideMessage;

public class Controller {
    private final OutputView outputView;
    private final InputView  inputView;

    public Controller(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void startGame(final BridgeGame bridgeGame) {
        bridgeGame.generateBridge(getBridgeSize());
        play(bridgeGame, GameStatus.CONTINUE);
    }

    public GameStatus play(final BridgeGame bridgeGame, GameStatus gameStatus) {
        Map map = new Map();
        while (gameStatus == GameStatus.CONTINUE) {
            movePlayer(bridgeGame);
            map.add(bridgeGame.getCurrentAvailableSide(), bridgeGame.isPlayerInRightSide());
            gameStatus = getGameStatus(bridgeGame, bridgeGame.isPlayerInRightSide());
        }
        getResult(gameStatus, bridgeGame, map);
        return gameStatus;
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

    private int getBridgeSize() {
        new OutputView().printGuideMessage(GuideMessage.START);
        return this.inputView.readBridgeSize();
    }

    private void getResult(GameStatus gameResult, BridgeGame bridgeGame, Map map) {
        outputView.printGuideMessage(GuideMessage.RESULT_PRINT);
        outputView.printGuideMessage(GuideMessage.GAME_RESULT, GameStatus.get(gameResult));
        outputView.printMap(map);
        outputView.printNewline();
        outputView.printResult(gameResult);
        outputView.printGuideMessage(GuideMessage.GAME_TRIAL, bridgeGame.getTrial());
    }
}
