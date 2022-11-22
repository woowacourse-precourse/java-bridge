package bridge.domain;

import bridge.domain.state.MovingResultState;
import bridge.dto.MovingDTO;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String GAME_FINISH_CHARACTER = "Q";
    
    private NumberOfTry numberOfTry;
    private final MovingResultStates movingResultStates;
    
    public BridgeGame() {
        numberOfTry = new NumberOfTry();
        movingResultStates = new MovingResultStates();
    }
    
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(final MovingDTO movingDTO, final Bridge bridge) {
        movingResultStates.move(movingDTO, bridge);
    }
    
    public boolean isMoveFail() {
        return movingResultStates.isMoveFail();
    }
    
    public boolean selectGameFinish(final String gameCommand) {
        return gameCommand.equals(GAME_FINISH_CHARACTER);
    }
    
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        initMovingResultStates();
        increaseNumberOfTry();
    }
    
    private void initMovingResultStates() {
        movingResultStates.initMovingResultStates();
    }
    
    private void increaseNumberOfTry() {
        this.numberOfTry = numberOfTry.increase();
    }
    
    public boolean isGameFinished() {
        return movingResultStates.isGameFinished();
    }
    
    public List<MovingResultState> moveStates() {
        return movingResultStates.states();
    }
    
    public List<String> movings() {
        return movingResultStates.movings();
    }
    
    public int numberOfTry() {
        return numberOfTry.numberOfTry();
    }
    
    @Override
    public String toString() {
        return "BridgeGame{" +
                "numberOfTry=" + numberOfTry +
                ", movingResultStates=" + movingResultStates +
                '}';
    }
}
