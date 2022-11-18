package bridge;

import bridge.constant.command.DirectionCommand;
import bridge.model.BridgeRoadMap;
import bridge.model.UserRoadMap;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String ROAD_SEPARATOR = "|";
    private final String[] ROAD_STATE = {" X ", " O ", "   "};
    private final String[] GAME_RESULT_STATE = {"실패", "성공"};

    private final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";

    private final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private final String INPUT_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String INPUT_RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private final String GAME_RESULT_MESSAGE = "최종 게임 결과";
    private final String GAME_RESULT_SUCCESS_OR_NOT_MESSAGE = "게임 성공 여부:";
    private final String GAME_RESULT_TRIAL_COUNT_MESSAGE = "총 시도한 횟수:";

    private final String ERROR_KEYWORD = "[ERROR]";

    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE + "\n");
    }

    public void printInputBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
    }

    public void printInputMove() {
        System.out.println(INPUT_MOVE_MESSAGE);
    }

    public void printInputRetry() {
        System.out.println(INPUT_RETRY_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeRoadMap bridgeRoadMap, UserRoadMap userRoadMap) {
        DirectionCommand[] directionCommands = DirectionCommand.values();
        for (int index = directionCommands.length - 1; index >= 0; index--) {
            System.out.printf("[");
            printDirectionRoadStateMap(directionCommands[index].getValue(), bridgeRoadMap, userRoadMap);
            System.out.println("]");
        }
        System.out.println();
    }

    private void printDirectionRoadStateMap(String direction, BridgeRoadMap bridgeRoadMap, UserRoadMap userRoadMap) {
        for (int roadPosition = 0; roadPosition < userRoadMap.getSize(); roadPosition++) {
            printRoadSeparation(roadPosition);
            if (userRoadMap.matchPositionWithDirection(roadPosition, direction)) {
                printOorX(roadPosition, bridgeRoadMap, userRoadMap);
                continue;
            }
            System.out.printf(ROAD_STATE[2]);
        }
    }

    private void printRoadSeparation(int roadPosition) {
        if (roadPosition != 0) {
            System.out.printf(ROAD_SEPARATOR);
        }
    }

    private void printOorX(int roadPosition, BridgeRoadMap bridgeRoadMap, UserRoadMap userRoadMap) {
        String result = ROAD_STATE[0];
        if (bridgeRoadMap.matchPositionWithRoad(roadPosition, userRoadMap.getRoad(roadPosition))) {
            result = ROAD_STATE[1];
        }
        System.out.printf(result);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int trialCount, BridgeRoadMap bridgeRoadMap, UserRoadMap userRoadMap) {
        System.out.println(GAME_RESULT_MESSAGE);
        printMap(bridgeRoadMap, userRoadMap);
        printSuccessOrFail(bridgeRoadMap, userRoadMap);
        System.out.println(String.format("%s %d", GAME_RESULT_TRIAL_COUNT_MESSAGE, trialCount));
    }

    private void printSuccessOrFail(BridgeRoadMap bridgeRoadMap, UserRoadMap userRoadMap) {
        String result = GAME_RESULT_STATE[0];
        if (!bridgeRoadMap.isFail(userRoadMap)) {
            result = GAME_RESULT_STATE[1];
        }
        System.out.println(String.format("%s %s", GAME_RESULT_SUCCESS_OR_NOT_MESSAGE, result));
    }

    public void printErrorMessage(String message) {
        System.out.println(String.format("%s %s", ERROR_KEYWORD, message));
    }

    public void printNextLine() {
        System.out.println();
    }
}
