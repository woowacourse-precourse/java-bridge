package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class MoveResult {

    public boolean movingResult;
    private String step;
    public static List<String> history = new ArrayList<>();
    public MoveResult(boolean movingResult, String step){
        this.movingResult = movingResult;
        this.step = step;
        isItMoved(this.movingResult, this.step);
    }

    private void isItMoved(boolean movingResult, String step){
        if (movingResult){
            this.history.add(step);
        }
    }
}
