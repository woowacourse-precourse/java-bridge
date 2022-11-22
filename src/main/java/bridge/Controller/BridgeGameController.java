package bridge.Controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.Model.BridgeGame;
import bridge.Model.BridgeMaker;
import bridge.User;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;

import static bridge.Constant.Constant.START_BRIDGE_GAME;
import static bridge.Model.BridgeGame.*;

public class BridgeGameController {

    public static boolean end = true;
    public static int count = 0;
    /**
    public void play(){
        outputView.startGameMessage();
        List<String> bridge = createBridge(inputView.readBridgeSize());
        BridgeGame bridgeGame = new BridgeGame(bridge);

        startGame(bridgeGame);
        outputView.printResult(bridgeGame.getTopResult(), bridgeGame.getBottomResult(), bridgeGame.successOrFailure(), bridgeGame.getTotalPlayCnt());
    }
     **/
    public void gameStart() {
        System.out.println(START_BRIDGE_GAME);
        int bridgeLength = User.BridgeSize();
        List<String> bridge = createBridge(bridgeLength);
        while (end) {
            gamePlay(bridge);
        }
    }

    public static void gamePlay(List<String> bridge) {
        OutputView outputView = new OutputView();
        outputView.printAnswer(bridge);

        boolean success = move(bridge);
        count++;
        if (success) {
            outputView.printResult(Result, success);
            end = false;
        } else {
            retry();
        }
    }

    private List<String> createBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(size);
    }
}
