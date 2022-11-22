package bridge;

import bridge.InputView;
/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int bridgeSize;
    private int curPosition;
    private boolean continueFlag = true;

    public void run() {
        bridgeSize = InputView.readBridgeSize();
        curPosition = 0;

        while(continueFlag) {
            move();
            curPosition++;

            if(curPosition == bridgeSize)
                retry();
        }
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public void move() {
        String move = InputView.readMoving();
        curPosition++;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry() {
        String command = InputView.readGameCommand();

        if(command.equals("Q")) {
            curPosition = 0;
            continueFlag = false;
        }
    }
}
