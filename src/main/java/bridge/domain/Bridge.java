package bridge.domain;

import bridge.domain.message.ErrorMessage;
import bridge.domain.utils.BridgeCommand;
import bridge.exception.IllegalGenerateException;

import java.util.List;

public class Bridge {
    private List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        validateInNothing(bridge);
    }

    private void validateInNothing(List<String> bridge) {
        if (bridge.contains(BridgeCommand.NOTING.getCommand()))
            throw new IllegalGenerateException(ErrorMessage.BRIDGE_GENERATE_ERROR);
    }

    public boolean isAlive(String position, int index) {
        return bridge.get(index).equals(position);
    }

    public int getBridgeSize() {
        return bridge.size();
    }
}
