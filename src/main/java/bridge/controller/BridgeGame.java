package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.*;
import bridge.view.Input;
import bridge.view.Output;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Input input;
    private final Output output;
    private Judge judge;
    private int gameCount;

    public BridgeGame(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void run() {
        BridgeSize bridgeSize = input.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        judge = new Judge(bridgeMaker.makeBridge(bridgeSize.getBridgeSize()));
        GameResult gameResult = play();
        output.printResult(judge, gameResult, gameCount);
    }

    private GameResult play() {
        GameResult gameResult;
        GameCommand gameCommand = null;
        do {
            judge.initUserBridge();
            gameResult = moveAndPrintResult();
            if (gameResult == GameResult.LOSE) gameCommand = input.readGameCommand();
            gameCount++;
        } while (retry(gameResult, gameCommand));
        return gameResult;
    }

    private GameResult moveAndPrintResult() {
        MoveResult moveResult;
        do {
            moveResult = move();
            output.printMap(judge);
        } while (judge.isGameEnd(moveResult));
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
        judge.addUserBridge(moving);
        return judge.checkIsCorrectMoving(moving);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(GameResult gameResult, GameCommand gameCommand) {
        return gameResult == GameResult.LOSE && gameCommand == GameCommand.RE_GAME;
    }


}
