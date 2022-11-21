package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;

    private int trial;

    private List<String> savedBridge;
    private int savedPos;
    private boolean savedCorrect;

    BridgeGame(BridgeMaker bridgeMaker, InputView inputView, OutputView outputView) {
        this.bridgeMaker = bridgeMaker;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playGameCatchingException() {
        try {
            playGame();
        } catch(IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    public void playGame() {
        boolean success;
        startGame();

        do {
            success = crossBridge();
        } while(!success && retry());

        gameResult(success);
    }

    private void startGame() {
        outputView.printStartGameMessage();
        trial = 0;
    }

    private boolean crossBridge() {
        int size;
        trial++;

        outputView.printAskSizeMessage();
        size = inputView.readBridgeSize();

        return move(bridgeMaker.makeBridge(size));
    }

    private void gameResult(boolean success) {
        outputView.printFinalState(savedBridge, savedPos, savedCorrect);
        outputView.printResult(success, trial);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(List<String> bridge) {
        boolean correct = true;
        saveBridgeState(bridge);
        for(int pos = 0; pos < bridge.size() && correct; pos++) {
            outputView.printAskMoveMessage();
            correct = inputView.readMoving().equals(bridge.get(pos));

            outputView.printMap(bridge, pos, correct);
            saveState(pos, correct);
        }
        return correct;
    }

    private void saveBridgeState(List<String> bridge) {
        this.savedBridge = bridge;
    }

    private void saveState(int pos, boolean correct) {
        this.savedPos = pos;
        this.savedCorrect = correct;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String userInput;

        outputView.printAskRetryMessage();
        userInput = inputView.readGameCommand();

        return userInput.equals("R");
    }
}
