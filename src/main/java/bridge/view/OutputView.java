package bridge.view;

import bridge.domain.BridgeGameResult;
import java.util.List;

public class OutputView {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String MOVE = "O";
    private static final String STOP = "X";
    private static final String BLANK = " ";
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

    private StringBuilder upMap;
    private StringBuilder downMap;

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

    public void printResult(List<String> bridge, BridgeGameResult gameResult) {
        System.out.println(GAME_RESULT);
        printMap(bridge, gameResult.getMoveState());
        System.out.println(GAME_SUCCESS + gameResult.getResult());
        System.out.println(GAME_TRY_COUNT + gameResult.getTryCount());
    }

    public void printMap(List<String> bridge, List<Boolean> state) {
        initMap();
        makeMap(bridge, state);
        System.out.println(BRIDGE_START + upMap + BRIDGE_END);
        System.out.println(BRIDGE_START + downMap + BRIDGE_END);
    }

    private void initMap() {
        upMap = new StringBuilder();
        downMap = new StringBuilder();
    }

    private void makeMap(List<String> bridge, List<Boolean> state) {
        for (int index = 0; index < state.size(); index++) {
            if (index != 0) {
                upMap.append(BRIDGE_DIVIDE);
                downMap.append(BRIDGE_DIVIDE);
            }
            upMap.append(makeUp(bridge.get(index), state.get(index)));
            downMap.append(makeDown(bridge.get(index), state.get(index)));
        }
    }

    private String makeUp(String bridge, boolean state) {
        if (bridge.equals(UP) && state || !bridge.equals(UP) && !state) {
            return makePrintFormat(state);
        }
        return BLANK;
    }

    private String makeDown(String bridge, boolean state) {
        if (bridge.equals(DOWN) && state || !bridge.equals(DOWN) && !state) {
            return makePrintFormat(state);
        }
        return BLANK;
    }

    private String makePrintFormat(boolean state) {
        if (state) {
            return MOVE;
        }
        return STOP;
    }

    private String separateLine() {
        return System.lineSeparator();
    }
}
