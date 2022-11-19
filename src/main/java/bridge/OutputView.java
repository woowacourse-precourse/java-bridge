package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String SUCCESS = "O";
    private final String UP = "U";
    private final String DOWN = "D";


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> visited,String direction, String result) {
        upBridge(visited, direction, result);
        downBridge(visited, direction, result);
    }
    public void printMap(List<String> visited) {
        upBridge(visited, "","");
        downBridge(visited, "","");
    }
    private void upBridge(List<String> visited, String direction, String result) {
        System.out.println("[");
        for (String visit : visited) {
            checkEqual(visit, UP,SUCCESS);
            System.out.println("|");
        }
        if(!result.isEmpty()){
            checkEqual(direction,UP,result);
        }
        System.out.println("]");
    }

    private void downBridge(List<String> visited, String direction, String result) {
        System.out.println("[");
        for (String visit : visited) {
            checkEqual(visit, DOWN, SUCCESS);
            System.out.println("|");
        }
        if(!result.isEmpty()){
            checkEqual(direction, DOWN, result);
        }
        System.out.println("]");
    }

    private void checkEqual(String visited,String direction, String result) {
        if(visited.equals(direction)){
            System.out.println(result);
            return;
        }
        System.out.println(" ");
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> visited, String result, int tryNum) {
        System.out.println("최종 게임 결과");
        printMap(visited);
        System.out.println("게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + tryNum);
    }
}
