package bridge;

import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> userInput, boolean passFail) {
        String[][] bridge = bridgeResult(userInput, passFail);
        System.out.println("[ " + String.join(" | ", bridge[0]) + " ]");
        System.out.println("[ " + String.join(" | ", bridge[1]) + " ]");
    }

    public String[][] bridgeResult(List<String> userInput, boolean passFail) {
        Map<String, Integer> upDownAndNumber = Map.of("U", 0, "D", 1);
        String[][] bridgeOutput = new String[2][userInput.size()];
        for (int index = 0 ; index< userInput.size()-1 ; index++) {
            bridgeOutput[upDownAndNumber.get(userInput.get(index))][index] = "O";
            bridgeOutput[1-upDownAndNumber.get(userInput.get(index))][index] = " ";
        }
        if (passFail) {
            bridgeOutput[upDownAndNumber.get(userInput.get(userInput.size()-1))][userInput.size()-1] = "O";
            bridgeOutput[1-upDownAndNumber.get(userInput.get(userInput.size()-1))][userInput.size()-1] = " ";
            return bridgeOutput;
        }
        bridgeOutput[upDownAndNumber.get(userInput.get(userInput.size()-1))][userInput.size()-1] = "X";
        bridgeOutput[1-upDownAndNumber.get(userInput.get(userInput.size()-1))][userInput.size()-1] = " ";
        return bridgeOutput;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> userInput, boolean passFailFinal) {
        System.out.println();
        System.out.println("최종 게임 결과");
        printMap(userInput, passFailFinal);
        System.out.println();
    }
}