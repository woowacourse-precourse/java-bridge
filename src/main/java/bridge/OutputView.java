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

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void clearMap() {
        upStr.clear();
        downStr.clear();
    }
}
