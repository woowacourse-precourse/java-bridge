package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeResult {
    private static final String SPACE = " ";
    private static final String SEPARATOR = "|";

    private List<String> bridgeResult;

    public BridgeResult() {
        this.bridgeResult = new ArrayList<>();
    }

    public List<String> getBridgeResult() {
        return bridgeResult;
    }

    public void none() {
        bridgeResult.add(SPACE);
    }

    public void add(String compareBridgeResult) {
        bridgeResult.add(compareBridgeResult);
    }

    public void revert() {
        bridgeResult.remove(bridgeResult.size() - 1);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        bridgeResult.stream()
                .forEach(result -> stringBuffer.append(SPACE).append(result).append(SPACE).append(SEPARATOR));
        return stringBuffer.substring(0, stringBuffer.length() - 1);
    }
}
