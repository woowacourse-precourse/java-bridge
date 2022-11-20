package model;

import model.enums.MoveChoice;
import model.enums.MoveResult;

public class MoveInformation {
    private final MoveResult moveResult;
    private final MoveChoice moveChoice;

    public MoveInformation(MoveResult moveResult, MoveChoice moveChoice) {
        this.moveResult = moveResult;
        this.moveChoice = moveChoice;
    }

    public Boolean moveSucceed(){
        return moveResult.succeed();
    }

    public int getRow(){
        return moveChoice.getPositionNumber();
    }
}
