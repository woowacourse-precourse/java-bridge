package bridge.domain;

import bridge.util.ErrorMessage;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BridgeMovement {
    UP("U", 1),
    DOWN("D", 0);

    private String move;
    private int code;

    private static final Map<Integer, BridgeMovement> BY_CODE =
            Stream.of(values()).collect(Collectors.toMap(BridgeMovement::getCode, e -> e));

    private static final Map<String, BridgeMovement> BY_MOVE =
            Stream.of(values()).collect(Collectors.toMap(BridgeMovement::getMove, e -> e));


    BridgeMovement(String move, int code) {
        this.move = move;
        this.code = code;
    }

    public String getMove() {
        return move;
    }

    public int getCode() {
        return code;
    }

    public static BridgeMovement findByCode(int code) {
        return BY_CODE.get(code);
    }

    public static BridgeMovement findByMovement(String move) {
        if(!BY_MOVE.containsKey(move)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_MOVEMENT);
        }
        return BY_MOVE.get(move);
    }

}
