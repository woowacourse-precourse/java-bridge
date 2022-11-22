package bridge;

/**
 * 제공된 OutputView 클래스를 활용해 구현해야 한다.
 * OutputView의 패키지는 변경할 수 있다.
 * OutputView의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 값 출력을 위해 필요한 메서드를 추가할 수 있다.
 */

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
    public void printMap(List<String> upResult, List<String> downResult) {
        System.out.print("[ " + upResult.get(0));
        for (int i = 1; i < upResult.size(); i++)
            System.out.print(" | " + upResult.get(i));
        System.out.println(" ]");

        System.out.print("[ " + downResult.get(0));
        for (int i = 1; i < downResult.size(); i++)
            System.out.print(" | " + downResult.get(i));
        System.out.println(" ]");
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean successOrFail, int tryCount, List<String> upResult, List<String> downResult) {
        System.out.println("최종 게임 결과");
        printMap(upResult, downResult);
        System.out.println();
        System.out.print("게임 성공 여부: ");
        if (successOrFail)
            System.out.println("성공");
        else
            System.out.println("실패");
        System.out.println("총 시도한 횟수: " + tryCount);
    }
}
