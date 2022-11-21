package bridge.util;

import bridge.domain.Bridge;
import bridge.domain.UserMovement;
import bridge.enums.OutputMessage;
import bridge.view.InputView;

import java.util.List;

public class Judgement {
    private final static InputView inputView = new InputView();

    /**
     * 유저가 계속 이동할 수 있는지 알려준다.
     * 이동한 적이 없거나, 직전에 존재하는 칸으로 이동하고, 다리를 건너지 않은 경우 계속 이동할 수 있다.
     *
     * @param userMovement 유저 이동 정보
     * @param bridge       다리 정보
     * @return 유저가 계속 이동할 수 있는지 여부
     */
    public static Boolean whetherToRepeatMovingUser(UserMovement userMovement, Bridge bridge) {
        return whetherKeepMoving(userMovement, bridge) && !whetherCrossedBridge(userMovement, bridge);
    }

    /**
     * 게임을 재개할지 알려준다.
     * 다리를 다 건너지 않았다면, R을 입력한 경우 게임을 재개, Q를 입력한 경우 게임을 멈춘다.
     *
     * @param userMovement 유저 이동 정보
     * @param bridge       다리 정보
     * @return 게임을 재개하는가?
     */
    public static Boolean whetherToContinueGame(UserMovement userMovement, Bridge bridge) {
        while (!whetherCrossedBridge(userMovement, bridge)) {
            try {
                return inputView.readGameCommand().equals("R");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    /**
     * 유저가 계속 이동하는지 알려준다. 이동한 적 없거나, 직전에 유효한 칸으로 이동했다면 계속 이동한다.
     *
     * @param userMovement 유저 이동 정보
     * @param bridge       다리 정보
     * @return 계속 이동하는가?
     */
    public static Boolean whetherKeepMoving(UserMovement userMovement, Bridge bridge) {
        if (userMovement.getUserMovement().size() == 0) {
            return true;
        }
        return whetherMovedToExistingCell(userMovement, bridge);
    }

    /**
     * 다리를 다 건넜는지 판정한다.
     *
     * @param userMovement 유저 이동 정보
     * @param bridge       다리 정보
     * @return 다리를 건넜나? (true/false)
     */
    public static Boolean whetherCrossedBridge(UserMovement userMovement, Bridge bridge) {
        return bridge.whetherAtTheEndOfBridge(userMovement.getUserMovement())
                && whetherMovedToExistingCell(userMovement, bridge);
    }

    /**
     * 유저가 직전에 이동한 칸이 존재하는가
     *
     * @param userMovement 유저 이동 정보
     * @param bridge       다리 정보
     * @return 유저가 직전에 이동한 칸이 존재하는가?
     */
    public static Boolean whetherMovedToExistingCell(UserMovement userMovement, Bridge bridge) {
        List<Boolean> compareResult = bridge.compareWithUserMovement(userMovement.getUserMovement());
        return compareResult.get(compareResult.size() - 1);
    }

    /**
     * 게임 성공/실패 여부를 판정하고 결과를 반환한다.
     *
     * @param bridge 다리에 대한 정보
     * @return "성공" 또는 "실패"
     */
    public static String whetherUserWinMessage(UserMovement userMovement, Bridge bridge) {
        if (bridge.whetherMoveToExitingCell(userMovement.getUserMovement())) {
            return OutputMessage.GAME_SUCCESS_MESSAGE.getMessage();
        }
        return OutputMessage.GAME_FAIL_MESSAGE.getMessage();
    }
}
