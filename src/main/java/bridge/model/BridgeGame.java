package bridge.model;

import bridge.controller.GameController;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    static int moveIndex = 0;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void move(InputView inputView, OutputView outputView, List<String> bridgeResult) {
        boolean flag = false;
        while (bridgeResult.size() > moveIndex) {
            outputView.moveSpace();
            String moveInput = inputView.readMoving();
            if (!Comparison.comparisonSpace(moveInput, bridgeResult)) {
                flag = retry(inputView, outputView, bridgeResult, moveInput);
                if(flag) {
                    return;
                }
                continue;
            }
            outputView.printMap(moveIndex, moveInput, bridgeResult);
            moveIndex++;
        }
        GameController.failOrSuccess = true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static boolean retry(InputView inputView, OutputView outputView, List<String> bridgeResult, String moveInput) {
        outputView.printMap(moveIndex, moveInput, bridgeResult);
        outputView.restart();
        if(inputView.readGameCommand().equals("Q")) {
            return true;
        }
        OutputView.first = new StringBuilder();
        OutputView.second = new StringBuilder();
        moveIndex = 0;
        GameController.gameCount++;
        return false;
    }
}
