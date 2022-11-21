package bridge;

import bridge.messages.InputMessage;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private InputView inputView;
    private OutputView outputView;
    private final boolean willRetry = true;
    private final boolean willNotRetry = false;

    public BridgeGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
    /**
     * 사용자가 게임을 시작할 때 사용하는 메서드
     */
    public void start() {
        outputView.printStartMessage();
        int bridgeSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        boolean retry = play(bridgeSize, bridge);
        while (retry) {
            retry = willRetry(bridgeSize, bridge);
        }
    }

    /**
     * 실제 게임이 진행되는 메서드
     */
    private boolean play(int bridgeSize, List<String> bridge) {
        for (int i = 0; i < bridgeSize; ++i) {
            String moveDirection = move();
            outputView.printMap(i, moveDirection, bridge);
            if (!isRightMove(moveDirection, bridge.get(i))) {
                return willRetry;
            }
        }
        return willNotRetry;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move() {
        String moveDirection = inputView.readMoving();
        return moveDirection;
    }

    private boolean isRightMove(String movedDirection, String answerDirection) {
        return movedDirection.equals(answerDirection);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean willRetry(int bridgeSize, List<String> bridge) {
        String retryInput = inputView.readGameCommand();
        if (retryInput.equals("Q")) {
            return false;
        }
        return play(bridgeSize, bridge);
    }
}
