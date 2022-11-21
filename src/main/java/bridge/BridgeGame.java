package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;
    private List<String> answerBridge;
    private List<String> curMap;

    public BridgeGame() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {
        boolean isContinue;
        do {
            isContinue = eachGame();
        } while (isContinue);
    }

    public boolean eachGame() {
        this.curMap = new ArrayList<>();
        int bridgeSize = inputView.readBridgeSize();
        this.answerBridge = bridgeMaker.makeBridge(bridgeSize);

        boolean isQuit = false;
        for (int i = 0; i < bridgeSize; i++) {
            if (!move(i)) {
                isQuit = retry();
                break;
            }
        }

        return isQuit;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(int turn) {
        String moving = inputView.readMoving();
        this.curMap.add(moving);
        outputView.printMap(this.curMap, this.answerBridge);

        return curMap.get(turn).equals(answerBridge.get(turn));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String retryCommand = inputView.readGameCommand();
        if (retryCommand.equals("R")) {
            return true;
        } else if (retryCommand.equals("Q")) {
            return false;
        } else
            throw new IllegalArgumentException();
    }
}
