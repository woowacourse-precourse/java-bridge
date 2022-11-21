package bridge;

import java.util.ArrayList;
import java.util.Objects;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public String mapU = "[";
    public String mapD = "[";
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int bridgeCount, ArrayList<String> currentCoordinate) {
        if (bridgeCount > 0) {
            mapU += "|";
            mapD += "|";
        }
        if (Objects.equals(currentCoordinate.get(bridgeCount), "U")){
            mapU += " O ";
            mapD += "   ";
        }
        if (Objects.equals(currentCoordinate.get(bridgeCount), "D")){
            mapU += "   ";
            mapD += " O ";
        }
        System.out.println(mapU + "]");
        System.out.println(mapD + "]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int gameCount, ArrayList<String> currentCoordinate) {
        int lastChar = currentCoordinate.size()-1;
        if (Objects.equals(currentCoordinate.get(lastChar), "U")) {
            System.out.println(mapU + "| O ]");
            System.out.println(mapD + "|   ]");
        }
        if (Objects.equals(currentCoordinate.get(lastChar), "D")) {
            System.out.println(mapU + "|   ]");
            System.out.println(mapD + "| O ]");
        }
    }
    public void printFailed(int gameCount, ArrayList<String> currentCoordinate) {
        int lastChar = currentCoordinate.size()-1;
        if (Objects.equals(currentCoordinate.get(lastChar), "U")) {
            System.out.println(mapU + "| X ]");
            System.out.println(mapD + "|   ]");
        }
        if (Objects.equals(currentCoordinate.get(lastChar), "D")) {
            System.out.println(mapU + "|   ]");
            System.out.println(mapD + "| X ]");
        }
    }
}
