package bridge.view;

import bridge.BridgeGame;
import bridge.model.BridgeGameResult;
import bridge.model.Player;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public final static String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    public final static String READ_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    public final static String READ_MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public final static String FINAL_GAME_RESULT_MESSAGE = "최종 게임 결과";
    public final static String READ_RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public final static String PLAYER_CLEARED_MESSAGE = "게임 성공 여부: ";
    public final static String PLAYER_TRIED_MESSAGE = "총 시도한 횟수: ";
    public final static String UPPER_BRIDGE_STRING = "U";
    public final static String LOWER_BRIDGE_STRING = "D";
    public final static String SPACE_STRING = "   ";
    public final static String DELIMITER_STRING = "|";

    private void printlnMessage(String message) {

        System.out.println(message);
    }

    private void printMessage(String message) {

        System.out.print(message);
    }

    public void printError(String error) {

        System.out.println(error);
    }

    public void printStart() {

        printlnMessage(GAME_START_MESSAGE);
    }

    public void printReadBridgeSize() {

        printlnMessage(READ_BRIDGE_SIZE_MESSAGE);
    }

    public void printReadMoving() {

        printlnMessage(READ_MOVING_MESSAGE);
    }

    public void printReadRetry() {

        printlnMessage(READ_RETRY_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        Player player = bridgeGame.getPlayer();
        List<String> upperBridge = bridgeGame.getBridge().getUpperBridge();
        List<String> lowerBridge = bridgeGame.getBridge().getLowerBridge();
        printUpperMap(upperBridge, player.getPlayerMoveList());
        printlnMessage("");
        printLowerMap(lowerBridge, player.getPlayerMoveList());
        printlnMessage("");
    }

    public void printUpperMap(List<String> upperBridge, List<String> playerMoveList) {
        printMessage("[");
        printMapLine(upperBridge, playerMoveList, UPPER_BRIDGE_STRING);
        printMessage("]");
    }

    public void printLowerMap(List<String> lowerBridge, List<String> playerMoveList) {
        printMessage("[");
        printMapLine(lowerBridge, playerMoveList, LOWER_BRIDGE_STRING);
        printMessage("]");

    }

    public void printMapLine(List<String> line, List<String> playerCmd, String lineString) {
        for (int i = 0; i < playerCmd.size(); i++) {
            if (playerCmd.get(i).equals(lineString)) {
                printMessage(" " + line.get(i) + " ");
            } else if (!playerCmd.get(i).equals(lineString)) {
                printMessage(SPACE_STRING);
            }
            if (i != playerCmd.size() - 1)
                printMessage(DELIMITER_STRING);
        }
    }


    public void printPlayerCleared(String cleared) {
        printMessage(PLAYER_CLEARED_MESSAGE);
        printlnMessage(cleared);
    }

    public void printPlayerTried(int tried) {
        printMessage(PLAYER_TRIED_MESSAGE);
        printlnMessage(String.valueOf(tried));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGameResult bridgeGameResult) {
        printlnMessage(FINAL_GAME_RESULT_MESSAGE);
        printPlayerCleared(bridgeGameResult.getCleared());
        printPlayerTried(bridgeGameResult.getTried());
    }


}
