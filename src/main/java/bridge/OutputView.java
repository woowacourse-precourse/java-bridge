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
    public void printMap(BridgeGame bridgeGame) {
        System.out.print("[");
        getUpPrint(bridgeGame.getBridge(), bridgeGame.getUsersMove());
        System.out.println("]");
        System.out.print("[");
        getDownPrint(bridgeGame.getBridge(), bridgeGame.getUsersMove());
        System.out.println("]");
    }

    private void getDownPrint(List<String> bridge, List<String> usersMove) {
        for (int idx = 0; idx < usersMove.size(); idx++) {
            if (printBlank(usersMove, idx, "D")) continue;
            if (printO(bridge, usersMove, idx)) continue;
            printX(idx);
        }
    }

    private void getUpPrint(List<String> bridge, List<String> usersMove) {
        for (int idx = 0; idx < usersMove.size(); idx++) {
            if (printBlank(usersMove, idx, "U")) continue;
            if (printO(bridge, usersMove, idx)) continue;
            printX(idx);
        }
    }

    private boolean printBlank(List<String> usersMove, int idx, String d) {
        if (!(usersMove.get(idx).equals(d))) {
            if (idx != 0) {
                System.out.print("|");
            }
            System.out.print("   ");
            return true;
        }
        return false;
    }

    private void printX(int idx) {
        if (idx != 0) {
            System.out.print("|");
        }
        System.out.print(" X ");
    }

    private boolean printO(List<String> bridge, List<String> usersMove, int idx) {
        if (bridge.get(idx).equals(usersMove.get(idx))) {
            if (idx != 0) {
                System.out.print("|");
            }
            System.out.print(" O ");
            return true;
        }
        return false;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("게임 성공 여부: " + isSuccess(bridgeGame.isMove()));
        System.out.println("총 시도한 횟수: " + bridgeGame.getCnt());
    }

    public String isSuccess(boolean flag) {
        if (flag) return "성공";
        return "실패";
    }
}