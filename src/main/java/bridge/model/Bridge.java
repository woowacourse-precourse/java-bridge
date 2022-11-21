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

    /**
     * answerBridge와 일치하는지 비교한다.
     *
     * @param answerBridge: 무조건 정답 Bridge가 입력돼야 한다.
     * @return 현재 길이까지 같으면 true
     */
    public boolean matchAll(Bridge answerBridge) {
        return bridge.equals(answerBridge.bridge);
    }

    /**
     * 현재 Bridge와 answerBridge의 일부분과 비교한다.
     *
     * @param answerBridge: 무조건 정답 Bridge가 입력돼야 한다.
     * @return 현재 길이까지 같으면 true
     */
    public boolean matchCurrentState(Bridge answerBridge) {
        for (int i = 0; i < bridge.size(); i++) {
            if (!matchIndex(answerBridge, i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 현재 Bridge와 answerBridge의 특정 위치와 비교한다.
     *
     * @param answerBridge: 무조건 정답 Bridge가 입력돼야 한다.
     * @param index:        비교할 위치
     * @return
     */
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
