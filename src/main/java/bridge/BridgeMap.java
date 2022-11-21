package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {

    private static final int INSERT_PIVOT = 1;
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
            upStair.add(upStair.size() - INSERT_PIVOT, BridgeShape.ALLOW_MOVE);
            downStair.add(downStair.size() - INSERT_PIVOT, BridgeShape.BLANK);
            return;
        }
        upStair.add(upStair.size() - INSERT_PIVOT, BridgeShape.BLANK);
        downStair.add(downStair.size() - INSERT_PIVOT, BridgeShape.ALLOW_MOVE);
    }

    public void moveFail(Command command) {
        inputDivision();
        if (command.equals(Command.UP)) {
            upStair.add(upStair.size() - INSERT_PIVOT, BridgeShape.REFUSE_MOVE);
            downStair.add(downStair.size() - INSERT_PIVOT, BridgeShape.BLANK);
            return;
        }
        upStair.add(upStair.size() - INSERT_PIVOT, BridgeShape.BLANK);
        downStair.add(downStair.size() - INSERT_PIVOT, BridgeShape.REFUSE_MOVE);
    }

    private void inputDivision() {
        if(upStair.size() == INIT_SIZE) {
            return;
        }
        upStair.add(upStair.size() - INSERT_PIVOT, BridgeShape.DIVISION);
        downStair.add(downStair.size() - INSERT_PIVOT, BridgeShape.DIVISION);
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