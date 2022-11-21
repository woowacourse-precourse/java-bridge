package bridge.Model.WrappingType;

import bridge.Enum.CrossResult;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public CrossResult cross(ChoiceDirection choiceDirection, int position) {
        String bridgeDirection = bridge.get(position);
        if (choiceDirection.compare(bridgeDirection)) {
            return CrossResult.SUCCESS;
        }
        return CrossResult.FAIL;
    }

    public boolean isEndPoint(int position){
        return endPoint() - position == 0;
    }

    private int endPoint() {
        return bridge.size() - 1;
    }
}
