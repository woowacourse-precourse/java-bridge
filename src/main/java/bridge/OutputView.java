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
        System.out.println("[" + getUpPrint(bridgeGame.getBridge(), bridgeGame.getUsersMove()) + "]");
        System.out.println("[" + getDownPrint(bridgeGame.getBridge(), bridgeGame.getUsersMove()) + "]");
    }

    private String getDownPrint(List<String> bridge, List<String> usersMove) {
        StringBuilder down = new StringBuilder();
        for (int idx = 0; idx < usersMove.size(); idx++) {
            if (!(usersMove.get(idx).equals("D"))) {
                if (idx != 0) {
                    down.append("|");
                }
                down.append("   ");
                continue;
            }
            if (bridge.get(idx).equals(usersMove.get(idx))) {
                if (idx != 0) {
                    down.append("|");
                }
                down.append(" O ");
                continue;
            }
            if (idx != 0) {
                down.append("|");
            }
            down.append(" X ");
        }
        return down.toString();
    }

    private String getUpPrint(List<String> bridge, List<String> usersMove) {
        StringBuilder up = new StringBuilder();
        for (int idx = 0; idx < usersMove.size(); idx++) {
            if (!(usersMove.get(idx).equals("U"))) {
                if (idx != 0) {
                    up.append("|");
                }
                up.append("   ");
                continue;
            }
            if (bridge.get(idx).equals(usersMove.get(idx))) {
                if (idx != 0) {
                    up.append("|");
                }
                up.append(" O ");
                continue;
            }
            if (idx != 0) {
                up.append("|");
            }
            up.append(" X ");
        }
        return up.toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
    }
}