package bridge.model;

import bridge.model.enumeration.ExceptionMessage;

import java.util.List;

public class Bridge {

    private final List<String> bridges;

    public Bridge(List<String> bridges) {
        validateBridge(bridges);
        this.bridges = bridges;
    }

    protected void validateBridge(List<String> bridges) {
        if (!bridges.contains("U") || !bridges.contains("D")) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BRIDGE_COMMAND.getExceptionMessage());
        }
    }
}

