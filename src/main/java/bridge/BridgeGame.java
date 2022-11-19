package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    private final int bridgeSize;

    public BridgeGame() {
        outputView.printMessage(Message.START);
        outputView.enterLine();
        bridgeSize = inputView.readBridgeSize();
        validate(bridgeSize);
    }

    void validate(int bridgeSize) {
        if (bridgeSize > 20 || bridgeSize < 3) {
            throw new IllegalArgumentException(Message.ERROR_BRIDGE_SIZE_RANGE.getMessage());
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
