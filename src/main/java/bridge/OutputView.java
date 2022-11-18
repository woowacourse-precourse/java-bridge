package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final static String start = "다리 건너기 게임을 시작합니다.";

    public void printStart() {
        System.out.println(start);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * U D U D
     * U U
     * U D D
     */
    public void printUpperMap(List<String> bridge, List<String> moveMapList) {
        System.out.print("[ ");
        for(int i=0; i<moveMapList.size(); i++){
            if (i > 0) System.out.print(" | ");
            if (bridge.get(i).equals("U") && moveMapList.get(i).equals("U")) System.out.print("O");
            if (bridge.get(i).equals("U") && moveMapList.get(i).equals("D")) System.out.print(" ");
            if (bridge.get(i).equals("D") && moveMapList.get(i).equals("U")) System.out.print("X");
        }
        System.out.println(" ]");
    }

    public void printLowerMap(List<String> bridge, List<String> moveMapList) {
        System.out.print("[ ");
        for(int i=0; i<moveMapList.size(); i++){
            if (i > 0) System.out.print(" | ");
            if (bridge.get(i).equals("D") && moveMapList.get(i).equals("D")) System.out.print("O");
            if (bridge.get(i).equals("D") && moveMapList.get(i).equals("U")) System.out.print(" ");
            if (bridge.get(i).equals("U") && moveMapList.get(i).equals("D")) System.out.print("X");
        }
        System.out.println(" ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
