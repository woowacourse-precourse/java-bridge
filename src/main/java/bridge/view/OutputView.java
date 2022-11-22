package bridge.view;

import bridge.domain.Attempt;
import bridge.domain.Bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.Result.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String UP = "U";
    private static final String DOWN = "D";

    /**
     * 게임 시작 메세지를 출력하는 메소드
     */
    public static void printStart() {
        System.out.println("\n다리 건너기 게임을 시작합니다.");
    }

    /**
     * 다리 길이 입력 문구를 출력하는 메소드
     */
    public static void printBridgeSizeInput() {
        System.out.println("\n다리의 길이를 입력해주세요.");
    }

    /**
     * 이동할 칸 선택 입력 문구를 출력하는 메소드
     */
    public static void printMoveOptionInput() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    /**
     * 재시작 여부 입력 문구를 출력하는 메소드
     */
    public static void printRestartOptionInput() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(Bridge bridge, Bridge user) {
        String map = bridge.getMap(user);
        System.out.println(getLine(user, map, UP));
        System.out.println(getLine(user, map, DOWN));
    }

    private static String getLine(Bridge user, String map, String line) {
        List<String> halfBridge = new ArrayList<>();
        for (int index = 0; index < user.getBridgeLength(); index++) {
            if (user.canJump(index, line)) {
                halfBridge.add(" " + map.charAt(index) + " ");
                continue;
            }
            halfBridge.add("   ");
        }
        return halfBridge.toString().replaceAll(", ", "|");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(Bridge bridge, Bridge user, Attempt attempt) {
        System.out.println("\n최종 게임 결과");
        printMap(bridge, user);
        System.out.print("\n게임 성공 여부: ");
        System.out.println(getSignal(bridge.isSuccess(user)));
        System.out.printf("총 시도한 횟수: %d\n", attempt.getCount());
    }
}
