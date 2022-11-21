package bridge;

import java.util.List;

public class Bridge {

    private final List<String> bridge;
    int answerCount = 0;
    boolean currentResult = true;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public void compareWithBridge(String input) {
        currentResult = false;
        if (bridge.get(0).equals(input)) {
            answerCount++;
            currentResult = true;
        }
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public boolean isCurrentResult() {
        return currentResult;
    }
}
