package bridge;

import bridge.view.View;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    static int bridgeSize;
    InputView inputView = new InputView();
    public void setGame() {
        View.gameStartMessage();
        int retryCheckNumber = 1;

        while (retryCheckNumber != 0) {
            View.requestBridgeLengthMessage();
            try {
                InputView inputView = new InputView();
                bridgeSize = inputView.readBridgeSize();
                retryCheckNumber = 0;
            } catch (IllegalArgumentException e) {
                View.exceptionMessage(e);
                retryCheckNumber = 1;
            }
        }
    }

    /* 입력값만큼 다리를 만들고 랜덤값 넣기 */
    public void make() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {

        int retryCheckNumber = 1;

        while (retryCheckNumber != 0) {
            View.requestPickAPartOfBridgeMessage();
            try {
                String userInput = inputView.readMoving();
                retryCheckNumber = 0;
            } catch (IllegalArgumentException e) {
                View.exceptionMessage(e);
                retryCheckNumber = 1;
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
