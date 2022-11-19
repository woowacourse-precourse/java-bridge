package bridge.view;

import bridge.BridgeGameResult;
import bridge.BridgeMoveResult;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String BRIDGE_START = "[";
    private static final String BRIDGE_END = "]";
    private static final String BRIDGE_DIVIDE = "|";
    private static final String BLANK = " ";
    private static final String GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String GAME_RESULT = "최종 게임 결과";
    private static final String GAME_SUCCESS = "게임 성공 여부: ";
    private static final String GAME_TRY_COUNT = "총 시도한 횟수: ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public void printMap(BridgeGameResult gameResult) {
        BridgeMoveResult moveResult = gameResult.getMoveResult();
        System.out.println(format(moveResult.getUpStates()));
        System.out.println(format(moveResult.getDownStates()));
    }

    private String format(List<String> states) {
        StringBuilder result = new StringBuilder();

        result.append(BRIDGE_START);
        addState(states, result);
        result.append(BRIDGE_END);

        return result.toString();
    }

    private static void addState(List<String> states, StringBuilder result) {
        for (int count = 0; count < states.size(); count++) {
            String state = BLANK + states.get(count) + BLANK;
            if (count != 0) {
                result.append(BRIDGE_DIVIDE);
            }
            result.append(state);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     */
    public void printResult(BridgeGameResult gameResult) {
        System.out.println(separateLine() + GAME_RESULT);
        printMap(gameResult);
        System.out.println(separateLine() + GAME_SUCCESS + gameResult.getGameResult());
        System.out.println(GAME_TRY_COUNT + gameResult.getTryCount());
    }

    public void printGameStartMsg() {
        System.out.println(GAME_START);
    }

    public void printBridgeSizeMsg() {
        System.out.println(separateLine() + BRIDGE_SIZE);
    }

    public void printMovingMsg() {
        System.out.println(separateLine() + MOVING);
    }

    public void printGameCommandMsg() {
        System.out.println(separateLine() + GAME_COMMAND);
    }

    private String separateLine() {
        return System.lineSeparator();
    }
}
