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
    public void printMap(List<Choice> inputs) {
        printBridge(inputs, "U");
        printBridge(inputs, "D");
    }

    public void printBridge(List<Choice> inputs, String upDown){
        String result = "[";

        for (Choice input: inputs){
            String tmp = "   |";
            if (input.getInput() == upDown){
                tmp = " " + input.getInput() + " |";
            }
            result+=tmp;
        }
        System.out.println(result.subSequence(0, result.length()-2)+"]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {

    }
}
