package bridge.view;

import bridge.model.Bridge;
import bridge.model.Constants;
import bridge.model.Player;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void start() {
        System.out.println(GameMessage.GAME_START.getMessage());
        System.out.println();
    }

    public static void askLength() {
        System.out.println(GameMessage.ASK_BRIDGE_SIZE.getMessage());
    }

    public static void askMove() {
        System.out.println();
        System.out.println(GameMessage.ASK_MOVE.getMessage());
    }

    public static void askRestart() {
        System.out.println();
        System.out.println(GameMessage.ASK_RESTART.getMessage());
    }

    public static void printMap(List<String> way, List<String> realWay) {
        String up = drawMap(way, realWay, Constants.UP);
        String down = drawMap(way, realWay, Constants.DOWN);
        System.out.println(up);
        System.out.println(down);
    }

    private static String drawMap(List<String> way, List<String> realWay, String position) {
        StringBuilder sb = new StringBuilder(Bridge.BEGIN);
        for (int i = 0; i < way.size(); i++) {
            if (i != 0) {
                sb.append(Bridge.DELIMITER);
            }
            if (way.get(i).equals(realWay.get(i)) && way.get(i).equals(position)) {
                sb.append(Bridge.ABLE);
                continue;
            } else if (i == way.size() - 1 && way.get(i).equals(position)) {
                sb.append(Bridge.DISABLE);
                continue;
            }
            sb.append(Bridge.NONE);
        }
        sb.append(Bridge.END);
        return sb.toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
