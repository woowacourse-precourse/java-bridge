package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 게임 시작 메세지를 출력한다.
     */
    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public void printMap(List<String> bridge, List<String> player) {
        //상단 다리 출력
        printSingleMap(bridge, player, "U");
        //하단 다리 출력
        printSingleMap(bridge, player, "D");
    }

    /**
     * 현재까지 이동한 다리 하나의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public void printSingleMap(List<String> bridge, List<String> player, String upDown) {
        System.out.print("[ ");
        for(int s = 0; s < player.size(); s++) {
            boolean isO = isO(bridge.get(s), player.get(s), upDown);
            boolean isX = isX(bridge.get(s), player.get(s), upDown);

            if (isO) System.out.print("O ");
            if (isX) System.out.print("X ");
            if (!isO && !isX) System.out.print("  ");
            if (s != player.size() -1) System.out.print("| ");
        }
        System.out.println("]");
    }

    public boolean isO(String bridge, String player, String upDown) {
        if (bridge == player && player == upDown) return true;
        return false;
    }

    public boolean isX(String bridge, String player, String upDown) {
        if (player == upDown && player != bridge) return true;
        return false;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
