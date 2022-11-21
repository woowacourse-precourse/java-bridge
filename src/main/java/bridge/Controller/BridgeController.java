package bridge.Controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.InputView;
import bridge.OutputView;

public class BridgeController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();


    public void start(){
        GameStartMessage();
        GameTest();
    }

    public void GameStartMessage(){
        OutputView.printGameStart();
    }

    public void GameTest(){
        BridgeGame bridgeGame = createBridgeGame(inputView);
        inputMoving(inputView,outputView,bridgeGame);
    }
    private static BridgeGame createBridgeGame(InputView inputView) {
        return new BridgeGame(new BridgeMaker(new BridgeRandomNumberGenerator())
                .makeBridge(inputView.readBridgeSize()));
    }

    private static void inputMoving(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        if (bridgeGame.move(inputView.readMoving())) {
            System.out.println(outputView.printMap(bridgeGame.currentBridge()));
        }else{
            System.out.println(outputView.printMap(bridgeGame.currentBridge()));
        }

    }
}
