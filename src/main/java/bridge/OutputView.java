package bridge;

import java.util.ArrayList;
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
    public void printMap(HashMap<Integer, List<String>> result) {
        System.out.print("[");
        printUpper(result);
        System.out.println("]");
        System.out.print("[");
        printDown(result);
        System.out.println("]");
    }

    public void printUpper(HashMap<Integer, List<String>> result) {
        for (int key: result.keySet()){
            List<String> resultList = result.get(key);
            String output = resultList.get(0);
            if (output.equals("E")) {
                output = " ";
            }
            System.out.print(output);
            if (key==(result.size()-1)){
                break;
            }
            System.out.print("|");
        }
    }

    public void printDown(HashMap<Integer, List<String>> result) {
        for (int key: result.keySet()){
            List<String> resultList = result.get(key);
            String output = resultList.get(1);
            if (output.equals("E")) {
                output = " ";
            }
            System.out.print(output);
            if (key==(result.size()-1)){
                break;
            }
            System.out.print("|");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result, int retryCount) {
        System.out.println("게임 성공 여부: "+result);
        System.out.println("총 시도한 횟수: "+retryCount);
    }
}
