package bridge.constants;

import java.util.Map;

public class BridgeConstant {
    public static Map<String,String> directionAccessTable = Map.of(
            DirectionTable.DOWN.getInitial(), "DOWN",
            DirectionTable.UP.getInitial(), "UP",
            DirectionTable.NOT_DOWN.getInitial(), "NOT_DOWN",
            DirectionTable.NOT_UP.getInitial(), "NOT_UP"
    );
    public static String WRONG_POSITION = "N";
    public static int BRIDGE_WIDTH = 2;


}
