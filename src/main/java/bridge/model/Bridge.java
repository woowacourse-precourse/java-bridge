package bridge.model;

import bridge.config.BridgeGameConfig;

import java.util.List;

public class Bridge {
    private List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public void forward(String input){
        bridge.add(input);
    }

    /**
     * answerBridge와 일치하는지 비교한다.
     * @param answerBridge: 무조건 정답 Bridge가 입력돼야 한다.
     * @return 현재 길이까지 같으면 true
     */
    public boolean matchAll(Bridge answerBridge){
        return bridge.equals(answerBridge.bridge);
    }

    /**
     * 현재 Bridge와 정답 Bridge의 일부분과 비교한다.
     * @param answerBridge: 무조건 정답 Bridge가 입력돼야 한다.
     * @return 현재 길이까지 같으면 true
     */
    public boolean matchCurrentState(Bridge answerBridge){
        List<String> anotherSubBridge = answerBridge.bridge.subList(0, bridge.size());
        return bridge.equals(anotherSubBridge);
    }
}
