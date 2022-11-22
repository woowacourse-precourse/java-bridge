package bridge.view;

import bridge.domain.Attempt;
import bridge.domain.Bridge;
import bridge.domain.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 게임 시작 메세지를 출력하는 메소드
     */
    public static void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 다리 길이 입력 문구를 출력하는 메소드
     */
    public static void printBridgeSizeInput() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    /**
     * 이동할 칸 선택 입력 문구를 출력하는 메소드
     */
    public static void printMoveOptionInput() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    /**
     * 재시작 여부 입력 문구를 출력하는 메소드
     */
    public static void printRestartOptionInput() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(Bridge bridge, List<String> user) {
        String map = bridge.getMap(user);
        List<String> top = new ArrayList<>();
        List<String> bottom = new ArrayList<>();
        for (int index = 0; index < map.length(); index++) {
            if (user.get(index).equals("U")) {
                top.add(" " + map.charAt(index) + " ");
                bottom.add("   ");
                continue;
            }
            top.add("   ");
            bottom.add(" " + map.charAt(index) + " ");
        }
        System.out.println(top.toString().replaceAll(", ", "|"));
        System.out.println(bottom.toString().replaceAll(", ", "|"));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(Bridge bridge, List<String> user, Attempt attempt) {
        System.out.println("최종 게임 결과");
        printMap(bridge, user);
        System.out.print("\n게임 성공 여부: ");
        if (bridge.compare(user).equals(Result.SUCCESS)) {
            System.out.println("성공");
        }
        if (bridge.compare(user).equals(Result.FAIL)) {
            System.out.println("실패");
        }
        System.out.printf("총 시도한 횟수: %d\n", attempt.getCount());
    }
}
