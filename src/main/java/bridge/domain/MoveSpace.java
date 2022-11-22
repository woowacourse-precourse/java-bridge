package bridge.domain;

public class MoveSpace {
    private final String move;

    public MoveSpace(String move){
        this.move = move;
    }

    public boolean isItMovable(String step){
        if(step.equals(this.move)){
            return true;
        }
        return false;
    }

    public MoveResult createMoveResult(boolean currentResult){
        return new MoveResult(currentResult, this.move);
    }

}
