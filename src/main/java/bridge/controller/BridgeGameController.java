package bridge.controller;

import static bridge.view.SystemMessage.*;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.MoveResult;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {

    public BridgeGameController() {
        playGame();
    }

    public void playGame() {
        Bridge bridge = null;
        while (bridge == null) {
            bridge = startGameWithValidation();
        }
        runGame(bridge);
    }

    public Bridge startGameWithValidation() {
        Bridge bridge = null;
        try {
            bridge = InputController.getBridge();
        } catch (NumberFormatException e) {
            System.out.println(ERROR_MESSAGE + NOT_NUMBER_ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return bridge;
    }

    public static void runGame(Bridge bridge) {
        List<MoveResult> moveResults = new ArrayList<>();
        BridgeGame bridgeGame = new BridgeGame(moveResults, bridge);
        while (bridge.crossingBridgeSuccess() && bridgeGame.notExit()) {
            abilityToMove(bridgeGame);
            if (retryOrOver(bridgeGame)) {
                moveResults = new ArrayList<>();
                continue;
            }
            bridge.nextStep();
        }
        gameOver(bridgeGame, moveResults);
    }

    private static void abilityToMove(BridgeGame bridgeGame) {
        bridgeGame.move();
        OutputView.printMap(bridgeGame.getMoveResults());
    }

    private static boolean retryOrOver(BridgeGame bridgeGame) {
        if (bridgeGame.isFailedGame()) {
            if (doRetryOrOver(bridgeGame,getRetryOrOverCommand())){
                return true;
            }
        }
        return false;
    }

    private static boolean doRetryOrOver(BridgeGame bridgeGame, String command){
        if (command.equals("R")) {
            bridgeGame.retry();
            return true;
        }
        bridgeGame.exit();
        return false;
    }
    private static String getRetryOrOverCommand(){
        String command = null;
        while(command == null){
            try{
                command = InputController.retryOrGameOver();
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return command;
    }

    private static void gameOver(BridgeGame bridgeGame, List<MoveResult> moveResults) {
        OutputView.printResult(bridgeGame, moveResults);
    }

}
