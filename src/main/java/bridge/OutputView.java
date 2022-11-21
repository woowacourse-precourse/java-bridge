package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> record, boolean success) {
        System.out.println(getRows(record, success, "U"));
        System.out.println(getRows(record, success, "D") + "\n");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int attemptNum, int currentLocation, int bridgeSize, List<String> record) {
        System.out.println("최종 게임 결과");
        if (currentLocation == bridgeSize) {
            printMap(record,true);
            System.out.println("게임 성공 여부: 성공");
        } else {
            printMap(record, false);
            System.out.println("게임 성공 여부: 실패");
        }
        System.out.println("총 시도한 횟수: " + attemptNum);
    }
}
