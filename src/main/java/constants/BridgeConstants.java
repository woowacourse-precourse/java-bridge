package constants;

import java.util.Map;

public abstract class BridgeConstants {

    public static final int MIN_BRIDGE_SIZE = 3;
    public static final int MAX_BRIDGE_SIZE = 20;
    public static final String UP_DIRECTION = "U";
    public static final String DOWN_DIRECTION = "D";
    public static final String RESTART = "R";
    public static final String QUIT = "Q";
    public static final String RIGHT_ANSWER = "O";
    public static final String WRONG_ANSWER = "X";
    public static final Map<Integer, String> bridgeDirection = Map.of(
            0, BridgeConstants.DOWN_DIRECTION,
            1, BridgeConstants.UP_DIRECTION
    );

    private BridgeConstants() {}
}
