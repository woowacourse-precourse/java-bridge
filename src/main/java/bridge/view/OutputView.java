package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_START_MSG = "다리 건너기 게임을 시작합니다.\n";
    private static final String BRIDGE_SIZE_DEMAND_MSG = "다리의 길이를 입력해주세요.";
    private static final String BRIDGE_MOVE_DEMAND_MSG = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String MAP_PREFIX = "[ ";
    private static final String MAP_SUFFIX = " ]";
    private static final String STRING_DELIMITER = "";
    private static final String MAP_DELIMITER = " | ";


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridges) {
        System.out.println(MAP_PREFIX + toPrintForm(bridges.get(0)) +MAP_SUFFIX);
        System.out.println(MAP_PREFIX + toPrintForm(bridges.get(1)) +MAP_SUFFIX);
    }

    private String toPrintForm(String bridge) {
        return String.join(MAP_DELIMITER, bridge.split(STRING_DELIMITER));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printStart() {
        System.out.println(GAME_START_MSG);
        System.out.println(BRIDGE_SIZE_DEMAND_MSG);
    }

    public void printError(String errorMsg) {
        System.out.println(ERROR_PREFIX + errorMsg);
    }

    public void printOrder() {
        System.out.println(BRIDGE_MOVE_DEMAND_MSG);
    }
}
