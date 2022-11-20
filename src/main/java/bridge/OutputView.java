package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printBridgeSizeGuide() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printMovingGuide() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printGameCommandGuide() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * @param userRoute
     * @param bridge
     */
    public void printMap(List<String> userRoute, List<String> bridge) {
        printFloor("U", userRoute, bridge);
        printFloor("D", userRoute, bridge);
    }

    private void printFloor(String direction, List<String> userRoute, List<String> bridge) {
        System.out.print("[");
        for (int i = 0; i < userRoute.size(); i++) {
            String OX = getOX(direction, userRoute.get(i), bridge.get(i));
            System.out.print(" " + OX + " ");
            if (i == userRoute.size() - 1) {
                break;
            }
            System.out.print("|");
        }
        System.out.println("]");
    }

    private String getOX(String direction, String userDirection, String bridgeDirection) {
        if (direction == userDirection) {
            if (userDirection == bridgeDirection) {
                return "O";
            }

            return "X";
        }

        return " ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * @param trial
     * @param bridge
     * @param userRoute
     */
    public void printResult(int trial, List<String> bridge, List<String> userRoute) {
    }
}
