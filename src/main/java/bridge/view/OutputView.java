package bridge.view;

import java.util.List;
import bridge.model.BridgeGame;
import bridge.constants.ViewMessage;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 *
 * 제공된 OutputView 클래스를 활용해 구현해야 한다.
 * OutputView의 패키지는 변경할 수 있다.
 * OutputView의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 값 출력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class OutputView {
    BridgeGame bg = new BridgeGame();

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String[][] map) {
        for (String[] row : map) {
            System.out.print("[");
            printRow(row);
            System.out.println(" ]");
        }
        System.out.println();
    }
    public void printRow(String[] row) {
        for (int idx = 0; idx < row.length; idx ++) {
            if (idx != row.length-1) {
                System.out.print(" ");
                printSpaceOrCell(row[idx]);
                System.out.print(" |");
                continue;
            }
            System.out.print(" ");
            printSpaceOrCell(row[idx]);
        }
    }
    public void printSpaceOrCell(String cell) {
        if (cell == null) {
            System.out.print(" ");
            return;
        }
        System.out.print(cell);
    }
    public String[][] makeMap(List<String> bridge, List<String> moves) {
        int progress = moves.size();
        String[][] map = new String[2][progress];
        for (int idx = 0; idx < progress; idx++) {
            if (moves.get(idx).equals("U")) {
                map[0][idx] = translateCell(bg.move(bridge.get(idx), moves.get(idx)));
                continue;
            }
            map[1][idx] = translateCell(bg.move(bridge.get(idx), moves.get(idx)));
        }
        return map;
    }
    public String translateCell(boolean move) {
        if (move) {
            return "O";
        }
        return "X";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean success, int numTrial, String[][] map) {
        System.out.println("최종 게임 결과");
        printMap(map);
        System.out.print("게임 성공 여부: ");
        if (success) {
            System.out.println("성공");
        }
        if (!success) {
            System.out.println("실패");
        }
        System.out.println("총 시도한 횟수: " +numTrial);
    }
    public void printStart() {
        System.out.println(ViewMessage.START.getDescription());
    }
    public void printGetLength() {
        System.out.println(ViewMessage.SET_LENGTH.getDescription());
    }
    public void printGetMove() {
        System.out.println(ViewMessage.SET_MOVE.getDescription());
    }
    public void printGetCommand() {
        System.out.println(ViewMessage.SET_RETRY.getDescription());
    }
}
