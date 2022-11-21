package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private MovingProcessing movingProcessing;
    private final RetryProcessing retryProcessing;
    private final int count;

    public BridgeGame() {
        retryProcessing = new RetryProcessing();
        count = 1;
    }


    //여기서 upSide와 downSide를 더해서 출력 하게끔 하자
    public void endGame() {
        List<String> upSide = movingProcessing.getUpSide();
        List<String> downSide = movingProcessing.getDownSide();
        retryProcessing.printResult(upSide, downSide, count);
    }
}
