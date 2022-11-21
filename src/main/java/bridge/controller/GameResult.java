package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.UserMovement;
import bridge.domain.UserPath;
import bridge.view.OutputView;

import java.util.Arrays;
import java.util.List;

import static bridge.util.JudgementUtil.whetherUserWinMessage;

/**
 * 게임 결과를 출력하는 역할을 한다.
 */
public class GameResult {
    private final static OutputView outputView = new OutputView();

    /**
     * 게임 결과를 처리한다.
     *
     * @param userMovement user 움직임 정보
     * @param bridge       bridge 정보
     * @param tryCnt       시도 횟수
     */
    public static void gameResult(UserMovement userMovement, Bridge bridge, int tryCnt) {
        List<List<String>> bothCellResult = Arrays.asList(
                UserPath.getUpperCellResult(userMovement, bridge)
                , UserPath.getLowerCellResult(userMovement, bridge)
        );
        outputView.printResult(bothCellResult, tryCnt, whetherUserWinMessage(userMovement, bridge));
    }
}
