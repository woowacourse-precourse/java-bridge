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
    public String move() {
        String moving = new InputView().readMoving();
        bridgeForPrint = new BridgeStatusMaker().makeBridgeForPrint(bridge, moving, currentPosition);

        // 상태 출력
        outputView.printMap(bridgeForPrint);

        // 맞추기 실패 시 재시도
        if (!moving.equals(bridge.get(currentPosition))) {
            return retry();
        }
        // 정답 시 현재 위치 + 1
        currentPosition += 1;

        // 현재가 최고 기록이면 최고 기록 갱신
        if (currentPosition > bestRecordPosition) {
            bestRecordPosition = currentPosition;
        }

        // 정답을 전부 맞춘 상황일 시 게임 종료
        if (bestRecordPosition == bridge.size()) {
            outputView.printResult(bridgeForPrint, trialCount);
            return "GameOver";
        }
        return "Continue";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public String retry() {
        String gameCommand = new InputView().readGameCommand();
        if (gameCommand.equals("R")) {
            addTrialCount();
            initCurrentPosition();
            initBridgeForPrint();
            return "Retry";
        }
        // 최종 결과 출력
        outputView.printResult(bridgeForPrint, trialCount);
        return "GameOver";
    }

    private void addTrialCount() {
        this.trialCount += 1;
    }

    private void initCurrentPosition() {
        currentPosition = 0;
    }

    private void initBridgeForPrint() {
        bridgeForPrint = new ArrayDeque<>();
    }
}
