package bridge.domain.state;

import bridge.domain.MoveResult;
import bridge.domain.constants.BridgeConstants;

import java.util.List;

public class Ready extends Started {
    public Ready(final List<String> bridge) {
        super(bridge);
    }
    
    @Override
    public State move(final int currentPosition) {
        if (isPartBridgeExist(currentPosition)) {
            return new Success(bridge());
        }
        
        return new Fail(bridge());
    }
    
    private boolean isPartBridgeExist(final int currentPosition) {
        return partBridge(currentPosition).equals(BridgeConstants.UPPER_COMPARTMENT);
    }
    
    private String partBridge(final int currentPosition) {
        return bridge().get(currentPosition);
    }
    
    @Override
    public boolean isMoveFail() {
        throw new IllegalStateException("[ERROR] 현재 상태에선 이동 성공 여부를 판단할 수 없습니다.");
    }
    
    @Override
    public boolean isGameFinished(final int numberOfMoves) {
        throw new IllegalStateException("[ERROR] 현재 상태에선 게임 종료 여부를 판단할 수 없습니다.");
    }
    
    @Override
    public MoveResult state() {
        return MoveResult.READY;
    }
}
