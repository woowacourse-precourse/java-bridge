package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.LengthBridge;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridgelocation;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.Utility;

import java.util.List;

public class BridgeGameController {
    private final OutputView outputView;
    private final InputView inputView;

    public BridgeGameController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void gameStart() {
        outputView.printgameStart();
        List<String> bridges = InputController.getBridgeMaker();
        BridgeGame bridgeGame = new BridgeGame();
        boolean restart;
        int count = 0;
        do {
            count++;
            restart = Bridgemove(bridges, bridgeGame);
        } while (restart);
        outputView.printResult(bridgeGame, success(bridgeGame), count);

    }

    public String success(BridgeGame bridgeGame) {
        if (bridgeGame.getResult().contains(List.of(Bridgelocation.UPX, Bridgelocation.DOWNX))) {
            return "실패";
        }
        return "성공";
    }


    public Boolean Bridgemove(List<String> bridges, BridgeGame bridgeGame) {
        for (String bridge : bridges) {
            String userinput = inputView.readMoving();
            bridgeGame.move(userinput, bridge);
            outputView.printMap(bridgeGame.upline(), bridgeGame.downline());
            if (!Utility.StringEquals(userinput, bridge)) {
                return bridgeGame.retry(inputView.readGameCommand());
            }
        }
        return false;
    }

}
