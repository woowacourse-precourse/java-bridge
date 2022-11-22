package bridge;

import java.util.List;
import java.util.Objects;

import bridge.EnumClass.EnumStates;

public class BridgeGame {

    private int index = 0;

    public EnumStates move(String command, List<String> bridge) {
        if (isFinished(command, bridge)) {
            return EnumStates.Success;
        }
        return isNotFinished(command, bridge);
    }

    private boolean isFinished(String command, List<String> bridge) {
        EnumStates.Index.setWorth(index + 1);
        return (index == bridge.size() - 1) && (Objects.equals(bridge.get(index), command));
    }

    private EnumStates isNotFinished(String command, List<String> bridge) {
        if (Objects.equals(bridge.get(index), command)) {
            index++;
            EnumStates.Index.setWorth(index);
            return EnumStates.In_game;
        }
        index++;
        return EnumStates.Retry;
    }

    public void retry() {
        index = 0;
        EnumStates.Index.setWorth(index);
    }
}
