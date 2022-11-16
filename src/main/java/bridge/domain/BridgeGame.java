package bridge.domain;

import bridge.domain.state.Ready;
import bridge.domain.state.State;
import bridge.domain.strategy.BridgeNumberGenerator;
import bridge.dto.BridgeSizeDTO;
import bridge.dto.MovingDTO;

import java.util.LinkedList;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private NumberOfTry numberOfTry;
    private final LinkedList<State> states;
    
    public BridgeGame(final BridgeNumberGenerator bridgeNumberGenerator, final BridgeSizeDTO bridgeSizeDTO) {
        bridge = new Bridge(bridgeNumberGenerator, bridgeSizeDTO.getBridgeSize());
        numberOfTry = new NumberOfTry();
        states = new LinkedList<>();
        System.out.println(bridge);
    }
    
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(final MovingDTO movingDTO) {
        states.add(nextState(movingDTO));
    }
    
    private State nextState(final MovingDTO movingDTO) {
        return initReady().move(states.size(), movingDTO.getMoving());
    }
    
    private Ready initReady() {
        return new Ready(bridge);
    }
    
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        initMove();
        increaseNumberOfTry();
    }
    
    private void initMove() {
        states.clear();
    }
    
    private void increaseNumberOfTry() {
        this.numberOfTry = numberOfTry.increase();
    }
    
    public boolean isGameFinished() {
        return !states.isEmpty() && lastState().isGameFinished(states.size());
    }
    
    public boolean isMoveFail() {
        return lastState().isMoveFail();
    }
    
    private State lastState() {
        return states.getLast();
    }
}
