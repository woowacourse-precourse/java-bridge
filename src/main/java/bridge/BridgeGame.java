package bridge;

import java.util.ArrayDeque;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final OutputView outputView;
    private final List<String> bridge;
    private ArrayDeque<String> bridgeForPrint;
    private int bestRecordPosition;
    private int currentPosition;
    private int trialCount;

    public BridgeGame(List<String> bridge) {
        bridgeForPrint = new ArrayDeque<>();
        this.bridge = bridge;
        outputView = new OutputView();
        bestRecordPosition = currentPosition = 0;
        trialCount = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public void move() {
        String moving = new InputView().readMoving();
        makeBridgeForPrint(moving);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry() {
    }

    private void addTrialCount() {
        this.trialCount += 1;
    }

    // 출력용 다리 상태 메시지 생성 : 사용자 입력이 정답 시 O를, 정답 실패 시 X를 메시지 마지막 부분에 삽입
    private void makeBridgeForPrint(String moving) {
        if (!bridgeForPrint.isEmpty()) {
            String lastPosition = bridgeForPrint.getLast().substring(0,1);
            bridgeForPrint.removeLast();
            bridgeForPrint.add(lastPosition);
        }
        if (moving.equals(bridge.get(currentPosition))) {
            bridgeForPrint.add(moving + "O");
            return;
        }
        bridgeForPrint.add(moving + "X");
    }
}
