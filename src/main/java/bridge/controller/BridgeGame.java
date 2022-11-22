package bridge.controller;

import java.util.ArrayList;
import java.util.List;

import bridge.model.BridgeMaker;
import bridge.utils.BridgeRandomNumberGenerator;
import bridge.utils.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int bridgeSize;
    private List<String> bridge;
    private int attemptCount = 0;
    boolean isCross;
    int round;
    InputView inputView = new InputView();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    OutputView outputView = new OutputView();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(int round, String moveKey) {
        String crossablePosition = bridge.get(round);
        if (moveKey.equals("U") && Integer.parseInt(crossablePosition) == 0)
            return true;
        if (moveKey.equals("D") && Integer.parseInt(crossablePosition) == 1)
            return true;
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String command = inputView.readGameCommand();
        Validator.checkValueOfReadGameCommand(command);
        if (command.equals("R"))
            return true;
        return false;
    }

    public void playGame(List<String> bridge) {
        this.bridge = bridge;
        while (true) {
            if (!moveBridge())
                break;
            if (!retry())
                break;
        }
        printResult(round, isCross, attemptCount);
    }

    public List<String> makeBridge() {
        bridgeSize = readBridgeSize();
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public boolean moveBridge() {
        round = 0;
        attemptCount++;
        while (round != bridge.size()) {
            isCross = move(round, readBridgeMove());
            printMap(round, isCross);
            if (!isCross)
                break;
            round++;
        }
        if (round == bridge.size())
            return false;
        return true;
    }

    public void printResult(int round, boolean isCross, int attemptCount) {
        List<String> usedMap = new ArrayList<>(bridge.subList(0, round));
        outputView.printResult(usedMap, isCross, attemptCount);
    }

    public void printMap(int round, boolean isCross) {
        List<String> usedMap = new ArrayList<>(bridge.subList(0, round + 1));

        outputView.printMap(usedMap, isCross);
    }

    public int readBridgeSize() {
        int inputBridgeSize = inputView.readBridgeSize();
        Validator.checkValueOfReadBridgeSize(inputBridgeSize);
        return inputBridgeSize;
    }

    public String readBridgeMove() {
        String inputBridgeMove = inputView.readMoving();
        Validator.checkValueOfReadBridgeMove(inputBridgeMove);
        return inputBridgeMove;
    }
}
