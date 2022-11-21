package bridge.view;

import bridge.model.Bridge;
import bridge.model.BridgeStatus;
import bridge.model.GameResult;
import bridge.model.GameScore;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String INPUT_BRIDGE_LINE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_BRIDGE_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_GAME_RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private static final String GAME_RESULT_MESSAGE = "최종 게임 결과";
    private static final String GAME_RESULT_SUCCESS_MESSAGE = "게임 성공 여부: %s";
    private static final String GAME_RESULT_TRY_COUNT_MESSAGE = "총 시도한 횟수: %d";
    private static final String PRINT_BRIDGE_START = "[ ";
    private static final String PRINT_BRIDGE_END = " ]";
    private static final String PRINT_BRIDGE_SEPARATOR = " | ";

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
        return "";
    }

    private String getTextByBridgeStatus(String nowText, String bridgeStatus, boolean isSuccess) {
        if (!nowText.equals(bridgeStatus) && !isSuccess) {
            return "X";
        }
        if (nowText.equals(bridgeStatus)) {
            return "O";
        }
        return " ";
    }
}
