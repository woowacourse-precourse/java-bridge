package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> bridgeValues) {

        List<String> bridgeUpperValues = bridgeValues.get(0);
        List<String> bridgeLowerValues = bridgeValues.get(1);

        printBridge(bridgeUpperValues);
        printBridge(bridgeLowerValues);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> bridgeValues, GameStatus gameStatus) {
        System.out.println("\n최종 게임 결과");

        printMap(bridgeValues);
        System.out.println();

        System.out.println("게임 성공 여부: " + gameStatus.getGameEndFlag());
        System.out.println("총 시도한 횟수: " + gameStatus.getTryCount());
    }

    private void printBridge(List<String> bridgeValues) {
        System.out.print("[ ");
        String join = String.join(" | ", bridgeValues);
        System.out.print(join);
        System.out.println(" ]");
    }
}
