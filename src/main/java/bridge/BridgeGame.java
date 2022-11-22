package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private InputView inputView;
    private BridgeMaker bridgeMaker;
    private OutputView outputView;
    private int stepCnt = 0;
    private int isAnswer = 1;
    private List<String> bridge;

    public BridgeGame(InputView inputView, BridgeMaker bridgeMaker, OutputView outputView) {
        this.inputView = inputView;
        this.bridgeMaker = bridgeMaker;
        this.outputView = outputView;
    }

    public boolean startGame() {
        outputView.printStartComment();
        bridge = setBridgeBySize();
        progressGame();
        if(isAnswer == 1) {
            endGame();
            return false;
        }
        return retry();
    }

    public void progressGame() {
        while (true) {
            outputView.printMoveQuestion();
            if(move(inputView.readMoving()) == false) {
                isAnswer = 0;
                outputView.printMap(stepCnt, bridge, isAnswer);
                break; }
            outputView.printMap(stepCnt, bridge, isAnswer);
            if(getStepCnt() == bridge.size()) break;
        }
    }

    public void endGame() {
        outputView.printResult(stepCnt, bridge, isAnswer);
    }

    public int getStepCnt() {
        return stepCnt;
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public boolean move(String nextStep) {
        if(bridge.get(stepCnt).charAt(0) == nextStep.charAt(0)) {
            stepCnt++;
            return true;
        }
        stepCnt++;
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        outputView.printRestartQuestion();
        String retryGameCommand = inputView.readGameCommand();
        return compareRetryGameComman(retryGameCommand.charAt(0));
    }

    public boolean compareRetryGameComman(char c) {
        if(c == 'R') {
            return true;
        }
        if(c == 'Q') {
            endGame();
            return false;
        }
        return true;
    }

    public List<String> setBridgeBySize() {
        int bridgeSize = inputView.inputBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
        return bridge;
    }

    public void setBridge(List<String> inputString) {
        this.bridge = inputString;
    }

    public void setBridgeStepCnt(int num) {
        this.stepCnt = num;
    }
}
