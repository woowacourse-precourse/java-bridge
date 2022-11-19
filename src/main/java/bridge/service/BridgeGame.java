package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.User;
import bridge.view.OutputView;

public class BridgeGame {

    private final InputService inputService = new InputService();
    private final OutputView outputView = new OutputView();

    public void gameStart(Bridge bridge, User user) {
        while (!user.isGameDoneStatus()) {
            move(bridge, user);
        }
        outputView.printResult(user);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Bridge bridge, User user) {
        String moveDirection = inputService.requestMove();
        if (moveDirection.equals(bridge.getBridge().get(bridge.getNowIndex()))) {
            // 맞춘 경우
            outputView.printMap(bridge.getNowIndex(), moveDirection, true);
            if (bridge.getNowIndex() == bridge.getBridgeSize() - 1) {
                // 전부 다 맞춘 경우
                user.gameDoneSuccess();
                user.gameSuccess();
            }
            bridge.nowIndexUpdate();
            return;
        } else {
            // 틀린 경우
            outputView.printMap(bridge.getNowIndex(), moveDirection, false);
            String command = inputService.requestStatusOfGame();
            if (command.equals("R")) {
                // 재시도
                retry(bridge, user);
                return;
            } else {
                // 종료
                user.gameDoneSuccess();
                user.gameFail();
                return;
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(Bridge bridge, User user) {
        outputView.initMapView();
        bridge.resetGame();
        user.gameRetry();
    }
}
