package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.util.MoveResult;
import bridge.domain.Bridge;
import bridge.view.BridgeView;
import java.util.List;

public class BridgeGame {
    final BridgeView view;
    final Bridge domain;

    public BridgeGame(BridgeView view, Bridge domain) {
        this.view = view;
        this.domain = domain;
    }

    public void startGame() {
        view.printStartMassage();
        makeBridge();
        move();
    }

    public void move() {
        try {
            view.printMoveCommandMessage();
            String movePath = view.readMoving();
            MoveResult moveResult = domain.move(movePath);
            selectActAfterMove(moveResult);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            move();
        }
    }

    public void retryOrEnd() {
        view.printRestartMassage();
        try {
            String command = view.readGameCommand();
            selectActAfterGame(command);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            retryOrEnd();
        }
    }

    public void end() {
        view.printEndMassage();
        List<List<String>> map = domain.getMap();
        boolean result = domain.isGameSuccess();
        int tryCount = domain.getTryCount();
        view.printGameResult(map, result, tryCount);
    }

    public void retry() {
        domain.initBridge();
        move();
    }

    private void selectActAfterGame(String command) {
        if (command.equals("Q")) {
            end();
        }
        if (command.equals("R")) {
            retry();
        }
    }

    private void selectActAfterMove(MoveResult moveResult) {
        if (moveResult == MoveResult.MOVE_FAIL) {
            actAfterMoveFail();
        }
        if (moveResult == MoveResult.MOVE_SUCCESS) {
            actAfterMoveSuccess();
        }
        if (moveResult == MoveResult.PASSED_BRIDGE) {
            actAfterPassedBridge();
        }
    }

    private void actAfterPassedBridge() {
        printBridge();
        end();
    }

    private void actAfterMoveSuccess() {
        printBridge();
        move();
    }

    private void actAfterMoveFail() {
        printBridge();
        retryOrEnd();
    }

    private void makeBridge() {
        try {
            view.printBridgeSizeMessage();
            int bridgeSize = view.readBridgeSize();
            domain.makeBridge(bridgeSize, new BridgeMaker(new BridgeRandomNumberGenerator()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            makeBridge();
        }
    }
    private void printBridge() {
        List<List<String>> map = domain.getMap();
        view.printMap(map);
    }
}
