package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class MoveResult {

    private boolean movingResult;
    private String step;

    public MoveResult(boolean movingResult, String step){
        this.movingResult = movingResult;
        this.step = step;
    }

}
