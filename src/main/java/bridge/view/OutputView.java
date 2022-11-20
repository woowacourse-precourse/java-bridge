package bridge.view;

import bridge.domain.GameResult;
import bridge.domain.MovingResult;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Map<String, StringBuilder> map, MovingResult moveResult) {
        String moving = moveResult.getMoving();
        String result = "| " + moveResult.getResult() + " ";

        for (String part : map.keySet()) {
            StringBuilder printer = map.get(part);
            int insertIndex = printer.lastIndexOf(" ");

            if (part.equals(moving)) {
                printer.insert(insertIndex, result);
                System.out.println(printer.toString());
                continue;
            }

            printer.insert(insertIndex, "|   ");
            System.out.println(printer.toString());
        }

        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Map<String, StringBuilder> map, GameResult gameResult) {
        System.out.println("최종 게임 결과");
        for (StringBuilder printer : map.values()) {
            System.out.println(printer.toString());
        }
        System.out.println();

        System.out.println("게임 성공 여부: " + gameResult.getResult());
        System.out.println("총 시도한 횟수: " + gameResult.getTotalTry());
    }
}
