package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printIntro() {
        System.out.println("다리 건너기 게임을 시작합니다.\n" + "\n" + "다리의 길이를 입력해주세요.");
    }

    public void printChoosingMovingDirection() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printChoosingWhetherRestart() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *<p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, List<String> route) {
        System.out.printf("[%s]\n", decidePartialMap(bridge, route, "U"));
        System.out.printf("[%s]\n\n", decidePartialMap(bridge, route, "D"));
    }

    private String decidePartialMap(List<String> bridge, List<String> route, String location) {
        // 양쪽 공백 + 처음이면 | 안더한다.
        String partialMap = " " + rightOrWrongStep(bridge.get(0), route.get(0), location) + " ";
        for (int step = 1; step < route.size(); step++) {
            partialMap += "| " + rightOrWrongStep(bridge.get(step), route.get(step), location) + " ";
        }
        return partialMap;
    }

    private String rightOrWrongStep(String bridgeScaffolding, String step, String location) {
        if (bridgeScaffolding.equals(step) && bridgeScaffolding.equals(location)) return "O";
        if (!bridgeScaffolding.equals(step) && !bridgeScaffolding.equals(location)) return "X";
        return " ";
    }


    public void printResult(List<String> bridge, List<String> route, List<Integer> gameRestartCount) {
        System.out.println("최종 게임 결과");
        printMap(bridge, route);
        if (bridge.equals(route)) System.out.println("게임 성공 여부: 성공");
        if (!bridge.equals(route)) System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + gameRestartCount.get(0));

    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *<p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */


}
