package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String START_BRACKET = "[";
    private final String END_BRACKET = "]";

    private final List<String> upStr = new ArrayList<>();
    private final List<String> downStr = new ArrayList<>();


    public void clearMap () {
        upStr.clear();
        downStr.clear();
    }


    public void commandChecker(List<String> bridge, List<String> commands, int count) {
        String command = commands.get(count);

        if (command.equals("U")) commandIsU(bridge.get(count), command);
        if (command.equals("D")) commandIsD(bridge.get(count), command);

        printMap();
    }


    public void commandIsU(String s, String command) {
        if (s.equals(command)) {
            upStr.add("O");
            downStr.add(" ");
        }
        if (!(s.equals(command))) {
            upStr.add("X");
            downStr.add(" ");
        }
    }


    public void commandIsD(String s, String command) {
        if (s.equals(command)) {
            downStr.add("O");
            upStr.add(" ");
        }
        if (!(s.equals(command))) {
            downStr.add("X");
            upStr.add(" ");
        }
    }


    public void printMap() {
        String upperBridge = START_BRACKET +" ";
        String bottomBridge = START_BRACKET +" ";

        upperBridge += String.join(" | ", upStr);
        bottomBridge += String.join(" | ", downStr);

        System.out.println(upperBridge + " " + END_BRACKET);
        System.out.println(bottomBridge + " " + END_BRACKET);
    }


    public void printResult() {
        printMap();
    }
}
