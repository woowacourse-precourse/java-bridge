package bridge.Model.WrappingType;

import bridge.Enum.CrossResult;

import java.util.List;

public class Bridge {
    List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public CrossResult cross(ChoiceDirection choiceDirection, int nextPosition) {
        String nextBridgeDirection = bridge.get(nextPosition);
        if (choiceDirection.compare(nextBridgeDirection)) {
            return CrossResult.SUCCESS;
        }
        return CrossResult.FAIL;
    }

    public int length() {
        return bridge.size();
    }
}
