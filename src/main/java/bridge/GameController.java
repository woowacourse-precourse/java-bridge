package bridge;

import java.util.List;

public class GameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeGame bridgeGame;
    MapMaker mapMaker = new MapMaker();
    boolean hasMoved;
    boolean hasRetried;
    boolean hasWin;

    public void start() {
        outputView.printStartNotice();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        outputView.printBridgeSizeInputNotice();
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(bridgeSize));
    }

    public void play() {
        do {
            outputView.printMovingDirectionInputNotice();
            String moving = inputView.readMoving();
            hasMoved = bridgeGame.move(moving);
            outputView.printMap(mapMaker.makeMap(bridgeGame.getUserBridgeHistroy(), hasMoved));
            if(bridgeGame.checkWin()){
                break;
            }
        } while (hasMoved);
    }

    public void reTry() {
        outputView.printRestartOrQuitInputNotice();
        String command = inputView.readGameCommand();
        hasRetried = bridgeGame.retry(command);
    }

    public void end() {
        List<String> map = mapMaker.makeMap(bridgeGame.getUserBridgeHistroy(), hasMoved);
        outputView.printResult(map, bridgeGame.checkWin(), bridgeGame.getTryCount());
    }

    public void run() {
        start();
        do {
            play();
            if (bridgeGame.checkWin()) {
                break;
            }
            reTry();
        } while (hasRetried);
        end();
    }

}
