package bridge;

import bridge.domain.Player;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void printGameStart(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> bridge, Player player) {
        StringBuilder up = new StringBuilder("[");
        StringBuilder down = new StringBuilder("[");
        List<String> playerBridge = player.get();
        for (int i = 0; i <= player.getPosition(); i++) {
            if (bridge.get(i).equals("U")) {
                if (playerBridge.get(i).equals(bridge.get(i))) {
                    up.append(" O |");
                    down.append("   |");
                } else {
                    up.append(" X |");
                    down.append("   |");
                }
            }
            if (bridge.get(i).equals("D")) {
                if (playerBridge.get(i).equals(bridge.get(i))) {
                    up.append("   |");
                    down.append(" O |");
                } else {
                    up.append("   |");
                    down.append(" X |");
                }
            }


        }
        up.delete(up.length() - 1, up.length());
        down.delete(down.length() - 1, down.length());

        System.out.println(up.append("]"));
        System.out.println(down.append("]"));
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(List<String> bridge, Player player) {
        System.out.println("최종 게임 결과");
        StringBuilder up = new StringBuilder("[");
        StringBuilder down = new StringBuilder("[");
        List<String> playerBridge = player.get();
        for (int i = 0; i <= player.getPosition(); i++) {
            if (bridge.get(i).equals("U")) {
                if (playerBridge.get(i).equals(bridge.get(i))) {
                    up.append(" O |");
                    down.append("   |");
                } else {
                    up.append(" X |");
                    down.append("   |");
                }
            }
            if (bridge.get(i).equals("D")) {
                if (playerBridge.get(i).equals(bridge.get(i))) {
                    up.append("   |");
                    down.append(" O |");
                } else {
                    up.append("   |");
                    down.append(" X |");
                }
            }


        }
        up.delete(up.length() - 1, up.length());
        down.delete(down.length() - 1, down.length());

        System.out.println(up.append("]"));
        System.out.println(down.append("]"));
    }


}