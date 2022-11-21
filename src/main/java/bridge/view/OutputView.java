package bridge.view;

import bridge.domain.Bridge;
import bridge.rule.EndRule;
import bridge.util.Constant;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void printStart() {
        System.out.println(Constant.GAMESTART);
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(Bridge bridge) {
        String[] upperBridge = bridge.getUpperBridge().toArray(new String[0]);
        String[] lowerBridge = bridge.getLowerBridge().toArray(new String[0]);
        System.out.println(
            Constant.BRACKETS_OPEN + String.join(Constant.DELIMITER, upperBridge) + Constant.BRACKETS_CLOSE);
        System.out.println(
            Constant.BRACKETS_OPEN + String.join(Constant.DELIMITER, lowerBridge) + Constant.BRACKETS_CLOSE);
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(String result, int count) {
        System.out.println("게임 성공 여부 : " + result);
        System.out.println("총 시도한 횟수 :" + count);
    }
}
