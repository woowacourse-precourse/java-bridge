package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private InputView inputView;
    private OutputView outputView;

    public BridgeGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(List<String> bridge) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < bridge.size(); i++) {
            String movingValue = inputView.readMoving();

            if (movingValue.equals(bridge.get(i))) {
                result.add("O");
            } else {
                result.add("X");
            }
            outputView.printMap(result, bridge);
            if (result.contains("X")) {
                return "fail";
            }
        }
        return "success";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String retry(List<String> bridge) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < bridge.size(); i++) {
            String movingValue = inputView.readMoving();

            if (movingValue.equals(bridge.get(i))) {
                result.add("O");
            } else {
                result.add("X");
            }
            outputView.printMap(result, bridge);
            if (result.contains("X")) {
                return "fail";
            }
        }
        return "success";
    }
}
