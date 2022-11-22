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
    public void printMap(List<List<String>> userMap) {
        printUpDown(0, userMap);
        printUpDown(1,userMap);
        System.out.println();
    }
    public void printUpDown(int upDown, List<List<String>> userMap) {
        System.out.print("[ ");
        for (int cnt = 0; cnt < userMap.get(upDown).size(); cnt++) {
            System.out.print(userMap.get(upDown).get(cnt));
            printSlash(cnt, userMap.get(upDown).size());
        }
        System.out.println(" ]");
    }
    public void printSlash(int cnt, int size) {
        if (cnt != size - 1) {
            System.out.print(" | ");
        }
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> userMap, int cnt, boolean exitCode) {
        System.out.println("최종 게임 결과");
        printUpDown(0, userMap);
        printUpDown(1,userMap);
        System.out.println();
        if (exitCode) {
            System.out.println("게임 성공 여부: 실패");
        } else {
            System.out.println("게임 성공 여부: 성공");
        }
        System.out.println("총 시도한 횟수: " + cnt);
    }
}