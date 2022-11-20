package bridge;

import bridge.Message.Message;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    BridgeMaker bridgeMaker;
    InputView inputView;
    OutputView outputView;

    private List<String> upperBridge;
    private List<String> lowerBridge;
    private List<String> answerBridge;
    private int bridgeIndex;

    public void setAnswerBridge(List<String> answerBridge) {
        this.answerBridge = answerBridge;
    }

    public List<String> getAnswerBridge() {
        return answerBridge;
    }

    public BridgeGame() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        inputView = new InputView();
        outputView = new OutputView();
        upperBridge = new ArrayList<>();
        lowerBridge = new ArrayList<>();
        bridgeIndex = 0;
    }

    public void playGame() {
        outputView.printGameStart();
        setAnswerBridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        List<String> bridge = getAnswerBridge();
        while (bridgeIndex < bridge.size()) {
            if (move(inputView.readMoving()) == false) {
                outputView.printMap(upperBridge, lowerBridge);
                String retryFlag = inputView.readGameCommand();
                if (retryFlag.equals("Q")) {
                    break;
                }
                if (retryFlag.equals("R")) {
                    retry();
                    continue;
                }
            }
            outputView.printMap(upperBridge, lowerBridge);
            bridgeIndex++;
        }
        outputView.printResult(upperBridge, lowerBridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String direction) {
        if (!answerBridge.get(bridgeIndex).equals(direction)) {
            addWrongBridgeResult(direction);
            return false;
        }
        addBridgeResult(direction);
        return true;
    }

    private void addBridgeResult(String direction) {
        if (direction.equals("U")) {
            upperBridge.add("O");
            lowerBridge.add(" ");
        }
        if (direction.equals("D")) {
            upperBridge.add(" ");
            lowerBridge.add("O");
        }
    }

    private void addWrongBridgeResult(String direction) {
        if (direction.equals("U")) {
            upperBridge.add("X");
            lowerBridge.add(" ");
        }
        if (direction.equals("D")) {
            upperBridge.add(" ");
            lowerBridge.add("X");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        bridgeIndex = 0;
        upperBridge.clear();
        lowerBridge.clear();
    }
}
