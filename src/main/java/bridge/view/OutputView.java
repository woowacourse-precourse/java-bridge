package bridge.view;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final static String COMMA = ", ";
    private final static String BAR = "|";
    private final static String UP = "U";
    private final static String DOWN = "D";

    public void printStatGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printSpaceLine() {
        System.out.println();
    }

    public void printInputBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printInputMove() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printInputContinue() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> users, List<String> bridge) {

        List<String> upBridge = separateLine(bridge, Move.U);
        List<String> downBridge = separateLine(bridge, Move.D);

        List<String> upUsers = separateLine(users, Move.U);
        List<String> downUsers = separateLine(users, Move.D);


        List<String> resultUp = new ArrayList<>();
        List<String> resultDown = new ArrayList<>();


//        String upperLine = users.toString().replace(COMMA, BAR).replace(UP, " " + UP + " ").replace(DOWN, "   ");
//        String downLine = users.toString().replace(COMMA, BAR).replace(DOWN, " " + DOWN + " ").replace(UP, "   ");
//
//        System.out.println(upperLine);
//        System.out.println(downLine);

    }


    private List<String> separateLine(List<String> list, Move type) {
        List<String> line = new ArrayList<>();
        for (String move : list) {
            line.add(checkType(move, type));
        }
        return line;
    }

    private String checkType(String move, Move type) {
        if (move.equals(type.getMove())) {
            return move;
        }
        return " ";
    }

    private String matchWithBridge(int index, List<String> users, List<String> bridge) {
        if (users.get(index).equals(bridge.get(index))) {
            return "O";
        }
        return "X";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> users, List<String> bridge) {
        System.out.println("최종 게임 결과");
        printSpaceLine();
    }
}
