package bridge.view;

import static bridge.view.message.PrintMessage.BRIDGE_FAIL;
import static bridge.view.message.PrintMessage.BRIDGE_SPACE;
import static bridge.view.message.PrintMessage.BRIDGE_SUCCESS;
import static bridge.view.message.PrintMessage.EMPTY;
import static bridge.view.message.PrintMessage.GAME_RESULT_MESSAGE;
import static bridge.view.message.PrintMessage.GAME_RESULT_SUCCESS_MESSAGE;
import static bridge.view.message.PrintMessage.GAME_RESULT_TRY_COUNT_MESSAGE;
import static bridge.view.message.PrintMessage.GAME_START_MESSAGE;
import static bridge.view.message.PrintMessage.INPUT_BRIDGE_LINE_MESSAGE;
import static bridge.view.message.PrintMessage.INPUT_BRIDGE_MOVE_MESSAGE;
import static bridge.view.message.PrintMessage.INPUT_GAME_RETRY_MESSAGE;
import static bridge.view.message.PrintMessage.PRINT_BRIDGE_END;
import static bridge.view.message.PrintMessage.PRINT_BRIDGE_SEPARATOR;
import static bridge.view.message.PrintMessage.PRINT_BRIDGE_START;

import bridge.model.BridgeStatus;
import bridge.model.GameResult;
import bridge.model.GameScore;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printInputBridgeLine() {
        System.out.println(INPUT_BRIDGE_LINE_MESSAGE);
    }

    public void printInputBridgeMove() {
        System.out.println(INPUT_BRIDGE_MOVE_MESSAGE);
    }

    public void printInputRetryGameStart() {
        System.out.println(INPUT_GAME_RETRY_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(GameScore gameScore) {
        GameResult nowResult = gameScore.getResult();
        List<String> bridge = gameScore.getBridge();
        String upBridge = getPrintBridge(bridge, BridgeStatus.UP, nowResult);
        String downBridge = getPrintBridge(bridge, BridgeStatus.DOWN, nowResult);
        System.out.println(PRINT_BRIDGE_START + upBridge + PRINT_BRIDGE_END);
        System.out.println(PRINT_BRIDGE_START + downBridge + PRINT_BRIDGE_END);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameScore gameScore) {
        System.out.println(GAME_RESULT_MESSAGE);
        printMap(gameScore);
        System.out.println(String.format(GAME_RESULT_SUCCESS_MESSAGE, gameScore.getResult().getStatus()));
        System.out.println(String.format(GAME_RESULT_TRY_COUNT_MESSAGE, gameScore.getCount()));
    }

    private String getPrintBridge(List<String> bridge, BridgeStatus bridgeStatus, GameResult result) {
        StringBuilder bridgeString = new StringBuilder();
        for (int i = 0; i < bridge.size(); i++) {
            String now = getTextByBridgeStatus(bridge.get(i), bridgeStatus.getCommand(), result.isSuccess());
            now += addSeparator(i, bridge.size());
            bridgeString.append(now);
        }
        return bridgeString.toString();
    }

    private String addSeparator(int index, int size) {
        if (index != size - 1) {
            return PRINT_BRIDGE_SEPARATOR;
        }
        return EMPTY;
    }

    private String getTextByBridgeStatus(String nowText, String bridgeStatus, boolean isSuccess) {
        if (!nowText.equals(bridgeStatus) && !isSuccess) {
            return BRIDGE_FAIL;
        }
        if (nowText.equals(bridgeStatus)) {
            return BRIDGE_SUCCESS;
        }
        return BRIDGE_SPACE;
    }
}
