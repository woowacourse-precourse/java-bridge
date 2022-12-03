package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.UserMovement;
import bridge.domain.UserPath;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.util.JudgementUtil.whetherToContinueGame;
import static bridge.util.JudgementUtil.whetherToRepeatMovingUser;

/**
 * 게임을 실행한다. 유저가 이동하고, 없는 칸으로 이동할 경우 게임을 계속할지 물어본다.
 */
public class GameRun {
    private final static BridgeGame bridgeGame = new BridgeGame();
    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();

    /**
     * 게임을 계속 진행하는 메인 로직이다.
     * 유저가 이동한다. 없는 칸으로 이동하면 게임을 멈춘다.
     * 계속 게임을 진행할지 결정한다.
     *
     * @param userMovement 유저 이동 정보
     * @param bridge       다리 정보
     * @return 게임 진행 횟수
     */
    public static int gameRun(UserMovement userMovement, Bridge bridge, int tryCnt) {
        do {
            tryCnt = bridgeGame.retry(userMovement, tryCnt);
            while (whetherToRepeatMovingUser(userMovement, bridge)) {
                moveUser(userMovement);
                printUserMovement(userMovement, bridge);
            }
        } while (whetherToContinueGame(userMovement, bridge));
        return tryCnt;
    }

    /**
     * 유저가 이동 방향을 입력받고 이동한다.
     *
     * @param userMovement 유저 이동 정보
     */
    private static void moveUser(UserMovement userMovement) {
        while (true) {
            try {
                bridgeGame.move(userMovement, inputView.readMoving());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 유저의 이동 정보를 출력한다.
     *
     * @param userMovement 유저 이동 정보
     * @param bridge       다리 정보
     */
    private static void printUserMovement(UserMovement userMovement, Bridge bridge) {
        UserPath userPath = new UserPath(userMovement, bridge);
        outputView.printMap(userPath.getUpperPath(), userPath.getLowerPath());
    }
}
