package bridge;

import enumCollections.AvailableInput;
import enumCollections.GameStatus;
import enumCollections.GuideMessage;
import enumCollections.Side;

public class Controller {
    OutputView outputView;
    InputView  inputView;

    public Controller(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void startGame(BridgeGame bridgeGame) {
        bridgeGame.generateBridge(getBridgeSize());
        play(bridgeGame, GameStatus.CONTINUE);
    }

    private int getBridgeSize() {
        new OutputView().printGuideMessage(GuideMessage.START);
        return this.inputView.readBridgeSize();
    }

    public GameStatus play(BridgeGame bridgeGame, GameStatus gameStatus) {
        Map map = new Map();
        while (gameStatus == GameStatus.CONTINUE) {
            boolean moved = movePlayer(bridgeGame);
            map.add(bridgeGame.getCurrentAvailableSide(), moved);
            gameStatus = getGameStatus(bridgeGame, moved);
        }
        getResult(gameStatus, bridgeGame, map);
        return gameStatus;
    }

    private boolean movePlayer(BridgeGame bridgeGame) {
        outputView.printGuideMessage(GuideMessage.GET_MOVING);
        return bridgeGame.move(inputView.readMoving());
    }

    private GameStatus getGameStatus(BridgeGame bridgeGame, boolean moved) {
        if (!moved) {
            return askRestartGame(bridgeGame);
        }
        return bridgeGame.getGameStatus();
    }

    private GameStatus askRestartGame(BridgeGame bridgeGame) {
        outputView.printAskGameCommand();
        return bridgeGame.retry(inputView.readGameCommand());
    }

    private void getResult(GameStatus gameResult, BridgeGame bridgeGame, Map map) {
        outputView.printGuideMessage(GuideMessage.RESULT_PRINT);
        outputView.printGuideMessage(GuideMessage.GAME_RESULT, GameStatus.get(gameResult));
        outputView.printMap(map);
        outputView.printNewline();
        outputView.printResult(gameResult);
        outputView.printGuideMessage(GuideMessage.GAME_TRIAL, bridgeGame.getTrial());
    }

    private void addMap(Map map, Side availableSide, GameStatus gameStatus) {
        map.add(availableSide, false);
        outputView.printMap(map);
    }
}
