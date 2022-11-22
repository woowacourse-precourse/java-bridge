package bridge.vo;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private List<String> bridge;

    public Bridge(List<String> bridge) {
        validate(bridge);
        this.bridge = bridge;
    }

    public void validate(List<String> bridge) {
        boolean isAllMatchUAndD = containsOnlyUAndD(bridge);

        if (!isAllMatchUAndD) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MATCH_DIRECTION_MESSAGE.toString());
        }
    }

    public boolean containsOnlyUAndD(List<String> bridge) {
        return bridge.stream().allMatch((direction)
                -> direction.equals(StepDirectionCommand.U.toString()) ||
                direction.equals(StepDirectionCommand.D.toString()));
    }

    public boolean checkCrossableBridge(int currentStandingIndex, String currentStandingPosition) {
        return bridge.get(currentStandingIndex).equals(currentStandingPosition);
    }

    public List<String> getBridge() {
        return new ArrayList<>(bridge);
    }

    public int getBridgeIndex() {
        return bridge.size() - 1;
    }
}
