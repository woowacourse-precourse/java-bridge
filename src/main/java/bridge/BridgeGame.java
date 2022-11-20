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
    private boolean isSuccess;
    private int tryCount;

    private static final String SUCCESS = "성공";
    private static final String FAILURE = "실패";


    public BridgeGame() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        inputView = new InputView();
        outputView = new OutputView();
        upperBridge = new ArrayList<>();
        lowerBridge = new ArrayList<>();
        bridgeIndex = 0;
        isSuccess = true;
        tryCount = 0;
    }

    public void setAnswerBridge(List<String> answerBridge) {
        this.answerBridge = answerBridge;
    }

    public List<String> getAnswerBridge() {
        return answerBridge;
    }

    public void playGame() {
        outputView.printGameStart();
        List<String> bridge = makeAnswerBridge();
        pickMovingDirection(bridge);
        outputView.printResult(upperBridge, lowerBridge);
        System.out.print(Message.GAME_SUCCESS_OR_FAILURE);
        showWhetherGameSuccess();
    }

    private void showWhetherGameSuccess() {
        if(isSuccess){
            System.out.println(SUCCESS);
        }
        if(!isSuccess){
            System.out.println(FAILURE);
        }
    }

    private void pickMovingDirection(List<String> bridge) {
        while (bridgeIndex < bridge.size()) {
            if (move(inputView.readMoving()) == false) {
                outputView.printMap(upperBridge, lowerBridge);
                String retryFlag = inputView.readGameCommand();
                if (isQuit(retryFlag)) break;
                if (isRetry(retryFlag)) continue;
             }
            outputView.printMap(upperBridge, lowerBridge);
            bridgeIndex++;
        }
    }

    private List<String> makeAnswerBridge() {
        setAnswerBridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        List<String> bridge = getAnswerBridge();
        return bridge;
    }

    private boolean isRetry(String retryFlag) {
        if (retryFlag.equals("R")) {
            retry();
            return true;
        }
        return false;
    }

    private boolean isQuit(String retryFlag) {
        if (retryFlag.equals("Q")) {
            isSuccess = false;
            return true;
        }
        return false;
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
        tryCount++;
        upperBridge.clear();
        lowerBridge.clear();
    }
}
