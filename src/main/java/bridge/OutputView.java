package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String REQUEST_LENGTH_OF_BRIDGE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String REQUEST_MOVE_AREA_MESSAGE = "이동할 칸을 선택해주세요. (위: %s, 아래: %s)";
    private static final String ASK_RESTART_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)";
    private static final String GAME_RESULT_MESSAGE = "최종 게임 결과";
    private static final String SUCCESS_OR_NOT_MESSAGE = "최종 성공 여부: %s";
    private static final String TOTAL_ATTEMPTS_MESSAGE = "총 시도한 횟수: %d";
    private static final String SUCCESS = "성공";
    private static final String FAILURE = "실패";
    private static final String UPPER_ROAD = "U";
    private static final String LOWER_ROAD = "D";
    private static final String RESTART_WORD = "R";
    private static final String QUIT_WORD = "Q";
    private static final String BLANK_WORD = " ";
    private static final String DELIMITER_WORD = " | ";
    private static final String START_OF_BRIDGE = "[ ";
    private static final String END_OF_BRIDGE = " ]";
    private static final String CORRECT_WORD = "O";
    private static final String NOT_CORRECT_WORD = "X";

    public void printStartMessage() {
        printMessage(START_MESSAGE);
    }

    public void printRequestLengthOfBridgeMessage() {
        printNewLine();
        printMessage(REQUEST_LENGTH_OF_BRIDGE_MESSAGE);
    }

    public void printRequestMoveAreaMessage() {
        printMessage(String.format(REQUEST_MOVE_AREA_MESSAGE, UPPER_ROAD, LOWER_ROAD));
    }

    public void printAskRestartGameMessage() {
        printMessage(String.format(ASK_RESTART_MESSAGE, RESTART_WORD, QUIT_WORD));
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int index, String currentAnswer, List<String> bridge) {
        printUpperRoad(index, currentAnswer, bridge);
        printNewLine();
        printLowerRoad(index, currentAnswer, bridge);
        printNewLine();
    }

    private void printUpperRoad(int index, String currentAnswer, List<String> bridge) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(START_OF_BRIDGE);
        stringBuilder.append(makePreviousBridge(index, bridge, UPPER_ROAD));
        stringBuilder.append(checkCurrentRoad(currentAnswer, UPPER_ROAD));
        stringBuilder.append(END_OF_BRIDGE);
        printMessage(stringBuilder.toString());
    }

    private void printLowerRoad(int index, String currentAnswer, List<String> bridge) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(START_OF_BRIDGE);
        stringBuilder.append(makePreviousBridge(index, bridge, LOWER_ROAD));
        stringBuilder.append(checkCurrentRoad(currentAnswer, LOWER_ROAD));
        stringBuilder.append(END_OF_BRIDGE);
        printMessage(stringBuilder.toString());
    }

    private String makePreviousBridge(int index, List<String> bridge, String location) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < index - 1; i++) {
            stringBuilder.append(checkPreviousRoad(bridge.get(i), location));
            stringBuilder.append(DELIMITER_WORD);
        }
        return stringBuilder.toString();
    }

    private String checkPreviousRoad(String correctBridge, String location) {
        if (correctBridge.equals(location)) {
            return CORRECT_WORD;
        }
        return BLANK_WORD;
    }

    private String checkCurrentRoad(String currentAnswer, String location) {
        if (currentAnswer.equals(location)) {
            return CORRECT_WORD;
        }
        return NOT_CORRECT_WORD;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String currentAnswer, List<String> bridge, int count) {
        printMessage(GAME_RESULT_MESSAGE);
        printMap(bridge.size() - 1, currentAnswer, bridge);
        printMessage(String.format(SUCCESS_OR_NOT_MESSAGE, checkGameResult(currentAnswer, bridge)));
        printMessage(String.format(TOTAL_ATTEMPTS_MESSAGE, count));
    }

    private String checkGameResult(String currentAnswer, List<String> bridge) {
        if (currentAnswer.equals(bridge.get(bridge.size() - 1))) {
            return SUCCESS;
        }
        return FAILURE;
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    private void printNewLine() {
        System.out.println();
    }
}
