package bridge.ioView;

import bridge.BridgeGame;
import bridge.data.Direction;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final BridgeGame bridgeGame = new BridgeGame();

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
        for (Direction direction : Direction.values()) {
            printFloor(direction.toString(), userRoute, bridge);
        }
    }

    private void printFloor(String direction, List<String> userRoute, List<String> bridge) {
        System.out.print("[");
        for (int i = 0; i < userRoute.size(); i++) {
            System.out.print(getCell(direction, userRoute.get(i), bridge.get(i)));
            if (i == userRoute.size() - 1) {
                break;
            }
            System.out.print("|");
        }
        System.out.println("]");
    }

    private String getCell(String direction, String userDirection, String bridgeDirection) {
        if (direction.equals(userDirection)) {
            if (userDirection.equals(bridgeDirection)) {
                return " O ";
            }
            return " X ";
        }
        return "   ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * @param trial
     * @param bridge
     * @param userRoute
     */
    public void printResult(int trial, List<String> userRoute, List<String> bridge) {
        System.out.println("최종 게임 결과");
        printMap(userRoute, bridge);
        System.out.println("게임 성공 여부: " +
                convertSuccessToString(bridgeGame.checkCrossingBridge(userRoute, bridge)));
        System.out.println("총 시도한 횟수: " + trial);
    }

    private String convertSuccessToString(boolean success) {
        if (success) {
            return "성공";
        }

        return "실패";
    }
}
