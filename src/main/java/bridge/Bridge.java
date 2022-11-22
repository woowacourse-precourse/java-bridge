package bridge;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isCorrect(List<String> inputDirections) {
        return bridge.get(bridge.size() - 1).equals(inputDirections.get(inputDirections.size() - 1));
    }

    public boolean isCleared(List<String> inputDirections){
        return isCorrect(inputDirections) && bridge.size() == inputDirections.size();
    }
}
