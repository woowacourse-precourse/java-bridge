package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * @param bridge   게임에 사용 중인 다리
     * @param userMove 사용자가 이동한 칸
     */
    public void printMap(List<String> bridge, List<String> userMove) {
        printOneSideMap(bridge, userMove, "U");
        printOneSideMap(bridge, userMove, "D");
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태 중 한 쪽을 정해진 형식에 맞춰 출력한다.
     *
     * @param bridge   게임에 사용 중인 다리
     * @param userMove 사용자가 이동한 칸
     * @param oneSide  출력하려는 쪽. 위 쪽이면 "U", 아래 쪽이면 "D"
     */
    private void printOneSideMap(List<String> bridge, List<String> userMove, String oneSide) {
        System.out.print("[ ");
        printOneResult(bridge.get(0), userMove.get(0), oneSide);
        for (int i = 1; i < userMove.size(); i++) {
            System.out.print(" | ");
            printOneResult(bridge.get(i), userMove.get(i), oneSide);
        }
        System.out.println(" ]");
    }

    /**
     * 다음 결과를 하나 출력한다.
     *
     * @param bridge   다리에서 건널 수 있는 칸
     * @param userMove 사용자가 이동한 칸
     * @param oneSide  출력하려는 쪽. 위 쪽이면 "U", 아래 쪽이면 "D"
     */
    private void printOneResult(String bridge, String userMove, String oneSide) {
        if (!userMove.equals(oneSide)) {
            System.out.print(" ");
            return;
        }
        if (userMove.equals(bridge)) {
            System.out.print("O");
            return;
        }
        System.out.print("X");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * @param gameClear 게임의 성공 여부
     * @param tryNumber 게임을 시도한 횟수
     */
    public void printResult(boolean gameClear, int tryNumber) {
        if (gameClear) {
            System.out.println("게임 성공 여부: 성공");
            System.out.println("총 시도한 횟수: " + tryNumber);
            return;
        }
        System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + tryNumber);
    }
}
