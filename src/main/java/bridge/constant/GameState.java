package bridge.constant;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public final class GameState {

    public static final int MIN_RANGE = 3;
    public static final int MAX_RANGE = 20;
    public static final String QUIT = "Q";
    public static final String RETRY = "R";

    public static final String UP = "U";
    public static final String DOWN = "D";

    public static final int UP_STATEMENT = 1;
    public static final int DOWN_STATEMENT = 0;

    public static final String EXIST_SQUARE = "O";

    public static final String NO_EXIST_SQUARE = "X";

    public static final String SIDE_SQUARE = " ";


    public static final String GAME_SUCCESS = "성공";

    public static final String GAME_FAIL = "실패";


    public static List<String> makeProcess(int size, BridgeNumberGenerator bridgeNumberGenerator) {
        List<String> bridge = new ArrayList<>();
        for (int index = 0; index < size; index++) {
            bridge.add(putToBridge(bridgeNumberGenerator));
        }
        return bridge;
    }

    private static String putToBridge(BridgeNumberGenerator bridgeNumberGenerator) {
        int generate = bridgeNumberGenerator.generate();
        if (generate == DOWN_STATEMENT) {
            return GameState.DOWN;
        }
        return GameState.UP;
    }

}
