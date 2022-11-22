package bridge;

import message.InputMessage;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static int index = -1;

    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public BridgeGame() {
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(List<String> answerBridge, List<String> upBridge, List<String> downBridge) {
        index += 1;
        String direction = inputView.readMoving();
        if (direction.equals(answerBridge.get(index))) {
            if (direction.equals(InputMessage.UP)) {
                upBridge.add("X" + " ");
                downBridge.add(" " + " ");
            } else {
                upBridge.add(" " + " ");
                downBridge.add("X" + " ");
            }
            outputView.printMap(upBridge, downBridge);
            return false;
        }
        if (direction.equals(InputMessage.UP)) {
            upBridge.add("O" + " ");
            downBridge.add(" " + " ");
        } else {
            upBridge.add(" " + " ");
            downBridge.add("O" + " ");
        }
        outputView.printMap(upBridge,downBridge);
        return true;
    }



    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
