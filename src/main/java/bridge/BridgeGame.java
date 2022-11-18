package bridge;

import bridge.InputView;
import bridge.OutputView;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public int determineBridgeSize() {
        outputView.printBridgeLengthInputRequest();
        return inputView.readBridgeSize();
    }

    public int move(List<String> crossable) {
        int howManyAttempts;
        howManyAttempts = bridgeMaker.makeMap(crossable);
        return howManyAttempts;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
