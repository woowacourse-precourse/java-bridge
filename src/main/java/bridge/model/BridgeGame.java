package bridge.model;

import bridge.constant.GameStatus;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
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
        updateTryCount();
        initializeRound();
        initializeGameStatus();
    }

    private void updateTryCount(){
        tryCount++;
    }

    private void initializeRound(){
        round = 0;
    }

    private void initializeGameStatus(){
        gameStatus = GameStatus.READY;
    }
    
    public void createBridge(int size){
        bridge = new Bridge(size);
    }

    public void checkAnswerOfRound(String answer){
        if(!bridge.checkBlock(answer, round)){
            gameStatus = GameStatus.FAIL;
            return;
        }
        move();
        gameStatus = GameStatus.IN_PROGRESS;
    }

    public boolean checkGameSuccess(){
        if(round > bridge.getSize()){
            gameStatus = GameStatus.SUCCESS;
            return true;
        }
        return false;
    }
}
