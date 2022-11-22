package bridge.controller.dto;

public class MoveResult {

    private boolean isMove;
    private boolean isEnd;
    private String map;

    public MoveResult(boolean isMove, boolean isEnd, String map) {
        this.isMove = isMove;
        this.isEnd = isEnd;
        this.map = map;
    }

    public boolean isMove() {
        return isMove;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public String getMap() {
        return map;
    }
}
