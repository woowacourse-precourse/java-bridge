package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    List<String> upperMap = new ArrayList<>();
    List<String> lowerMap = new ArrayList<>();

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int round, Bridge bridge, String movement) {
        movementUp(round, bridge, movement);
        movementDown(round, bridge, movement);
        formatting();
        ifBlocked(round);
    }

    public void movementUp(int round, Bridge bridge, String movement) {
        if(movement.equals("U")) {
            upperMap.add(bridge.getUpperBridge().get(round));
            lowerMap.add("   ");
        }
    }

    public void movementDown(int round, Bridge bridge, String movement) {
        if(movement.equals("D")) {
            upperMap.add("   ");
            lowerMap.add(bridge.getLowerBridge().get(round));
        }
    }

    public void formatting() {
        System.out.println(upperMap.toString().replaceAll(", ", "|"));
        System.out.println(lowerMap.toString().replaceAll(", ", "|"));
    }

    public void ifBlocked(int round) {
        if(upperMap.get(round).equals(" X ") || lowerMap.get(round).equals(" X ")) {
            upperMap.remove(round);
            lowerMap.remove(round);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean status, int gameTry) {
        if(status) {
            System.out.println("최종 게임 결과\n게임 성공 여부: 성공");
            System.out.println("총 시도한 횟수: " + gameTry);
            return;
        }
        System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + gameTry);
    }

    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printRequestBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printRequestUpDown() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printRequestRetry() {
        System.out.println("게임을 다시 시도할 지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }
}
