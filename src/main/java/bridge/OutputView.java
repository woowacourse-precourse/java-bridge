package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final List<String> upStr = new ArrayList<>();
    private final List<String> downStr = new ArrayList<>();

    public void printMap() {
        String upperBridge = "[" + " ";
        String bottomBridge = "[" + " ";

        upperBridge = String.join(" | ", upStr);
        bottomBridge = String.join(" | ", downStr);

        System.out.println(upperBridge + " " + "]");
        System.out.println(bottomBridge + " " + "]");
    }

    public void printResult() {
        printMap();
    }

    public void clearMap() {
        upStr.clear();
        downStr.clear();
    }
}
