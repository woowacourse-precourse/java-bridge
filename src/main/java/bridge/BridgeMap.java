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

    private void moveUp() {
        upStair.add(upStair.size() - INSERT_PIVOT, BridgeShape.DIVISION);
        upStair.add(upStair.size() - INSERT_PIVOT, BridgeShape.ALLOW_MOVE);
        downStair.add(upStair.size() - INSERT_PIVOT, BridgeShape.DIVISION);
        downStair.add(upStair.size() - INSERT_PIVOT, BridgeShape.BLANK);
    }

    private void moveDown() {
        upStair.add(upStair.size() - INSERT_PIVOT, BridgeShape.DIVISION);
        upStair.add(upStair.size() - INSERT_PIVOT, BridgeShape.BLANK);
        downStair.add(upStair.size() - INSERT_PIVOT, BridgeShape.DIVISION);
        downStair.add(upStair.size() - INSERT_PIVOT, BridgeShape.ALLOW_MOVE);
    }

    private void failMoveUp() {
        upStair.add(upStair.size() - INSERT_PIVOT, BridgeShape.DIVISION);
        upStair.add(upStair.size() - INSERT_PIVOT, BridgeShape.REFUSE_MOVE);
        downStair.add(upStair.size() - INSERT_PIVOT, BridgeShape.DIVISION);
        downStair.add(upStair.size() - INSERT_PIVOT, BridgeShape.BLANK);
    }
}
