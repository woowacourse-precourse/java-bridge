package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final static String start = "다리 건너기 게임을 시작합니다.";
    private final static String result = "게임 성공 여부: ";
    private final static String resultCount = "총 시도한 횟수: ";
    public static void printStart() {
        System.out.println(start);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, List<String> moveMapList){
        printUpperMap(bridge, moveMapList);
        printLowerMap(bridge, moveMapList);
    }
    public void printUpperMap(List<String> bridge, List<String> moveMapList) {
        System.out.print("[ ");
        for(int i=0; i<moveMapList.size(); i++){
            if (i > 0) System.out.print(" | ");
            if (bridge.get(i).equals("U") && moveMapList.get(i).equals("O")) System.out.print("O");
            if (bridge.get(i).equals("U") && moveMapList.get(i).equals("X")) System.out.print(" ");
            if (bridge.get(i).equals("D") && moveMapList.get(i).equals("O")) System.out.print(" ");
            if (bridge.get(i).equals("D") && moveMapList.get(i).equals("X")) System.out.print("X");
        }
        System.out.println(" ]");
    }

    public void printLowerMap(List<String> bridge, List<String> moveMapList) {
        System.out.print("[ ");
        for(int i=0; i<moveMapList.size(); i++){
            if (i > 0) System.out.print(" | ");
            if (bridge.get(i).equals("D") && moveMapList.get(i).equals("O")) System.out.print("O");
            if (bridge.get(i).equals("D") && moveMapList.get(i).equals("X")) System.out.print(" ");
            if (bridge.get(i).equals("U") && moveMapList.get(i).equals("X")) System.out.print("X");
            if (bridge.get(i).equals("U") && moveMapList.get(i).equals("O")) System.out.print(" ");
        }
        System.out.println(" ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        if (!BridgeGame.moveMapList.contains("X")){
            System.out.printf("%s%s", result, "성공\n");
            System.out.printf("%s%d\n",resultCount,BridgeGame.gameCount);
            return;
        }
        System.out.printf("%s%s", result, "실패\n");
        System.out.printf("%s%d\n",resultCount,BridgeGame.gameCount);
    }
}
