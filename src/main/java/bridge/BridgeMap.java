package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {

    private static final int INSERT_PIVOT = 2;

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

    public void moveSussess(InputType inputType) {
        inputDivision();
        if(inputType.equals(InputType.UP)) {
            upStair.add(upStair.size() - INSERT_PIVOT, BridgeShape.ALLOW_MOVE);
            downStair.add(upStair.size() - INSERT_PIVOT, BridgeShape.BLANK);
            return;
        }
        upStair.add(upStair.size() - INSERT_PIVOT, BridgeShape.BLANK);
        downStair.add(upStair.size() - INSERT_PIVOT, BridgeShape.ALLOW_MOVE);
    }

    public void moveFail(InputType inputType) {
        inputDivision();
        if(inputType.equals(InputType.UP)) {
            upStair.add(upStair.size() - INSERT_PIVOT, BridgeShape.REFUSE_MOVE);
            downStair.add(upStair.size() - INSERT_PIVOT, BridgeShape.BLANK);
            return;
        }
        upStair.add(upStair.size() - INSERT_PIVOT, BridgeShape.BLANK);
        downStair.add(upStair.size() - INSERT_PIVOT, BridgeShape.REFUSE_MOVE);
    }

    private void inputDivision() {
        upStair.add(upStair.size() - INSERT_PIVOT, BridgeShape.DIVISION);
        downStair.add(downStair.size() - INSERT_PIVOT, BridgeShape.DIVISION);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        upStair.forEach(stringBuilder::append);
        stringBuilder.append("\n");
        downStair.forEach(stringBuilder::append);

        return stringBuilder.toString();
    }
}
