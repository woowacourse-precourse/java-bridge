package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private List<String> bridge;

    public Bridge(List<String> bridge) {
        validate(bridge);
        this.bridge = bridge;
    }

    public void validate(List<String> bridge) {
        boolean isAllMatchUAndD = bridge.stream().allMatch((direction)
                -> direction.equals(StepDirectionCommand.U.toString()) ||
                direction.equals(StepDirectionCommand.D.toString()));

        if(!isAllMatchUAndD) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MATCH_DIRECTION_MESSAGE.toString());
        }
    }

    public List<String> getBridge() {
        return new ArrayList<>(bridge);
    }
}
