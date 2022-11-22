package bridge.domain;

import bridge.domain.type.MoveResultType;

public class BridgeWalker {
    static final int START_POSITION = 0;
    private int position;
    private MoveRecord moveRecord;
    private Bridge bridge;

    private BridgeWalker(MoveRecord moveRecord, Bridge bridge) {
        this.moveRecord = moveRecord;
        this.bridge = bridge;
        this.position = START_POSITION;
    }

    public static BridgeWalker valueOf(Bridge bridge) {
        return new BridgeWalker(new MoveRecord(), bridge);
    }

    public MoveResultType move(String moveCommand) {
        MoveResultType moveResultType = bridge.getMoveResult(moveCommand, position);
        moveRecord.recordMovement(moveResultType, moveCommand);
        if (moveResultType.equals(MoveResultType.SUCCESS)) {
            position++;
        }
        return moveResultType;
    }

    public String getMoveRecord() {
        return moveRecord.getRecord();
    }

    public boolean isCrossAllStep() {
        return bridge.isEndOfBridge(position);
    }

    public void reset() {
        position = START_POSITION;
        moveRecord.resetRecord();
    }
}
