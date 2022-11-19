package bridge;

import java.util.List;

public class PrintBridgeShape {

    private final String OPEN = "[";
    private final String CLOSE = "]";
    private final String CONNECT = "|";
    private final StringBuilder bridge = new StringBuilder();

    public StringBuilder printBridge(List<String> bridgeShape) {

        return bridge.append(OPEN)
                .append(getCONNECT(bridgeShape))
                .append(CLOSE);
    }

    public String getCONNECT(List<String> bridgeShape) {
        return String.join(CONNECT, bridgeShape);
    }
}
