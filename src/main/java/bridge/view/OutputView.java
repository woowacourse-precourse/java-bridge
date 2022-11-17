package bridge.view;

import bridge.domain.Bridge;
import bridge.domain.Position;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final int INDEX_INDEX = 0;
    private static final int ELEMENT_INDEX = 1; // up or down
    private static final int UP = 1;
    private static final int DOWN = 0;
    private static final String ERROR_PREFIX = "[ERROR] ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static String printMap(Bridge bridge, Position position) { // TODO: DTO 사용??
        String compare = bridge.compare(position);
        System.out.println("compare = " + compare);
        return compare;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult() {
    }

    public static void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}
