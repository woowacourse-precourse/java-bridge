package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String PARTITION = " | ";
    private static final String HEAD = "[ ";
    private static final String TAIL = " ]";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(final Bridge bridge, final List<String> movings) {
        System.out.print(HEAD);
        printUpperMap(bridge, movings);
        System.out.println(TAIL);
        System.out.print(HEAD);
        printLowerMap(bridge, movings);
        System.out.println(TAIL);
    }

    public void printUpperMap(final Bridge bridge, final List<String> movings) {
        for (int i = 0; i < movings.size(); i++) {
            if (bridge.isO(i)) {
                printOorBlankOnUpperMap(movings.get(i));
            }
            if (!bridge.isO(i)) {
                printXorBlankOnUpperMap(movings.get(i));
            }
            printPartition(movings.size(), i);
        }
    }

    public void printLowerMap(final Bridge bridge, final List<String> movings) {
        for (int i = 0; i < movings.size(); i++) {
            if (bridge.isO(i)) {
                printOorBlankOnLowerMap(movings.get(i));
            }
            if (!bridge.isO(i)) {
                printXorBlankOnLowerMap(movings.get(i));
            }
            printPartition(movings.size(), i);
        }
    }

    public void printOorBlankOnUpperMap(final String moving) {
        if (moving.equals("U")) {
            System.out.print("O");
        }
        if (moving.equals("D")) {
            System.out.print(" ");
        }
    }

    public void printOorBlankOnLowerMap(final String moving) {
        if (moving.equals("D")) {
            System.out.print("O");
        }
        if (moving.equals("U")) {
            System.out.print(" ");
        }
    }

    public void printXorBlankOnUpperMap(final String moving) {
        if (moving.equals("U")) {
            System.out.print("X");
        }
        if (moving.equals("D")) {
            System.out.print(" ");
        }
    }

    public void printXorBlankOnLowerMap(final String moving) {
        if (moving.equals("D")) {
            System.out.print("X");
        }
        if (moving.equals("U")) {
            System.out.print(" ");
        }
    }

    public void printPartition(final int size, final int index) {
        if (index < size - 1) {
            System.out.print(PARTITION);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(final Bridge bridge, final List<String> movings, final String win) {
        System.out.println("최종 게임 결과");
        printMap(bridge, movings);
        System.out.println("\n게임 성공 여부: " + win);
        System.out.println("총 시도한 횟수: " + bridge.getCounter());
    }
}
