package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class MoveResult {

    private boolean currentMovingResult;
    private static String currentStep;

    public void pringMoveResult(MoveResult moveResult){
        System.out.println(moveResult.currentMovingResult+moveResult.currentStep);
    }
    public MoveResult(boolean currentMovingResult, String currentStep){
        this.currentMovingResult = currentMovingResult;
        this.currentStep = currentStep;
    }

    public boolean isUpMove(MoveResult moveResult){
        if(moveResult.currentStep.equals("U")){
            return true;
        }
        return false;
    }

    public boolean isSuccessMove(MoveResult moveResult){
        if(moveResult.currentMovingResult == true){
            return true;
        }
        return false;
    }

}
