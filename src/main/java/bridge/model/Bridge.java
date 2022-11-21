package bridge.model;

import java.util.List;

public class Bridge {
    private List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public void forward(String input) {
        bridge.add(input);
    }

    public int length() {
        return bridge.size();
    }

    public String position(int index) {
        return bridge.get(index);
    }

    public boolean matchAll(Bridge answerBridge) {
        return bridge.equals(answerBridge.bridge);
    }

    public boolean matchCurrentState(Bridge answerBridge) {
        for (int i = 0; i < bridge.size(); i++) {
            if (!matchIndex(answerBridge, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean matchIndex(Bridge answerBridge, int index) {
        return bridge.get(index).equals(answerBridge.bridge.get(index));
    }

    public int findWrongIndex(Bridge answerBridge) {
        for (int index = 0; index < bridge.size(); index++) {
            if (!matchIndex(answerBridge, index)) {
                return index;
            }
        }
        return -1;
    }
}
