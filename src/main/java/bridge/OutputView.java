package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String START_BRACKET = "[";
    private final String END_BRACKET = "]";
    private List<String> upStr = new ArrayList<>();
    private List<String> downStr = new ArrayList<>();



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


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
