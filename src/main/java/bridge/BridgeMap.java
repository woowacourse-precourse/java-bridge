package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {

    private static final int PIVOT_GAP = 1;
    private static final int INIT_SIZE = 2;

    private final List<BridgeShape> upStair = new ArrayList<>();
    private final List<BridgeShape> downStair = new ArrayList<>();


    public BridgeMap() {
        init();
    }

    private void init() {
        upStair.add(BridgeShape.STARTING_POINT);
        upStair.add(BridgeShape.ENDING_POINT);
        downStair.add(BridgeShape.STARTING_POINT);
        downStair.add(BridgeShape.ENDING_POINT);
    }

    public void moveSuccess(Command command) {
        inputDivision();
        if (command.equals(Command.UP)) {
            upStair.add(getInsertPivot(upStair), BridgeShape.ALLOW_MOVE);
            downStair.add(getInsertPivot(downStair), BridgeShape.BLANK);
            return;
        }
        upStair.add(getInsertPivot(upStair), BridgeShape.BLANK);
        downStair.add(getInsertPivot(downStair), BridgeShape.ALLOW_MOVE);
    }

    public void reset() {
        upStair.clear();
        downStair.clear();
        init();
    }

    public void moveFail(Command command) {
        inputDivision();
        if (command.equals(Command.UP)) {
            upStair.add(getInsertPivot(upStair), BridgeShape.REFUSE_MOVE);
            downStair.add(getInsertPivot(downStair), BridgeShape.BLANK);
            return;
        }
        upStair.add(getInsertPivot(upStair), BridgeShape.BLANK);
        downStair.add(getInsertPivot(downStair), BridgeShape.REFUSE_MOVE);
    }

    private void inputDivision() {
        if (upStair.size() == INIT_SIZE) {
            return;
        }
        upStair.add(getInsertPivot(upStair), BridgeShape.DIVISION);
        downStair.add(getInsertPivot(downStair), BridgeShape.DIVISION);
    }

    private int getInsertPivot(List<BridgeShape> upStair) {
        return upStair.size() - PIVOT_GAP;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        upStair.forEach(stringBuilder::append);
        stringBuilder.append("\n");
        downStair.forEach(stringBuilder::append);
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }
}