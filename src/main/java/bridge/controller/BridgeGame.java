package bridge.controller;

import bridge.domain.AnswerBridge;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import org.mockito.stubbing.Answer;

import java.util.List;

public class BridgeGame {

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void run() {
        OutputView.printStart();
        int bridgeSize = InputView.getInputBridgeSize();

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        AnswerBridge answerBridge = new AnswerBridge(bridge);

        while(true) {
            String moving = InputView.getInputMoving();
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
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
