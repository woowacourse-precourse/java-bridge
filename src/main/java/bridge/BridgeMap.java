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

}
