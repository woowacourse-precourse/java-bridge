package bridge.controller;

import bridge.domain.JudgeDestination;
import bridge.domain.BridgePrinting;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {


    private List<String> moving = new ArrayList<>();
    private List<Boolean> upState = new ArrayList<>();
    private List<Boolean> downState = new ArrayList<>();
    private OutputView outputView = new OutputView();
    static final int UP = 1;
    static final int DOWN = 0;
    JudgeDestination judgeDestination = new JudgeDestination();
    private int count = 1;
    private static int idx = 0;
    private InputView inputView = new InputView();


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void start(List<String> bridgeState, int bridgeSize) {
        move(bridgeState, bridgeSize);
        afterMove(bridgeState, bridgeSize);
    }

    public void move(List<String> bridgeState, int bridgeSize) {
        clearInfo();
        while (idx < bridgeSize && !BridgePrinting.isMoveStop()) {
            System.out.println("bridgeState = " + bridgeState); // 출력시 어디가 갈 수 있는 칸인지 확인하기 위한 역할
            moving.add(inputView.readMoving());
            setPrintState(upState, downState, convertNowIndex(bridgeState.get(idx)));
            makeBridgeMap(upState, downState, moving.get(idx));
            idx++;
        }
    }

    public void clearInfo() {
        moving.clear();
        upState.clear();
        downState.clear();
        idx = 0;
        BridgePrinting.clearUpDownLocation();
    }

    private void makeBridgeMap(List<Boolean> upState  , List<Boolean> downState,
        String nowIndex) {
        BridgePrinting bridgePrinting = new BridgePrinting(upState, downState, convertNowIndex(nowIndex));
        bridgePrinting.makeList();
    }

    private int convertNowIndex(String nowIndex) {
        if (nowIndex.equals("U")) {
            return UP;
        }
        return DOWN;
    }

    private void setPrintState(List<Boolean> upState, List<Boolean> downState, int upDown) {
        if (upDown == UP) {
            upState.add(true);
            downState.add(false);
        }
        if (upDown == DOWN) {
            upState.add(false);
            downState.add(true);
        }
    }

    public void afterMove(List<String> bridgeState, int bridgeSize) {
        if (isReachFinal(bridgeSize)) {
            return;
        }
        if (judgementRetry()) {
            retry(bridgeSize, bridgeState);
            return;
        }
        setQuit(bridgeSize);
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(int bridgeSize,
        List<String> bridgeState) { // 수정 부분 체크 retry 는 조금 별로 더 수정해야할 거 같음 retry말고 이전 작업에서처리
        count++;
        BridgePrinting.initRestart();
        start(bridgeState, bridgeSize);
        return;
    }


    private boolean isReachFinal(int bridgeSize) {
        if (!BridgePrinting.isMoveStop()) {
            setQuit(bridgeSize);
            return true;
        }
        return false;
    }

    private boolean judgementRetry() {
        return judgeDestination.judgeRestartOrOver(inputView.readGameCommand());
    }

    private void setQuit(int bridgeSize) {
        int nowIndex = convertNowIndex(moving.get(idx - 1));
        BridgePrinting resultBridgePrinting = new BridgePrinting(upState, downState, nowIndex);
        if (bridgeSize == idx && !BridgePrinting.isMoveStop()) {
            outputView.printResult(count, resultBridgePrinting, true);
            return;
        }
        outputView.printResult(count, resultBridgePrinting, false);
    }

}
