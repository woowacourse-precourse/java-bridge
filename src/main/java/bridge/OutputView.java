package bridge;

import bridge.model.BridgeRoadMap;
import bridge.model.UserRoadMap;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String ROAD_SEPARATOR = "|";
    private final String[] ROAD_STATE = {"X", "O", " "};
    private final String[] GAME_RESULT_STATE = {"실패", "성공"};

    private final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";

    private final String INPUT_BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    private final String INPUT_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String INPUT_RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private final String GAME_RESULT_MESSAGE = "최종 게임 결과";
    private final String GAME_RESULT_SUCCESS_OR_NOT_MESSAGE = "게임 성공 여부:";
    private final String GAME_RESULT_TRIAL_COUNT_MESSAGE = "총 시도한 횟수:";

    private final String ERROR_KEYWORD = "[ERROR]";

    public void printGameStart(){
        // TODO: 게임 시작 메시지 출력
    }

    public void printInputBridgeLength(){
        // TODO: 다리 길이 입력 메시지 출력
    }

    public void printInputMove(){
        // TODO: 이동할 칸 입력 메시지 출력
    }

    public void printInputRetry(){
        // TODO: 게임 재시작 여부 입력 메시지 출력
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeRoadMap bridgeRoadMap, UserRoadMap userRoadMap) {
    }

    private void printDirectionRoadStateMap(String direction, BridgeRoadMap bridgeRoadMap, UserRoadMap userRoadMap) {
        // TODO: 위치하고 있는 방향(위, 아래)과 다리의 상태를 비교하여 형식에 맞게 출력
    }

    private void printRoadSeparation(int roadPosition) {
        // TODO: 칸 위치에 따른 구분자 출력
    }

    private void printOorX(int roadPosition, BridgeRoadMap bridgeRoadMap, UserRoadMap userRoadMap) {
        // TODO: 칸의 위치를 기준으로 정답과 해답을 비교하여 O, X 출력
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int trialCount, BridgeRoadMap bridgeRoadMap, UserRoadMap userRoadMap) {
    }

    private void printSuccessOrFail(BridgeRoadMap bridgeRoadMap, UserRoadMap userRoadMap) {
        // TODO: 정답과 해답을 비교해 성공 여부를 출력
    }

    public void printErrorMessage(String message){
        // TODO: 에러 메시지 출력
    }
}
