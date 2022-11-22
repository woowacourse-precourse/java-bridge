package bridge.game;

import bridge.etc.GameState;
import bridge.etc.PassState;
import java.util.List;

public class Bridge {

    private final List<String> bridge;
    private Integer distance;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        this.distance = 0;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public Integer getDistance() {
        return distance;
    }

    public String getDistanceBlock() {
        return bridge.get(distance - 1);
    }

    public GameState pass(String choice) {
        distance += 1;
        if (getDistanceBlock().equals(choice)) {
            if (isClear()) {
                return GameState.CLEAR;
            }

            return GameState.CONTINUE;
        }

        return GameState.FAIL;
    }

    public Boolean isClear() {
        return bridge.size() <= distance;
    }

    public String getBridgeView(GameState state) {
        String upSideView = getSideView(state, "U");
        String downSideView = getSideView(state, "D");

        return String.format("%s\n%s", upSideView, downSideView);
    }

    private String getSideView(GameState state, String rightDirection) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        getMiddleBlockView(sb, rightDirection, state);

        sb.append("]");

        return sb.toString();
    }

    private StringBuilder getMiddleBlockView(StringBuilder sb, String rightDirection, GameState state) {
        getPassedBlockView(sb, rightDirection);

        Boolean isRightDirection = bridge.get(distance - 1).equals(rightDirection);
        sb.append(state.getLastBlockState(isRightDirection));

        return sb;
    }

    private StringBuilder getPassedBlockView(StringBuilder sb, String rightDirection) {
        for (int i = 0; i < distance - 1; i++) {
            if (bridge.get(i).equals(rightDirection)) {
                sb.append(String.format(" %s |", PassState.RIGHT));
                continue;
            }
            sb.append(String.format(" %s |", PassState.NO_CHOICE));
        }

        return sb;
    }
}
