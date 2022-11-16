package bridge.domain.state;

import bridge.domain.MoveResult;

import java.util.List;

public class Success extends MoveComplete {
    public Success(final List<String> bridge) {
        super(bridge);
    }
    
    @Override
    public boolean isMoveFail() {
        return false;
    }
    
    @Override
    public boolean isGameFinished(final int numberOfMoves) {
        return bridge().size() - 1 == numberOfMoves;
    }
    
    @Override
    public MoveResult state() {
        return MoveResult.SUCCESS;
    }
}
