package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.UserMovement;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;

public class GameRun {
    private final static BridgeGame bridgeGame = new BridgeGame();
    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();

    /**
     * user의 이동과 bridge game을 계속 진행하는 메인 로직이다.
     *
     * @param bridge 다리 정보
     * @return retryCnt bridge game 재개 횟수
     */
    public static int gameRun(Bridge bridge) {
        int retryCnt = -1;
        do {
            retryCnt = bridgeGame.retry(retryCnt);
            while (repeatUserMovement(bridge)) {
                userMove();
                outputView.printMap(new ArrayList<>(), new ArrayList<>());
            }
        } while (gameContinue(bridge));
        return retryCnt;
    }

    /**
     * user가 이동할 칸을 입력받는다.
     */
    private static void userMove() {
        while (true) {
            try {
                bridgeGame.move(inputView.readMoving());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * user가 계속 이동할 수 있는지 알려준다.
     *
     * @param bridge 다리 정보
     * @return user가 계속 이동할 수 있는지 여부
     */
    private static boolean repeatUserMovement(Bridge bridge) {
        return Judgement.judgeUserMovement(bridge.compareWithUserMovement(UserMovement.getUserMovement()))
                && !bridge.atTheEndOfBridge(UserMovement.getUserMovement());
    }

    /**
     * bridge game을 재개할지 알려준다.
     *
     * @return bridge game 재개 여부
     */
    private static boolean gameContinue(Bridge bridge) {
        if (Judgement.judgeUserMovement(bridge.compareWithUserMovement(UserMovement.getUserMovement()))) {
            return false;
        }
        while (true) {
            try {
                return inputView.readGameCommand().equals("R");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
