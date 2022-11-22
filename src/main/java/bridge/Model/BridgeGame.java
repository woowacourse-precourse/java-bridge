package bridge.Model;

import java.util.List;

import bridge.View.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static BridgeRandomNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
    private static BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
    public static OutputView outputView = new OutputView();

    private static int position = 0;
    private int attempt = 1;

    private List<String> bridge;

    public BridgeGame(int size) {
        this.bridge = bridgeMaker.makeBridge(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String moving) {
        // /String moving = inputView.readMoving();
        outputView.buildIndex(moving, isTransferable(moving, position), position);
        outputView.printMap();
        if (isGameOver(isTransferable(moving, position)) == true) {
            return isTransferable(moving, position);
        }
        this.position++;
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        if (command.equals("Q")) {
            outputView.printResult(isSuccess(), this.attempt);
            return false;
        }
        this.position = 0;
        this.attempt++;
        outputView.resetIndex();
        return true;
    }

    public boolean isGameOver(String result) {
        if (result.equals("X")) {
            return true;
        }
        return false;
    }

    private String isTransferable(String moving, int index) {
        if (bridge.get(index).equals(moving)) {
            return "O";
        }
        return "X";
    }

    public boolean isSuccess() {
        if (this.position == this.bridge.size()) {
            return true;
        }
        return false;
    }

    public void getResult() {
        outputView.printResult(isSuccess(), attempt);
    }

}
