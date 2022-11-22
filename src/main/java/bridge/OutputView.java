package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    String up = "[", down = "[";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge) {
        for (int i = 0; i < bridge.size()-1; i++) {
            if (bridge.get(i).equals("OU")) up += " O |";
            if (!bridge.get(i).equals("OU")) up += "   |";
            if (bridge.get(i).equals("OD")) down += " O |";
            if (!bridge.get(i).equals("OD")) down += "   |";
        }
        lastUpDown(bridge);
        printUpDown();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge) {
        for (int i = 0; i < bridge.size()-1; i++) {
            if (bridge.get(i).equals("OU")) up += " O |";
            if (!bridge.get(i).equals("OU")) up += "   |";
            if (bridge.get(i).equals("OD")) down += " O |";
            if (!bridge.get(i).equals("OD")) down += "   |";
        }
        lastUpDown(bridge);
        printUpDown();
    }

    public void lastUpDown(List<String> bridge) {
        if (bridge.get(bridge.size()-1).equals("OU")) up += " O ";
        if (!bridge.get(bridge.size()-1).equals("OU")) up += "   ";
        if (bridge.get(bridge.size()-1).equals("OD")) down += " O ";
        if (!bridge.get(bridge.size()-1).equals("OD")) down += "   ";
        up += "]";
        down += "]";
    }

    public void printUpDown() {
        System.out.println(up);
        System.out.println(down);
    }
}
