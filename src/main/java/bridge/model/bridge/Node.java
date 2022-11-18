package bridge.model.bridge;

public enum Node {
    UP("U"),
    DOWN("D");

    private static final int UP_POSITION = 1;
    private static final int DOWN_POSITION = 0;

    private static final String INVALID_POSITION_FOR_BRIDGE_NODE =
            "다리의 위치는" + UP.position + " 또는 " + DOWN.position + "이어야 합니다.";

    String position;

    Node(String upOrDown) {
        position = upOrDown;
    }

    public Node of(int position) {
        if (position == UP_POSITION) {
            return UP;
        }
        if (position == DOWN_POSITION) {
            return DOWN;
        }
        throw new IllegalArgumentException(INVALID_POSITION_FOR_BRIDGE_NODE);
    }
}