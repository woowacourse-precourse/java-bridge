package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private MovingProcessing movingProcessing;
    private final RetryProcessing retryProcessing;
    private int count;

    public BridgeGame() {
        retryProcessing = new RetryProcessing();
        count = 1;
    }

    public void start() {
        boolean doRetry = true;
        while (doRetry) {
            movingProcessing = new MovingProcessing();
            if (movingProcessing.readMove()) {
                break;
            }
            doRetry = retry();
            count++;
        }
        endGame();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        movingProcessing.readMove();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        boolean doRetry = retryProcessing.readRetry();

        return doRetry;
    }

    //여기서 upSide와 downSide를 더해서 출력 하게끔 하자
    public void endGame() {
        List<String> upSide = movingProcessing.getUpSide();
        List<String> downSide = movingProcessing.getDownSide();
        retryProcessing.printResult(upSide, downSide, count);
    }
}
