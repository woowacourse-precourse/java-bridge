package bridge.controller;

import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.Player;
import bridge.model.Referee;
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
        if ((Referee.succeed && !referee.isClear()) || bridgeGame.retry(retryCommand(),player, referee)) {
            return true;
        }
        return false;
    }

    public String moveCommand(){
        String moveType = inputView.readMoving();
        bridgeGame.move(moveType, player);
        return moveType;
    }

    public void printResult() {
        outputView.printEndGame();
        outputView.printMap(referee.getUpSideBridgeResult(), referee.getDownSideBridgeResult());
        outputView.printResult(bridgeGame.totalGameCount);
    }

    public void generateBridge() {
        BRIDGE_LENGTH = inputView.readBridgeSize();
        bridge.setBridge(BRIDGE_LENGTH);
    }

    private void printMove(String moveType) {
        referee.addPlayerChoiceResult(bridge.getBridge(), moveType, referee.getProgressCount());
        outputView.printMap(referee.getUpSideBridgeResult(), referee.getDownSideBridgeResult());
        referee.addProgressCount();
    }

    public String retryCommand() {
        String command = inputView.readGameCommand();
        return command;
    }
}
