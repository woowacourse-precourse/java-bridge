package bridge.domain;

import bridge.service.BridgeMaker;
import bridge.util.BridgeNumberGenerator;
import bridge.util.BridgeRandomNumberGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private List<String> user;
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private boolean isBridgeGameEnd = false;
    private Integer tryCount = 0;

    public BridgeGame(Integer bridgeSize) {
        bridge = bridgeMaker.makeBridge(bridgeSize);
        user = new ArrayList<>();
        isBridgeGameEnd = false;
        tryCount = 1;
    }

    public void setTryCount(Integer tryCount) {
        this.tryCount = tryCount;
    }


    public boolean getIsBridgeGameEnd() {
        return isBridgeGameEnd;
    }

    public void setBridgeGameEnd(boolean bridgeGameEnd) {
        isBridgeGameEnd = bridgeGameEnd;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getUser() {
        return user;
    }


    public Integer getTryCount() {
        return tryCount;
    }
}
