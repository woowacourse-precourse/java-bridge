package bridge;

import java.util.List;

import static bridge.MoveType.X;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public Controller(InputView input, OutputView output, BridgeRandomNumberGenerator generator) {
        this.inputView = input;
        this.outputView = output;
        this.bridgeMaker = new BridgeMaker(generator);
    }

    public void startGame() {
        outputView.printGameStart();
        int bridgeSize = inputView.readBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(bridgeSize));
        int tryCount = 0;
        int index = 0;
        List<String> upBridge;
        List<String> downBridge;
        while (index < bridgeSize) {
            String move = inputView.readMoving();
            bridgeGame.move(move, index);
            index += 1;
            upBridge = bridgeGame.getUpBridge();
            downBridge = bridgeGame.getDownBridge();
            outputView.printMap(upBridge);
            outputView.printMap(downBridge);
        }
    }

}
