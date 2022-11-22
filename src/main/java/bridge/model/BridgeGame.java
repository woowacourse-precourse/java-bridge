package bridge.model;

import bridge.constant.GameStatus;
import bridge.validator.ValueValidator;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private ValueValidator validator = new ValueValidator();
    private Bridge bridge;
    private int round = 0;
    private int tryCount = 0;
    private GameStatus gameStatus = GameStatus.READY;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        round++;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        initializeRound();
        initializeGameStatus();
    }

    public void updateTryCount(){
        tryCount++;
    }

    private void initializeRound(){
        round = 0;
    }

    private void initializeGameStatus(){
        gameStatus = GameStatus.READY;
    }
    
    public void createBridge(int size){
        validator.validateNumberRange(size);
        bridge = new Bridge(size);
    }

    public void checkAnswerOfRound(String answer){
        validator.validateUpOrDown(answer);
        if(!bridge.checkBlock(answer, round)){
            gameStatus = GameStatus.FAIL;
            return;
        }
        gameStatus = GameStatus.IN_PROGRESS;
    }

    public void checkGameSuccess(){
        if(round == bridge.getSize()){
            gameStatus = GameStatus.SUCCESS;
            round--;
        }
    }

    public boolean isGameFail(){
        if(gameStatus == GameStatus.FAIL){
            return true;
        }
        return false;
    }

    public boolean isGameSuccess(){
        if(gameStatus == GameStatus.SUCCESS){
            return true;
        }
        return false;
    }

    public int getTryCount(){
        return tryCount;
    }

    public GameStatus getGameStatus(){
        return gameStatus;
    }

    public Bridge getBridge(){
        return bridge;
    }

    public int getRound(){
        return round;
    }
}
