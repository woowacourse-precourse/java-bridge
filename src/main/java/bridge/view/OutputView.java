package bridge.view;

import bridge.domain.BridgeGameResult;
import bridge.domain.BridgeMoveState;
import java.util.List;

public class OutputView {

    private static final String BRIDGE_START = "[ ";
    private static final String BRIDGE_END = " ]";
    private static final String BRIDGE_DIVIDE = " | ";
    private static final String GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String GAME_RESULT = "최종 게임 결과";
    private static final String GAME_SUCCESS = "게임 성공 여부: ";
    private static final String GAME_TRY_COUNT = "총 시도한 횟수: ";


    public void printGameStartMsg() {
        System.out.println(GAME_START + separateLine());
    }

    public void printBridgeSizeMsg() {
        System.out.println(BRIDGE_SIZE);
    }

    public void printMovingMsg() {
        System.out.println(MOVING);
    }

    public void printGameCommandMsg() {
        System.out.println(GAME_COMMAND);
    }

    public void print(String msg) {
        System.out.println(msg);
    }

    public void printResult(BridgeGameResult gameResult) {
        System.out.println(GAME_RESULT);
        printMap(gameResult);
        System.out.println(GAME_SUCCESS + gameResult.getResult());
        System.out.println(GAME_TRY_COUNT + gameResult.getTryCount());
    }

    public void printMap(BridgeGameResult gameResult) {
        BridgeMoveState moveState = gameResult.getMoveState();
        System.out.println(format(moveState.getUpState()));
        System.out.println(format(moveState.getDownState()) + separateLine());
    }

    private String format(List<String> state) {
        StringBuilder result = new StringBuilder();
        result.append(BRIDGE_START);
        addState(state, result);
        result.append(BRIDGE_END);
        return result.toString();
    }

    private static void addState(List<String> state, StringBuilder result) {
        for (int moveCount = 0; moveCount < state.size(); moveCount++) {
            if (moveCount != 0) {
                result.append(BRIDGE_DIVIDE);
            }
            result.append(state.get(moveCount));
        }
    }

    private String separateLine() {
        return System.lineSeparator();
    }
}
