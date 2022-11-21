package bridge.domain;

import bridge.ui.InputView;
import bridge.ui.OutputView;

import java.util.ArrayList;
import java.util.List;

/**
 * 유저의 상태 및 이동을 책임지는 클래스
 */
public class User {

    private List<String> route = new ArrayList<>();
    private int attemptNum = 1;
    private int location = -1;
    private Status status = Status.DOING;
    private final Bridge bridge;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public User(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridge = new Bridge(inputView.readBridgeSize(), bridgeNumberGenerator);
    }

    /**
     * 사용자가 이동할 때 가장 상단에서 불리는 함수
     *
     * @return 사용자가 이동할 수 있으면 true 없으면 flase를 반환한다.
     */
    public boolean move() {
        String goal = inputView.readMoving();
        if (moveNext(goal)) {
            outputView.printMap(route, true);
            isCrossBridge();
            return true;
        }
        outputView.printMap(route, false);
        return false;
    }

    /**
     * @param goal 사용자가 다음으로 이동할 다리
     * @return 업데이트된 사용자의 위치와 목적지를 통해 다리를 건널 수 있으면 true 아니면 false를 반환한다.
     */
    private boolean moveNext(String goal) {
        this.location += 1;
        this.route.add(goal);
        return bridge.isCanCross(location, goal);
    }

    /**
     * 재시작을 위한 입력을 받고 알맞게 분기 처리 해준다.
     */
    public void retry() {
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals("R")) {
            reinitialize();
            return;
        }
        status = Status.FAILED_END;
    }

    /**
     * 사용자가 재시작을 원할 때 재시작을 위한 변수들을 초기화한다.
     */
    private void reinitialize() {
        location = -1;
        route = new ArrayList<>();
        attemptNum += 1;
    }

    /**
     * 사용자 위치를 통해 사용자가 다리를 다 건넌 상태라면 상태를 업데이트한다.
     */
    private void isCrossBridge() {
        if (location == bridge.size() - 1) {
            status = Status.SUCCESS_END;
        }
    }

    /**
     * @return 사용자의 현재 상태를 통해 게임이 종료되었으면 최종 종료 문구를 출력하고 true를 반환하고, 아니면 false를 반환한다.
     */
    public boolean isEnd() {
        if (status == Status.SUCCESS_END) {
            outputView.printResult(route, true, attemptNum);
            return true;
        }
        if (status == Status.FAILED_END) {
            outputView.printResult(route, false, attemptNum);
            return true;
        }
        return false;
    }

}
