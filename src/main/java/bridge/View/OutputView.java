package bridge.View;

import bridge.Controller.BridgeGame;
import bridge.Model.Player;
import bridge.Constant.InputValue;
import bridge.Constant.OutputMessage;
import bridge.Constant.OutputValue;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
        private String printSelectedStair(Player player, String stair) {
        if (!stair.equals(player.getLastSelection())) {
            return OutputValue.NOT_SELECTION;
        }

        if (!player.isAlive()) {
            return OutputValue.WRONG_SELECTION;
        }

        return OutputValue.RIGHT_SELECTION;
    }

    private String printPassedStair(List<String> bridgeStates, int passedCount, String stair) {
        String result = "";

        for (int bridgeLocation = 0; bridgeLocation < passedCount; bridgeLocation++) {
            String state = OutputValue.NOT_SELECTION;
            if (stair.equals(bridgeStates.get(bridgeLocation))) {
                state = OutputValue.RIGHT_SELECTION;
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

        System.out.printf(OutputMessage.BRIDGE_MAP, result);
    }

    public void printMap(BridgeGame bridgeGame) {
        List<String> bridgeState = bridgeGame.getBridgeStates();
        Player player = bridgeGame.getPlayer();

        printStair(bridgeState, player, InputValue.SELECTION_UP);
        printStair(bridgeState, player, InputValue.SELECTION_DOWN);
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    private String printIsSuccess(BridgeGame bridgeGame) {
        if (bridgeGame.isPlayerDead()) {
            return OutputValue.FAIL;
        }

        return OutputValue.SUCCESS;
    }

    private String printLastStair(BridgeGame bridgeGame, String stair) {
        List<String> bridgeStates = bridgeGame.getBridgeStates();
        String bridgeState = bridgeStates.get(bridgeGame.getMaxPassedCount());

        if (!bridgeState.equals(stair)) {
            return OutputValue.NOT_SELECTION;
        }

        if (bridgeGame.isPlayerDead()) {
            return OutputValue.WRONG_SELECTION;
        }

        return OutputValue.RIGHT_SELECTION;
    }

    private void printResultStair(BridgeGame bridgeGame, String stair) {
        String result;
        result = printPassedStair(bridgeGame.getBridgeStates(), bridgeGame.getMaxPassedCount(), stair);
        result += printLastStair(bridgeGame, stair);

        System.out.printf(OutputMessage.BRIDGE_MAP, result);
    }

    public void printResult(BridgeGame bridgeGame) {
        System.out.println(OutputMessage.RESULT_MESSAGE);

        printResultStair(bridgeGame, InputValue.SELECTION_UP);
        printResultStair(bridgeGame, InputValue.SELECTION_DOWN);

        System.out.printf(OutputMessage.IS_SUCCESS, printIsSuccess(bridgeGame));
        System.out.printf(OutputMessage.RETRY_COUNT, bridgeGame.getRetryCount());
    }
}
