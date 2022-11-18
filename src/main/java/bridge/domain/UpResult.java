package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class UpResult {

    private final Bridge bridge;
    private final Move move;
    private List<String> UpResult;

    public UpResult(Bridge bridge, Move move){
        this.bridge = bridge;
        this.move = move;
    }

    public void resetUpResult(){
        this.UpResult = new ArrayList<>();
    }

    public void makeUpResult(){
        String result = this.bridge.successUpMove(this.move);

        this.UpResult.add(this.bridge.successUpMove(this.move));
    }
}
