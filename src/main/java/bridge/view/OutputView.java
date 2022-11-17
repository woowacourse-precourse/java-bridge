package bridge.view;

import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String MAP_START = "[ ";
    private static final String MAP_SEPARATOR = " | ";
    private static final String MAP_END = " ]";

    private static final String GUIDE_START = "다리 건너기 게임을 시작합니다.";
    private static final String GUIDE_INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String GUIDE_INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GUIDE_INPUT_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private static final String FINAL_GAME_RESULT = "최종 게임 결과";
    private static final String SUCCESS_OR_NOT = "게임 성공 여부: ";
    private static final String NUMBER_OF_ATTEMPTS = "총 시도한 횟수: ";


    public void guideStart() {
        System.out.println(GUIDE_START);
    }
    public void guideInputBridgeSize() {
        System.out.println(GUIDE_INPUT_BRIDGE_SIZE);
    }
    public void guideInputMoving() {
        System.out.println(GUIDE_INPUT_MOVING);
    }
    //더 좋은 방법 있는지 확인
    public void printMap(String currentMap) {
        System.out.println(currentMap);
    }
    public void guideInputGameCommand() {
        System.out.println(GUIDE_INPUT_GAME_COMMAND);
    }

    public void printResult(String currentMap, int numberOfAttempts, String outcome) {
        System.out.println(FINAL_GAME_RESULT);
        System.out.println(currentMap);
        System.out.println(SUCCESS_OR_NOT + numberOfAttempts);
        System.out.println(NUMBER_OF_ATTEMPTS + outcome);
    }
}
