package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final static String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다";
    private final static String BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private final static String MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final static String GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q";
    private final static String ERROR = "[ERROR] ";
    private final static String GAME_RESULT_MESSAGE = "최종 게임 결과";
    private final static String GAME_STATUS_MESSAGE = "게임 성공 여부: ";
    private final static String GAME_TRY_COUNT_MESSAGE = "총 시도한 횟수: ";

    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printBridgeSize() {
        System.out.println(BRIDGE_SIZE_MESSAGE);
    }

    public void printMoving() {
        System.out.println(MOVING_MESSAGE);
    }

    public void printGameCommand() {
        System.out.println(GAME_COMMAND_MESSAGE);
    }

    public void printError(String errMsg) {
        System.out.println(ERROR + errMsg);
    }

    public void printCrossResult(List<String> upBridgeResult, List<String> downBridgeResult) {
        printMap(upBridgeResult);
        printMap(downBridgeResult);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridgeResult) {
        String currentBridgeResult = "[ ";
        for (int i = 0; i < bridgeResult.size(); i++) {
            if (i == bridgeResult.size() - 1) {
                currentBridgeResult += bridgeResult.get(i) + " ]";
            }
            if (i != bridgeResult.size() - 1) {
                currentBridgeResult += bridgeResult.get(i) + " | ";
            }
        }
        System.out.println(currentBridgeResult);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> upBridgeResult, List<String> downBridgeResult) {
        System.out.println(GAME_RESULT_MESSAGE);
        printCrossResult(upBridgeResult, downBridgeResult);
        System.out.println();
    }

    public void printGameResult(String gameStatus, int cnt) {
        System.out.println(GAME_STATUS_MESSAGE + gameStatus);
        System.out.println(GAME_TRY_COUNT_MESSAGE + cnt);
    }
}
