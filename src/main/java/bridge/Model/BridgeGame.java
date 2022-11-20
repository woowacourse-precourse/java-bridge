package bridge.Model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.CrossResult;
import bridge.Model.VO.Bridge;
import bridge.Model.VO.BridgeSize;
import bridge.Model.VO.UserChoice;
import bridge.Model.VO.ChoiceResults;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    ChoiceResults choiceResults;
    Bridge bridge;

    public BridgeGame(BridgeSize bridgeSize){
        choiceResults = new ChoiceResults();
        bridge = new Bridge(makeBridge(bridgeSize));
    }
    private List<String> makeBridge(BridgeSize bridgeSize){
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        int size = bridgeSize.getSize();
        return bridgeMaker.makeBridge(size);
    }
    public void move() {

    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
