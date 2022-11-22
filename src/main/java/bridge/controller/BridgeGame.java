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
        if (moveKey == "U" && Integer.parseInt(crossablePosition) == 0)
            return true;
        if (moveKey == "D" && Integer.parseInt(crossablePosition) == 1)
            return true;
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public void playGame(List<String> bridge) {
        this.bridge = bridge;
        moveBridge();

        // if 종료 선택시 결과값 리폿
        // 클리어시 결과값 리폿
    }

    public List<String> makeBridge() {
        bridgeSize = readBridgeSize();
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public void moveBridge() {
        int round = 0;
        attemptCount++;
        while (true) {
            boolean isCross = move(round, readBridgeMove());
            printMap(round, isCross);
            // round = nextRound;

            // 지도 출력해주기.
            round++;
            if (!isCross)
                break;
        }
        // 게임 결과 출력 및 계속 진행 여부
    }

    public void printMap(int round, boolean isCross) {
        List<String> usedMap = new ArrayList<>(bridge.subList(0, round));
        usedMap.add(addLastCross(round, isCross));

        outputView.printMap(usedMap);
    }

    public String addLastCross(int round, boolean isCross) {
        if (isCross)
            return bridge.get(round);
        return "-1";
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
