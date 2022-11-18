package bridge.controller;

import bridge.BridgeMaker;
import bridge.domain.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private Bridge bridge;

    public BridgeGame(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
        outputView.printStartMessage();
        outputView.printInputLengthMessage();
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

    public int inputBridgeLength() {
        try {
            String length = inputView.input();
            return inputView.readBridgeSize(length);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBridgeLength();
        }
    }

    public String inputDirection() {
        try {
            String direction = inputView.input();
            return inputView.readMoving(direction);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputDirection();
        }
    }

    public void setUpBridge(int size) {
        bridge = new Bridge(bridgeMaker.makeBridge(size));
    }

    public void initialize() {
        setUpBridge(inputBridgeLength());
    }
}
