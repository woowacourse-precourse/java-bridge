package bridge.model.bridge;

public enum Node {
    UP("U"),
    DOWN("D");

    private static final int UP_POSITION_COORDINATE = 1;
    private static final int DOWN_POSITION_COORDINATE = 0;
    private static final String INVALID_POSITION_COORDINATE_FOR_NODE =
            "다리의 위치는 " + UP_POSITION_COORDINATE + " 또는 " + DOWN_POSITION_COORDINATE + "이어야합니다.";

    private static final String INVALID_POSITION_FOR_BRIDGE_NODE =
            "다리의 위치는 " + UP.position + " 또는 " + DOWN.position + " 이어야 합니다.";

    public String position;

    Node(String upOrDown) {
        position = upOrDown;
    }

    public static Node of(int position) {
        if (position == UP_POSITION_COORDINATE) {
            return UP;
        }
        if (position == DOWN_POSITION_COORDINATE) {
            return DOWN;
        }
        throw new IllegalArgumentException(INVALID_POSITION_COORDINATE_FOR_NODE);
    }

    public static Node of(String position) {
        if (position.equals(Node.UP.position)) {
            return UP;
        }
        if (position.equals(Node.DOWN.position)) {
            return DOWN;
        }
        throw new IllegalArgumentException(INVALID_POSITION_FOR_BRIDGE_NODE);
    }
}