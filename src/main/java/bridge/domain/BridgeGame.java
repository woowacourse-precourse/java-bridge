package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private final List<String> bridge;
    private final List<String> bridgeCrossingResult = new ArrayList<>();

    public BridgeGame(List<String> bridge){
        this.bridge = bridge;
    }

    public List<String> move(String userInput) {
        if (bridge.get(bridgeCrossingResult.size()).equals(userInput)){
            bridgeCrossingResult.add("O");
            return bridgeCrossingResult;
        }
        bridgeCrossingResult.add("X");
        return bridgeCrossingResult;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}