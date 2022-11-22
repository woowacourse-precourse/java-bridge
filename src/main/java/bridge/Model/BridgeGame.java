package bridge.Model;

import bridge.Controller.BridgeGameController;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static String[] Result;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public static boolean move(List<String> bridge) {
        List<String> userBridge = new ArrayList<>();
        for (int i = 0; i < bridge.size(); i++) {
            InputView inputView = new InputView();
            String MovingSquare = inputView.readMoving();
            userBridge.add(MovingSquare);
            Result = OutputView.print(bridge, userBridge);
            OutputView.printGame(Result);
            if (!Objects.equals(userBridge.get(i), bridge.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean userSuccess(String userBridgeWord, String bridgeWord) {
        if (!Objects.equals(userBridgeWord, bridgeWord)) {
            return false;
        }
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void retry() {
        InputView inputView = new InputView();
        String retryCommand = inputView.readGameCommand();
        if (Objects.equals(retryCommand, "Q")) {
            boolean fail = false;
            OutputView.printResult(Result, fail);
            BridgeGameController.end = false;
        }
    }
}
