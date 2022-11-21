package bridge.domain.state;

public interface MoveResultState {
    MoveResultState move(final int positionToMove, final String moving);
    
    boolean isMoveFailed();
    
    boolean isGameFinished(final int numberOfMoves);
    
    String moving();
}
