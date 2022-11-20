package bridge.view;

import bridge.model.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String startGame = "다리 건너기 게임을 시작합니다.";
    private static final String resultOfGame = "최종 게임 결과";
    private static final String successOfNot = "게임 성공 여부: ";
    private static final String countOfTry = "총 시도한 횟수: ";
    private static final String successMark = "O";
    private static final String failMark = "X";

    public void gameStart() {
        System.out.println(startGame);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, List<String> successFlags) {
        List<String[]> map = makeBridgeSections(bridge, successFlags);
        printLayer(map, Course.TOP.getNumber());
        printLayer(map, Course.BOTTOM.getNumber());
    }

    private void printLayer(List<String[]> map, int course) {
        String[] layer = new String[map.size()];
        String partition = " | ";
        System.out.print("[ ");
        for (int i = 0; i < map.size(); i++) {
            layer[i] = map.get(i)[course];
        }
        System.out.print(String.join(partition, layer));
        System.out.println(" ]");
    }

    private List<String[]> makeBridgeSections(List<String> bridge, List<String> successFlags) {
        List<String[]> temp = new ArrayList<>();
        for (int i = 0; i < successFlags.size(); i++) {
            String[] bridgeSection = makeBridgeSection(successFlags.get(i), bridge.get(i));
            temp.add(bridgeSection);
        }
        return temp;
    }

    private String[] makeBridgeSection(String mark, String course) { //"O", "U"
        String[] section = {" ", " "};
        int pos = selectPosition(course);
        section[pos] = mark;
        return section;
    }

    private int selectPosition(String course) {
        if (course.equals(Course.TOP.getDirection())) {
            return Course.TOP.getNumber();
        }
        return Course.BOTTOM.getNumber();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
