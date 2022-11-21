package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private List<String> answerBridge ;
    private List<String> userBridge = new ArrayList<>();

    private GameResult gameResult = new GameResult();

    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void makeAnswerBridge(int size){
        this.answerBridge = bridgeMaker.makeBridge(size);
    }
    public void move(String moveChoice, int idx) {
        userBridge.add(moveChoice);
        setMoveResult(moveChoice, idx);
    }
    public void setMoveResult(String userChoice, int i) {
        if (checkIsWrong(i)) {
            setGameStatus(GameStatus.LOSE);
        }
        setResultBridge(MoveType.DOWN, userChoice, checkIsWrong(i));
        setResultBridge(MoveType.UP, userChoice, checkIsWrong(i));
    }
    public boolean checkIsWrong(int i) {
        return !getAnswerBridge().get(i).equals(getUserBridge().get(i));
    }

    public void setGameStatus(GameStatus gameStatus){
        gameResult.setGameStatus(gameStatus);
    }
    public void setResultBridge(MoveType type, String userChoice, boolean isWrong){
        if(type == MoveType.UP){
            gameResult.setUpBridge(userChoice, isWrong);
        }
        if(type == MoveType.DOWN){
            gameResult.setDownBridge(userChoice,isWrong);
        }
    }

    public void retry() {
    }

    public int getAnswerBridgeSize(){
        return answerBridge.size();
    }
    public List<String> getAnswerBridge() {
        return answerBridge;
    }
    public List<String> getUserBridge(){
        return userBridge;
    }
    public void setAnswerBridge(List<String> answerBridge) {
        this.answerBridge = answerBridge;
    }

}
