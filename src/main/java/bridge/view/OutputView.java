package bridge.view;

import java.util.List;

public class OutputView {

    public void printMap(List<String> toStringBridges) {
        System.out.println(toStringBridges.get(0) + "\n" + toStringBridges.get(1) + "\n");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
