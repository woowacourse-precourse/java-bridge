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
    public void printMap(List<String> bridge, List<String> userInput) {
        String upResult = "[ ";
        String downResult = "[ ";
        for (int i = 0; i < userInput.size(); i++) {
            upResult += setUpResult(bridge.get(i), userInput.get(i));
            downResult += setDownResult(bridge.get(i), userInput.get(i));
            upResult += setPartition(i, userInput.size());
            downResult += setPartition(i, userInput.size());
        }
        System.out.println(upResult + " ]\n" + downResult + " ]\n");
    }

    private String setUpResult(String bridge, String userInput) {
        String x = isSame(bridge, userInput);
        if (userInput.equals("U"))
            return x;
        return " ";
    }

    private String setDownResult(String bridge, String userInput) {
        String x = isSame(bridge, userInput);
        if (userInput.equals("D"))
            return x;
        return " ";
    }

    private String setPartition(int i, int size) {
        if (i != size - 1)
            return " | ";
        return "";
    }

    private String isSame(String bridge, String userInput) {
        if (bridge.equals(userInput)) {
            return "O";
        }
        return "X";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, List<String> userInput, int cnt) {
        System.out.println("최종 게임 결과");
        printMap(bridge, userInput);

        String gameResult = "실패";
        if (userInput.equals(bridge))
            gameResult = "성공";

        System.out.println("게임 성공 여부: " + gameResult);
        System.out.println("총 시도한 횟수: " + Integer.toString(cnt));
    }
}
