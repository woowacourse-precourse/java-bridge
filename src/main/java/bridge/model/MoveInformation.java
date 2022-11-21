package bridge.model;

import bridge.model.enums.MoveChoice;

public class MoveInformation {
    private final boolean moveSucceed;
    private final MoveChoice moveChoice;

    public MoveInformation(boolean moveSucceed, MoveChoice moveChoice) {
        this.moveSucceed = moveSucceed;
        this.moveChoice = moveChoice;
    }

    public boolean moveSucceed(){
        return moveSucceed;
    }

    public int getRow(){
        return moveChoice.getRow();
    }
}
