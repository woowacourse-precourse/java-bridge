package bridge.controller;

import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.Player;
import bridge.model.Referee;
import bridge.type.ErrorType;
import bridge.valid.Validation;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    public static int BRIDGE_LENGTH = 0;
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BridgeGame bridgeGame = new BridgeGame();
    private Bridge bridge = new Bridge();
    private Player player = new Player();
    private Referee referee = new Referee();

    /**
     * 초기화 작업 필요
     */

    public void play() {
        outputView.printStartGame();
        generateBridge();
        while (isFlagTrue()) {
            String moveType = moveCommand();
            printMove(moveType);
            if (referee.isClear() && Referee.succeed) {
                break;
            }
        }
        printResult();
    }

    public boolean isFlagTrue(){
        if ((Referee.succeed && !referee.isClear()) || bridgeGame.retry(getCommand(),player, referee)) {
            return true;
        }
        return false;
    }

    public String moveCommand(){
        String moveType = "";
        try {
            moveType = inputView.readMoving();
            Validation.inputMoveSquareValid(moveType);
        } catch (IllegalArgumentException e) {
            inputView.printError(ErrorType.INPUT_SQUARE_ERROR_TYPE.getText());
            moveCommand();
        }
        bridgeGame.move(moveType, player);
        return moveType;
    }

    public void printResult() {
        outputView.printEndGame();
        outputView.printMap(referee.getUpSideBridgeResult(), referee.getDownSideBridgeResult());
        outputView.printResult(bridgeGame.holeGameCount);
    }

    public void generateBridge() {
        try {
            BRIDGE_LENGTH = inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            inputView.printError(ErrorType.INPUT_BRIDGE_SIZE_ERROR_TYPE.getText());
            generateBridge();
        }
        bridge.setBridge(BRIDGE_LENGTH);
    }

    private void printMove(String moveType) {
        referee.addPlayerChoiceResult(bridge.getBridge(), moveType, referee.getProgressCount());
        outputView.printMap(referee.getUpSideBridgeResult(), referee.getDownSideBridgeResult());
        referee.addProgressCount();
    }

    private String getCommand() {
        String command = inputView.readGameCommand();
        try {
            Validation.inputResumeCommandValid(command);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorType.INPUT_RESUME_COMMAND_ERROR_TYPE.getText());
            bridgeGame.retry(command, player, referee);
        }
        return command;
    }
}
