package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    final static int MAX_BRIDGE_SIZE = 20;
    private int count = 0;
    private String bridge = "";
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String printMap(List<String> yesOrNo, List<String> upAndDown, int size) {
        String[][] bridges = new String[2][];


        for(int i = 0; i < size; i++) {
            if(yesOrNo.get(i) == "O" && upAndDown.get(i) == "U") {
                bridges[0][i] = "O";
            }
            if(yesOrNo.get(i) == "O" && upAndDown.get(i) == "D") {
                bridges[1][i] = "O";
            }
            if(yesOrNo.get(i) == "X") {
                break;
            }
            this.count++;
            this.bridge = Arrays.deepToString(bridges);
            this.bridge.replaceAll(",", "|");
            System.out.println(this.bridge);
        }
        return this.bridge;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> yesOrNo, String bridge) {
        System.out.println("최종 게임 결과");
        System.out.println(this.bridge);

        if(yesOrNo.contains("X")) {
            System.out.println("게임 성공 여부 : 실패");
        }
        if(!yesOrNo.contains("X")) {
            System.out.println("게임 성공 여부 : 성공");
        }
        System.out.printf("총 시도한 횟수: %d", this.count);
    }
}
