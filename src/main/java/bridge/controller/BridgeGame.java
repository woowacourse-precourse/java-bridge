package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.GeneratedBridge;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private GeneratedBridge generatedBridge;

    private String bridgeSize;

    public void printBridgeGameStartMessage() {
        outputView.printBridgeGameStartMessage();
    }

    public void inputBridgeSize() {
        outputView.printInputBridgeSizeMessage();
        bridgeSize = inputView.inputBridgeSize();
    }

    public void generateBridge() {
        List<String> bridgeShape = bridgeMaker.makeBridge(Integer.parseInt(bridgeSize));
        generatedBridge = new GeneratedBridge(bridgeShape);
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
