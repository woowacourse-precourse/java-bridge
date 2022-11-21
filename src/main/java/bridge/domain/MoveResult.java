package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class MoveResult {

    public boolean currentMovingResult;
    public static String currentStep;
    public MoveResult(boolean currentMovingResult, String currentStep){
        this.currentMovingResult = currentMovingResult;
        this.currentStep = currentStep;
    }

    public boolean isUpMove(){
        if(this.currentStep == "U"){
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
