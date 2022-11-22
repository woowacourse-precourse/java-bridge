package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class MoveResult {

    private final boolean currentMovingResult;
    private final String currentStep;

    public MoveResult(boolean currentMovingResult, String currentStep){
        this.currentMovingResult = currentMovingResult;
        this.currentStep = currentStep;
    }

    public boolean isUpMove(){
        if(this.currentStep.equals("U")){
            return true;
        }
        return false;
    }

    public boolean isSuccessMove(){
        if(this.currentMovingResult == true){
            return true;
        }
        return false;
    }

}
