package bridge.domain;

import bridge.domain.state.Ready;
import bridge.domain.state.MoveResultState;
import bridge.dto.MovingDTO;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MoveResultStates {
    private final LinkedList<MoveResultState> moveResultStates;
    
    public MoveResultStates() {
        moveResultStates = new LinkedList<>();
    }
    
    public void move(final MovingDTO movingDTO, final Bridge bridge) {
        System.out.println(bridge);
        readyState(bridge);
        convertToNextState(movingDTO);
    }
    
    private void readyState(final Bridge bridge) {
        moveResultStates.add(new Ready(bridge));
    }
    
    private void convertToNextState(final MovingDTO movingDTO) {
        moveResultStates.set(statesLastIndex(), nextState(movingDTO));
    }
    
    private MoveResultState nextState(final MovingDTO movingDTO) {
        return lastState().move(statesLastIndex(), movingDTO.getMoving());
    }
    
    private int statesLastIndex() {
        return moveResultStates.size() - 1;
    }
    
    private MoveResultState lastState() {
        return moveResultStates.getLast();
    }
    
    public boolean isMoveFail() {
        return lastState().isMoveFailed();
    }
    
    public void initMovingStates() {
        moveResultStates.clear();
    }
    
    public boolean isGameFinished() {
        return !isStatesEmpty() && isAllSucceed();
    }
    
    private boolean isAllSucceed() {
        return lastState().isGameFinished(moveResultStates.size());
    }
    
    private boolean isStatesEmpty() {
        return moveResultStates.isEmpty();
    }
    
    public List<MoveResultState> states() {
        return Collections.unmodifiableList(moveResultStates);
    }
    
    public List<String> movings() {
        return moveResultStates.stream()
                .map(MoveResultState::moving)
                .collect(Collectors.toUnmodifiableList());
    }
    
    @Override
    public String toString() {
        return "MoveResultStates{" +
                "states=" + moveResultStates +
                '}';
    }
}
