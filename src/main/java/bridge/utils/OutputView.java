package bridge.utils;

import bridge.domain.GameInfo;
import constants.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printResult(String bridgeMessage, GameInfo gameInfo) {
        System.out.println(Messages.SHOW_GAME_RESERT);
        printMap(bridgeMessage);
        if (gameInfo.getSuccessOrFail()) {
            System.out.println(Messages.SUCCESS_GAME);
            System.out.println(Messages.TOTAL_TRIES + gameInfo.getTrialCount());
            return;
        }
        System.out.println(Messages.FAIL_GAME);
        System.out.println(Messages.TOTAL_TRIES + gameInfo.getTrialCount());
    }

    public void printMap(String bridgeMessage) {
        System.out.println(bridgeMessage);
    }
}
