package bridge.View;

import static bridge.Constant.InputValue.SELECTION_DOWN;
import static bridge.Constant.InputValue.SELECTION_UP;

import static bridge.Constant.OutputValue.*;

import bridge.Domain.BridgeGame;
import bridge.Domain.Player;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String RESULT_MESSAGE = "최종 게임 결과";
    private static final String BRIDGE_MAP = "[%s]" + System.lineSeparator();
    private static final String IS_SUCCESS = "게임 성공 여부: %s" + System.lineSeparator();
    private static final String RETRY_COUNT = "총 시도한 횟수: %d" + System.lineSeparator();


    private String getSelectResult(Player player, String stair) {
        if (!stair.equals(player.getSelection())) {
            return NOT_SELECTION;
        }

        if (!player.isAlive()) {
            return WRONG_SELECTION;
        }

        return RIGHT_SELECTION;
    }

    private String getIsPassedStair(String bridgeState, String stair) {
        if (bridgeState.equals(stair)) {
            return RIGHT_SELECTION;
        }

        return NOT_SELECTION;
    }


    private String getPassedStair(List<String> bridgeStates, int passedCount, String stair) {
        String result = "";

        for (int bridgeLocation = 0; bridgeLocation < passedCount; bridgeLocation++) {
            String bridgeState = bridgeStates.get(bridgeLocation);

            result += getIsPassedStair(bridgeState, stair);
            result += SEPARATOR;
        }

        return result;
    }

    private void printStair(List<String> bridgeStates, Player player, String stair) {
        String result;
        int passedCount = player.getPassedCount();

        result = getPassedStair(bridgeStates, passedCount, stair);
        result += getSelectResult(player, stair);

        System.out.printf(BRIDGE_MAP, result);
    }

    public void printMap(BridgeGame bridgeGame) {
        List<String> bridgeState = bridgeGame.getBridgeStates();
        Player player = bridgeGame.getPlayer();

        printStair(bridgeState, player, SELECTION_UP);
        printStair(bridgeState, player, SELECTION_DOWN);
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    private String getIsSuccess(BridgeGame bridgeGame) {
        if (bridgeGame.isPlayerDead()) {
            return FAIL;
        }

        return SUCCESS;
    }

    private String getLastSelectResult(BridgeGame bridgeGame, String stair) {
        List<String> bridgeStates = bridgeGame.getBridgeStates();
        String bridgeState = bridgeStates.get(bridgeGame.getMaxPassedCount());

        if (bridgeGame.winGame() && bridgeState.equals(stair)) {
            return RIGHT_SELECTION;
        }

        if (bridgeGame.isPlayerDead() && !bridgeState.equals(stair)) {   // 옳지 않은 발판을 선택해서 죽었기 때문에 해당 위치에 X 출력
            return WRONG_SELECTION;
        }

        return NOT_SELECTION;
    }

    private void printResultStair(BridgeGame bridgeGame, String stair) {
        List<String> bridgeStates = bridgeGame.getBridgeStates();
        int passedCount = bridgeGame.getMaxPassedCount();

        String result = getPassedStair(bridgeStates, passedCount, stair);
        result += getLastSelectResult(bridgeGame, stair);

        System.out.printf(BRIDGE_MAP, result);
    }

    public void printResult(BridgeGame bridgeGame) {
        System.out.println(RESULT_MESSAGE);

        printResultStair(bridgeGame, SELECTION_UP);
        printResultStair(bridgeGame, SELECTION_DOWN);

        System.out.printf(IS_SUCCESS, getIsSuccess(bridgeGame));
        System.out.printf(RETRY_COUNT, bridgeGame.getRetryCount());
    }
}
