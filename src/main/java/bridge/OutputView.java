package bridge;

import java.util.ArrayList;
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
    public void printMap(List<String> map, List<String> user) {
        List<String> upperBridge = setUpperBridge(map, user);
        List<String> underBridge = setUnderBridge(map, user);

        printBridge(upperBridge);
        printBridge(underBridge);
    }

    private List<String> setUpperBridge(List<String> map, List<String> user) {
        List<String> upperBridge = new ArrayList<>();

        for (int i = 0; i < user.size(); i++) {
            upperBridge.add(setBridgeStep(map.get(i), user.get(i), "D"));
        }
        return upperBridge;
    }

    private List<String> setUnderBridge(List<String> map, List<String> user) {
        List<String> underBridge = new ArrayList<>();

        for (int i = 0; i < user.size(); i++) {
            underBridge.add(setBridgeStep(map.get(i), user.get(i), "U"));
        }
        return underBridge;
    }

    private String setBridgeStep(String map, String user, String counterPosition) {
        if (user.equals(counterPosition)) return " ";
        if (!user.equals(map)) return "X";

        return "O";
    }

    private void printBridge(List<String> bridge) {
        System.out.println("[ "
                .concat(String.join(" | ", bridge))
                .concat(" ]"));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean finalResult, int trials) {
        printFinalResult(finalResult);
        System.out.printf("총 시도한 횟수: %d\n",trials);
    }

    private  void printFinalResult(boolean finalResult){
        if (finalResult == false){
            System.out.println("게임 성공 여부: 실패" );
            return;
        }
        System.out.println("게임 성공 여부: 성공" );
    }
}
