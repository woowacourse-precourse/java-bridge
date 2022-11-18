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


        private String printSelectedStair(Player player, String stair) {
        if (!stair.equals(player.getLastSelection())) {
            return NOT_SELECTION;
        }

        if (!player.isAlive()) {
            return WRONG_SELECTION;
        }

        return RIGHT_SELECTION;
    }

    private String printPassedStair(List<String> bridgeStates, int passedCount, String stair) {
        String result = "";

        for (int bridgeLocation = 0; bridgeLocation < passedCount; bridgeLocation++) {
            String state = NOT_SELECTION;
            if (stair.equals(bridgeStates.get(bridgeLocation))) {
                state = RIGHT_SELECTION;
            }
            state += OutputValue.SEPARATOR;
            result += state;
        }

        return result;
    }

    private void printStair(List<String> bridgeStates, Player player, String stair) {
        String result;
        result = printPassedStair(bridgeStates, player.getNextLocation(), stair);
        result += printSelectedStair(player, stair);

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

    private String printIsSuccess(BridgeGame bridgeGame) {
        if (bridgeGame.isPlayerDead()) {
            return FAIL;
        }

        return SUCCESS;
    }

    private String printLastStair(BridgeGame bridgeGame, String stair) {
        List<String> bridgeStates = bridgeGame.getBridgeStates();
        String bridgeState = bridgeStates.get(bridgeGame.getMaxPassedCount());

        if (!bridgeState.equals(stair)) {
            return NOT_SELECTION;
        }

        if (bridgeGame.isPlayerDead()) {
            return WRONG_SELECTION;
        }

        return RIGHT_SELECTION;
    }

    private void printResultStair(BridgeGame bridgeGame, String stair) {
        String result;
        result = printPassedStair(bridgeGame.getBridgeStates(), bridgeGame.getMaxPassedCount(), stair);
        result += printLastStair(bridgeGame, stair);

        System.out.printf(BRIDGE_MAP, result);
    }

    public void printResult(BridgeGame bridgeGame) {
        System.out.println(RESULT_MESSAGE);

        printResultStair(bridgeGame, SELECTION_UP);
        printResultStair(bridgeGame, SELECTION_DOWN);

        System.out.printf(IS_SUCCESS, printIsSuccess(bridgeGame));
        System.out.printf(RETRY_COUNT, bridgeGame.getRetryCount());
    }
}
