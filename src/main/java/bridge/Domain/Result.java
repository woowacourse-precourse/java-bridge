package bridge.Domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<String> moves;
    private boolean isSuccess;
    private int tryCount;

    public Result(){
        moves = new ArrayList<>();
        isSuccess = false;
        tryCount = 1;
    }

    public void clearMoves(){

    }

    public void addTryCount(){

    }
}
