package bridge.domain;

import java.util.List;

/**
 * 생성된 다리를 관리하는 클래스
 */
public class Bridge {

    private final List<String> bridge;

    /**
     * @param size                  다리의 사이즈를 입력 받는다.
     * @param bridgeNumberGenerator 수를 생성할 NumberGenerator를 입력받는다.
     *                              <p>
     *                              생성과 동시에 다리를 만들어, bridge를 초기화 해준다.
     */
    public Bridge(int size, BridgeNumberGenerator bridgeNumberGenerator) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
    }

    /**
     * @param location 사용자의 현재 위치
     * @param goal     사용자가 다음으로 이동할 다리
     * @return location과 사용자가 이동할 다리를 입력받아 갈 수 있는 곳이먄 true 아니면 false를 반환한다.
     */
    public boolean isCanCross(int location, String goal) {
        return bridge.get(location).equals(goal);
    }

    /**
     * @return 다리의 size()를 반환한다.
     */
    public int size() {
        return bridge.size();
    }
}
