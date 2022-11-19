package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.Judge;
import bridge.model.*;
import bridge.view.Input;
import bridge.view.Output;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    Input input;
    Output output;

    List<String> bridge = new ArrayList<>();
    List<String> userBridge = new ArrayList<>();

    Judge judge = new Judge();

    public BridgeGame(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void run() {
        BridgeSize bridgeSize = input.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(bridgeSize.getBridgeSize());
        GameResult gameResult;
        GameCommand gameCommand = null;
        do {
            userBridge = new ArrayList<>();
            gameResult = moveAndPrintResult();
            if (gameResult == GameResult.LOSE) {
                gameCommand = input.readGameCommand();
            }
        } while (!(gameResult == GameResult.WIN || gameCommand == GameCommand.QUIT));


    }


    private GameResult moveAndPrintResult() {
        MoveResult moveResult;
        do {
            moveResult = move();
            printMapResult();
        } while (moveResult == MoveResult.CORRECT && userBridge.size() != bridge.size());
        if (moveResult == MoveResult.CORRECT) return GameResult.WIN;
        return GameResult.LOSE;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MoveResult move() {
        Moving moving = input.readMoving();
        userBridge.add(moving.getValue());
        return judge.checkIsCorrectMoving(bridge, userBridge);
    }


    private void printMapResult() {
        judge.makeResult(bridge, userBridge);
        output.printMap(judge.toString());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }


}
