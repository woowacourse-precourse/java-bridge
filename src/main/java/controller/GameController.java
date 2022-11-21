package controller;

import model.BridgeGame;
import model.AllBridge;
import model.BridgeState;
import view.InputMessage;
import view.InputView;
import view.OutputView;

public class GameController {
    InputController inputController = new InputController();
    OutputController outputController = new OutputController();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame = new BridgeGame();

    public void gameStart() {
        System.out.println(InputMessage.GAME_START.getInputMsg());
        System.out.println(InputMessage.BRIDGE_LENGTH.getInputMsg());
        AllBridge allBridge = new AllBridge();

        game(allBridge);
        outputView.printResult(bridgeGame,outputController.getUpper(), outputController.getLower());
    }

    public void game(AllBridge allBridge) {
        while(true) {
            System.out.println(InputMessage.MOVE.getInputMsg());
            bridgeGame.move(inputController.getMoving(), allBridge);
            outputView.printMap(outputController.getUpper(), outputController.getLower());
            if(bridgeGame.retry(allBridge)) { break; }
        }
    }
}
