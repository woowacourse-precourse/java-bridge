package bridge.domain;

import bridge.domain.state.Ready;
import bridge.domain.state.MovingResultState;
import bridge.dto.MovingDTO;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MoveResultStates {
    private final LinkedList<MovingResultState> movingResultStates;
    
    public MoveResultStates() {
        movingResultStates = new LinkedList<>();
    }
    
    public void move(final MovingDTO movingDTO, final Bridge bridge) {
        System.out.println(bridge);
        readyState(bridge);
        convertToNextState(movingDTO);
    }
    
    private void readyState(final Bridge bridge) {
        movingResultStates.add(new Ready(bridge));
    }
    
    private void convertToNextState(final MovingDTO movingDTO) {
        movingResultStates.set(statesLastIndex(), nextState(movingDTO));
    }
    
    private MovingResultState nextState(final MovingDTO movingDTO) {
        return lastState().move(statesLastIndex(), movingDTO.getMoving());
    }
    
    private int statesLastIndex() {
        return movingResultStates.size() - 1;
    }
    
    private MovingResultState lastState() {
        return movingResultStates.getLast();
    }
    
    public boolean isMoveFail() {
        return lastState().isMoveFailed();
    }
    
    public void initMovingStates() {
        movingResultStates.clear();
    }
    
    public boolean isGameFinished() {
        return !isStatesEmpty() && isAllSucceed();
    }
    
    private boolean isAllSucceed() {
        return lastState().isGameFinished(movingResultStates.size());
    }
    
    private boolean isStatesEmpty() {
        return movingResultStates.isEmpty();
    }
    
    public List<MovingResultState> states() {
        return Collections.unmodifiableList(movingResultStates);
    }
    
    public List<String> movings() {
        return movingResultStates.stream()
                .map(MovingResultState::moving)
                .collect(Collectors.toUnmodifiableList());
    }
    
    @Override
    public String toString() {
        return "MoveResultStates{" +
                "states=" + movingResultStates +
                '}';
    }
}
