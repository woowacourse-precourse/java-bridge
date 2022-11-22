package bridge;

import java.util.HashMap;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
     /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, String move, String moving) {
        List<String> list = List.of("U", "D");

        for (String word : list) {
            System.out.print("[");

            printMiddle(bridge, word);

            printLast(move, moving, word);
            System.out.println("]");
        }
    }

    public void printMap(List<String> bridge, HashMap<String, String> moveMap) {
        List<String> list = List.of("U", "D");

        for (String word : list) {
            System.out.print("[");

            printMiddle(bridge, word);

            printLast(moveMap.get("move"), moveMap.get("moving"), word);
            System.out.println("]");
        }
    }

    public void printMiddle(List<String> bridge, String location) {
        for (String i : bridge) {
            if (i.equals(location)) {

                System.out.print(" O ");

            }
            if (!(i.equals(location))) {

                System.out.print("   ");

            }
            System.out.print("|");
        }
    }

    public void printLast(String location, String result, String word) {
        if (location.equals(word)) {
            System.out.print(" " + result + " ");
        }

        if (!(location.equals(word))) {
            System.out.print("   ");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result, int gameCount) {
        if(result.equals("X")){
            result = "실패";
        }

        if(result.equals("O")){
            result = "성공";
        }
        System.out.println("게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + gameCount);
    }

    public void printFinalBridge(List<String> bridge, HashMap<String,String> moveMap){
        System.out.println("최종 게임 결과");
        printMap(bridge,moveMap);
    }

    public void printFinish(HashMap<String, String> moveMap, HashMap<String, Integer> gameData, List<String> bridge){
        printFinalBridge(bridge.subList(0,gameData.get("index")-1),moveMap);
        printResult(moveMap.get("moving"),gameData.get("gameCount"));
    }

    public void printStart(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("다리의 길이를 입력해주세요.");
    }
}
