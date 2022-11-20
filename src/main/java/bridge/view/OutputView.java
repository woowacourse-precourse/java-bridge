package bridge.view;

import bridge.model.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String startGame = "다리 건너기 게임을 시작합니다.";
    private static final String gameResult = "최종 게임 결과";
    private static final String successOrNot = "게임 성공 여부: ";
    private static final String countOfTry = "총 시도한 횟수: ";

    public void gameStart() {
        System.out.println(startGame);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String[]> printMap(List<String> bridge, List<String> marks) {
        List<String[]> map = makeBridgeSections(bridge, marks);
        printLayer(map, Course.TOP.getNumber());
        printLayer(map, Course.BOTTOM.getNumber());
        return map;
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

    private List<String[]> makeBridgeSections(List<String> bridge, List<String> marks) {
        List<String[]> temp = new ArrayList<>();
        for (int i = 0; i < marks.size(); i++) {
            String[] bridgeSection = makeBridgeSection(bridge.get(i), marks.get(i));
            temp.add(bridgeSection);
        }
        return temp;
    }

    private String[] makeBridgeSection(String course, String mark) { // "U", "O"
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
    public void printResult(List<String[]> curMap, String resultOfGame, int gameCount) {
        System.out.println(gameResult);
        printLayer(curMap, Course.TOP.getNumber());
        printLayer(curMap, Course.BOTTOM.getNumber());
        System.out.print(successOrNot);
        System.out.println(resultOfGame);
        System.out.print(countOfTry);
        System.out.println(gameCount);
    }
}
