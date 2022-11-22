package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.AllBridge;
import bridge.view.InputMessage;
import bridge.view.OutputView;

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
        do {
            System.out.println(InputMessage.MOVE.getInputMsg());
            bridgeGame.move(inputController.getMoving(), allBridge);
            outputView.printMap(outputController.getUpper(), outputController.getLower());
        } while (!bridgeGame.retry(allBridge));
    }
}
