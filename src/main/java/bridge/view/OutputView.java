package bridge.view;

import bridge.domain.ResultFlag;
import bridge.domain.Map;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String BRIDGE_START = "[ ";
    private static final String BRIDGE_END = " ]";
    private static final String BRIDGE_MIDDLE = " | ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Map map) {
        List<ResultFlag> upper = map.getUpper();
        printBridge(upper);
        List<ResultFlag> lower = map.getLower();
        printBridge(lower);
        System.out.println();
    }

    public void printBridge(List<ResultFlag> flags) {
        System.out.print(BRIDGE_START);
        for (int i = 0; i < flags.size(); i++) {
            if (i > 0) {
                System.out.print(BRIDGE_MIDDLE);
            }
            System.out.print(flags.get(i));
        }
        System.out.println(BRIDGE_END);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Map map, ResultFlag result, int tryCount) {
        System.out.println("최종 게임 결과");
        printMap(map);
        System.out.printf("게임 성공 여부: %s%n", result.getMean());
        System.out.printf("총 시도한 횟수: %d", tryCount);
    }

    public void printGameStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    public void printEnterBridgeLength() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printEnterSelectMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printRestartOrQuitMessage() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public void printException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
