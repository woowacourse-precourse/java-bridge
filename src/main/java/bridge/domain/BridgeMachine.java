package bridge.domain;

import bridge.resource.GameResult;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.resource.UserCommand;

public class BridgeMachine {
    private int totalTry = 1;
    private int index = 0;
    private boolean success = false;
    private static final String canCross ="O";
    private static final String cantCross = "X";

    public void initiateBridgeMachine() {
        BridgeGame bridgeGame = bridgeGameStart();
        Bridge bridge = getBridge();
        playBridgeGame(bridgeGame, bridge);
        printAfterGame(bridge);
    }

    private void playBridgeGame(BridgeGame bridgeGame, Bridge bridge) {
        while (true) {
            if (!checkUserCanMove(bridgeGame, bridge, getUserCommand())) break;
            if (checkLastIndex(bridge)) break;
        }
    }
    private BridgeGame bridgeGameStart() {
        BridgeGame bridgeGame = new BridgeGame();
        OutputView.gameStart();
        return bridgeGame;
    }
    private boolean checkUserCanMove(BridgeGame bridgeGame, Bridge bridge, String userMoveCommand) {
        if(bridgeGame.move(userMoveCommand,bridge,index)){
            bridge.changeBridgeMap(index,userMoveCommand,canCross);
            OutputView.printMap(bridge.getBridgeMap(),index);
            index++;
            return true;
        }
        bridge.changeBridgeMap(index, userMoveCommand, cantCross);
        OutputView.printMap(bridge.getBridgeMap(),index);
        return checkReplay(bridgeGame, bridge,getReplayCommand());
    }

    private boolean checkReplay(BridgeGame bridgeGame, Bridge bridge, String replay) {
        if (replay.equals(UserCommand.REPLAY.getCommand())) {
            bridgeGame.retry(bridge);
            totalTry++;
            index = 0;
            return true;
        }
        return false;
    }

    private String getReplayCommand() {
        while (true) {
            try {
                OutputView.inputUserReplayCommand();
                return InputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private String getUserCommand() {
        while (true) {
            try {
                OutputView.inputUserMoveCommand();
                return InputView.readMoving();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private boolean checkLastIndex(Bridge bridge) {
        if (index == bridge.getBridgeSize()) {
            success = true;
            index--;
            return true;
        }
        return false;
    }

    private Bridge getBridge() {
        while (true) {
            try {
                return validateBridge();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private Bridge validateBridge() {
        Bridge bridge;
        OutputView.inputBridgeSize();
        String bridgeSize = InputView.readBridgeSize();
        bridge = new Bridge(bridgeSize);
        return bridge;
    }

    private void printAfterGame(Bridge bridge) {
        OutputView.printLastBridgeResult();
        OutputView.printMap(bridge.getBridgeMap(), index);
        printGameResult();
        OutputView.printTotalTry(totalTry);
    }

    private void printGameResult() {
        if (success == GameResult.FAILED.getTrueOrFalse()) {
            OutputView.printResult(GameResult.FAILED);
        }
        if (success == GameResult.PASSED.getTrueOrFalse()) {
            OutputView.printResult(GameResult.PASSED);
        }
    }
}
