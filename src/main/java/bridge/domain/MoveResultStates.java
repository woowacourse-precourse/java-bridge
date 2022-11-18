package bridge.domain;

import bridge.domain.state.Ready;
import bridge.domain.state.State;
import bridge.dto.MovingDTO;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MoveResultStates {
    private final LinkedList<State> states;
    
    public MoveResultStates() {
        states = new LinkedList<>();
    }
    
    public void move(final MovingDTO movingDTO, final Bridge bridge) {
        System.out.println(bridge);
        readyState(bridge);
        convertToNextState(movingDTO);
    }
    
    private void readyState(final Bridge bridge) {
        states.add(new Ready(bridge));
    }
    
    private void convertToNextState(final MovingDTO movingDTO) {
        states.set(statesLastIndex(), nextState(movingDTO));
    }
    
    private State nextState(final MovingDTO movingDTO) {
        return lastState().move(statesLastIndex(), movingDTO.getMoving());
    }
    
    private int statesLastIndex() {
        return states.size() - 1;
    }
    
    private State lastState() {
        return states.getLast();
    }
    
    public boolean isMoveFail() {
        return lastState().isMoveFailed();
    }
    
    public void initMovingStates() {
        states.clear();
    }
    
    public boolean isGameFinished() {
        return !isStatesEmpty() && isAllSucceed();
    }
    
    private boolean isAllSucceed() {
        return lastState().isGameFinished(states.size());
    }
    
    private boolean isStatesEmpty() {
        return states.isEmpty();
    }
    
    public List<MoveResult> moveResult() {
        return states.stream()
                .map(State::state)
                .collect(Collectors.toUnmodifiableList());
    }
    
    public List<String> movings() {
        return states.stream()
                .map(State::moving)
                .collect(Collectors.toUnmodifiableList());
    }
    
    @Override
    public String toString() {
        return "MoveResultStates{" +
                "states=" + states +
                '}';
    }
}
