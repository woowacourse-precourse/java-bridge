package bridge;

import java.util.ArrayList;
import java.util.List;

import static message.PrintMessage.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final List<String> upStr = new ArrayList<>();
    private final List<String> downStr = new ArrayList<>();


    public void clearMap () {
        upStr.clear();
        downStr.clear();
    }


    public void commandChecker(List<String> bridge, List<String> commands, int count) {
        String command = commands.get(count);

        if (command.equals(MOVE_U_COMMAND.getStatus())) commandIsU(bridge.get(count), command);
        if (command.equals(MOVE_D_COMMAND.getStatus())) commandIsD(bridge.get(count), command);

        printMap();
    }


    public void commandIsU(String s, String command) {
        if (s.equals(command)) {
            upStr.add(CORRECT_ANSWER.getStatus());
            downStr.add(BLACK.getStatus());
        }
        if (!(s.equals(command))) {
            upStr.add(WRONG_ANSWER.getStatus());
            downStr.add(BLACK.getStatus());
        }
    }


    public void commandIsD(String s, String command) {
        if (s.equals(command)) {
            downStr.add(CORRECT_ANSWER.getStatus());
            upStr.add(BLACK.getStatus());
        }
        if (!(s.equals(command))) {
            downStr.add(WRONG_ANSWER.getStatus());
            upStr.add(BLACK.getStatus());
        }
    }


    public void printMap() {
        String upperBridge = START_BRACKET.getStatus() + BLACK.getStatus();
        String bottomBridge = START_BRACKET.getStatus() + BLACK.getStatus();

        upperBridge += String.join(DIVIDING_LINE.getStatus(), upStr);
        bottomBridge += String.join(DIVIDING_LINE.getStatus(), downStr);

        System.out.println(upperBridge + BLACK.getStatus() + END_BRACKET.getStatus());
        System.out.println(bottomBridge + BLACK.getStatus() + END_BRACKET.getStatus());
    }


    public void printResult() {
        printMap();
    }
}
