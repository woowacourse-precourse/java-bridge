package bridge.Model.VO;

import bridge.Enum.CrossResult;

import java.util.List;

public class Bridge {
    List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public CrossResult cross(UserChoice userChoice, int position) {
        String crossableBridge = bridge.get(position);

        if (userChoice.equals(crossableBridge)) {
            return CrossResult.SUCCESS;
        }
        return CrossResult.FAIL;
    }

    public int length() {
        return bridge.size();
    }
}
