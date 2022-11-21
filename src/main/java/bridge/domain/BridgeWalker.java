package bridge.domain;

public class BridgeWalker {
    static int START_POSITION = 0;
    int position;
    MoveRecord moveRecord;
    Bridge bridge;

    public BridgeWalker(MoveRecord moveRecord, Bridge bridge){
        this.moveRecord = moveRecord;
        this.bridge = bridge;
        this.position = START_POSITION;
    }

    public MoveResult move(String moveCommand){
        MoveResult moveResult = bridge.getMoveResult(moveCommand, position);
        moveRecord.recordMovement(moveResult, moveCommand);
        if(moveResult.equals(MoveResult.SUCCESS)){
            position++;
        }
        return moveResult;
    }

    public String getMoveRecord(){
        return moveRecord.getRecord();
    }

    public boolean isCrossAllStep(){
        if(bridge.isEndOfBridge(position)){
            return true;
        }
        return false;
    }

    public void reset(){
        position = START_POSITION;
        moveRecord.resetRecord();
    }
}
