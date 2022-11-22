package bridge.Service;

import bridge.Domain.BridgeGame;
import bridge.Utils.GameStatus;
import bridge.View.InputView;
import bridge.View.OutputView;

public class BridgeGameService {

    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;

    public BridgeGameService() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
    }

    public void intialSetting() {
        outputView.printGameStart();
        bridgeGame.setRound(bridgeGame.getRound() + 1);
    }

    public void makeBridge() {
        int bridgeSize = getBridgeLength();
        bridgeGame.makeAnswerBridge(bridgeSize);
    }

    public int getBridgeLength() {
        return inputView.readBridgeSize();
    }

    public GameStatus getGameStatus() {
        return bridgeGame.getGameStatus();
    }

    public GameStatus moveBridge() {
        for (int i = 0; i < bridgeGame.getAnswerBridgeSize(); i++) {
            bridgeGame.move(getMoving());
            bridgeGame.setMoveResult(i);
            showMoveResultMap();
            if (bridgeGame.getGameStatus() == GameStatus.LOSE) return bridgeGame.getGameStatus();
        }
        bridgeGame.setGameStatus(GameStatus.SUCCESS);
        return bridgeGame.getGameStatus();
    }

    public String getMoving() {
        return inputView.readMoving();
    }

    public void showMoveResultMap() {
        outputView.printMap(bridgeGame.getGameResult());
    }

    public void askReplay() {
        if (!checkIfQuit(inputView.readGameCommand())) {
            bridgeGame.retry();
        }
    }

    public boolean checkIfQuit(String input) {
        if (input.equals("R")) {
            return false;
        }
        bridgeGame.setGameStatus(GameStatus.LOSE);
        return true;
    }

    public void showFinalResult() {
        outputView.printResult(bridgeGame.getGameResult(), bridgeGame.getRound());
    }
}
