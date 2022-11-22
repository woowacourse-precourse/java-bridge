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
        int bridgeSize = -1;
        try {
            bridgeSize = inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 다리 길이는 3 이상 20 이하의 숫자로 입력해 주세요");
        }
        this.answerBridge = bridgeMaker.makeBridge(bridgeSize);
        boolean isContinue;
        int count = 0;
        do {
            count++;
            isContinue = eachGame(bridgeSize);
        } while (isContinue);
        outputView.printResult(curMap, answerBridge, count);
    }

    public boolean eachGame(int bridgeSize) {
        this.curMap = new ArrayList<>();

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

        boolean moveAvailable = false;
        try {
            moveAvailable = getMove(turn);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] U 또는 R 만 입력해주세요.");
            moveAvailable = getMove(turn);
        }

        return moveAvailable;
    }

    public boolean getMove(int turn) {
        String moving = inputView.readMoving();

        if (!(moving.equals("U") || moving.equals("D"))) {
            throw new IllegalArgumentException();
        }
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
        boolean inputResult = false;
        try {
            inputResult = retryInput();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] R 또는 Q 를 입력해주세요.");
            retryInput();
        }
        return inputResult;
    }

    public boolean retryInput() {
        String retryCommand = inputView.readGameCommand();
        if (retryCommand.equals("R")) {
            return true;
        } else if (retryCommand.equals("Q")) {
            return false;
        } else throw new IllegalArgumentException();
    }
}
