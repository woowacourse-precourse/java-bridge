package bridge.ui;

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
    public void printMap(List<String> bridge, List<String> userInput, List<String> userStatus) {
        int size = userInput.size();
        String upResult = "[";
        String downResult = "[";

        for (int i = 0; i < size; i++) {
            if (userInput.get(i) == "U" && userStatus.get(i) == "O") {
                upResult += "O";
                downResult += " ";
            }
            if (userInput.get(i) == "U" && userStatus.get(i) == "X") {
                upResult += "X";
                downResult += " ";
            }
            if (userInput.get(i) == "D" && userStatus.get(i) == "O") {
                upResult += " ";
                downResult += "O";
            }
            if (userInput.get(i) == "D" && userStatus.get(i) == "X") {
                upResult += " ";
                downResult += "X";
            }
            if (i != size - 1) {
                upResult += " | ";
                downResult += " | ";
            }
        }
        upResult += "]";
        downResult += "]";

        System.out.println(upResult);
        System.out.println(downResult);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
