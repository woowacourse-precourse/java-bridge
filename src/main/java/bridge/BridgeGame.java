package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static List<String> correctBridge;
    public void setCorrectBridge(List<String> correctBridge) {
        this.correctBridge = correctBridge;
    }
    public List<String> getCorrectBridge() {
        return correctBridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String choice, int bridgeNumber) {
        List<String> upBridge = new ArrayList<>();
        List<String> downBridge = new ArrayList<>();
        String correct = getCorrectBridge().get(bridgeNumber);
        if (choice.equals("U")) {
            downBridge.set(bridgeNumber, " ");
            if (correct.equals("U")) {
                upBridge.set(bridgeNumber, "O");
                return;
            }
            upBridge.set(bridgeNumber, "X");
            return;
        }
        upBridge.set(bridgeNumber, " ");
        if (correct.equals("U")) {
            downBridge.set(bridgeNumber, "X");
            return;
        }
        downBridge.set(bridgeNumber, "O");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String choice) {
        if (choice.equals("Q")) {
            System.out.println("최종 게임 결과");
            OutputView outputView = new OutputView();
            outputView.printResult();
        }
    }
}
