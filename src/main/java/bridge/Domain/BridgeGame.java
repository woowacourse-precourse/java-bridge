package bridge.Domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.Utils.GameStatus;
import bridge.Utils.MoveType;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private List<String> answerBridge;
    private List<String> userBridge = new ArrayList<>();

    private GameResult gameResult = new GameResult();

    private int round = 0;

    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void makeAnswerBridge(int size) {
        this.answerBridge = bridgeMaker.makeBridge(size);
    }

    public void move(String moveChoice) {
        userBridge.add(moveChoice);
    }

    public void setMoveResult(int i) {
        if (checkIsWrong(i)) {
            setGameStatus(GameStatus.LOSE);
        }
        setResultBridge(MoveType.DOWN, getUserBridge().get(i), checkIsWrong(i));
        setResultBridge(MoveType.UP, getUserBridge().get(i), checkIsWrong(i));
    }

    public boolean checkIsWrong(int i) {
        return !getAnswerBridge().get(i).equals(getUserBridge().get(i));
    }

    public void setGameStatus(GameStatus gameStatus) {
        gameResult.setGameStatus(gameStatus);
    }

    public void setResultBridge(MoveType type, String userChoice, boolean isWrong) {
        if (type == MoveType.UP) {
            gameResult.setUpBridge(userChoice, isWrong);
        }
        if (type == MoveType.DOWN) {
            gameResult.setDownBridge(userChoice, isWrong);
        }
    }

    public void retry() {
        clearGameInfo();
        setRound(getRound() + 1);
    }

    public void clearGameInfo() {
        this.userBridge = new ArrayList<>();
        this.gameResult = new GameResult();
        this.gameResult.setGameStatus(GameStatus.PROGRESS);
    }

    public int getAnswerBridgeSize() {
        return answerBridge.size();
    }

    public List<String> getAnswerBridge() {
        return answerBridge;
    }

    public List<String> getUserBridge() {
        return userBridge;
    }

    public GameResult getGameResult() {
        return gameResult;
    }


    public GameStatus getGameStatus() {
        return gameResult.getGameStatus();
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void setAnswerBridge(List<String> answerBridge) {
        this.answerBridge = answerBridge;
    }

}
