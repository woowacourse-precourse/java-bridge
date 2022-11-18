package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class DownResult {
    private final Bridge bridge;
    private final Move move;
    private List<String> DownResult;

    public DownResult(Bridge bridge, Move move){
        this.bridge = bridge;
        this.move = move;
    }

    public void resetUpResult(){
        this.DownResult = new ArrayList<>();
    }

    public void makeUpResult(){
        this.DownResult.add(this.bridge.successDownMove(this.move));
    }
}
