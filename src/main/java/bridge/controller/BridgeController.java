package bridge.controller;

import bridge.BridgeMaker;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void play() {
        try {
            int bridgeSize = inputView.readBridgeSize();
            List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
            BridgeGame bridgeGame = new BridgeGame(bridge);
            boolean flag = true;
            while(true) {
                String movingSpace = inputView.readMoving();
                bridgeGame.move(movingSpace);
                if(!bridgeGame.isCanCross()) {
                    outputView.printMap(bridgeGame.getPlayer(), false);
                    // 재시도 여부 입력
                    String gameCommand = inputView.readGameCommand();
                    if (gameCommand.equals("R")) {
                        bridgeGame.retry();
                    } else {
                        flag = false;
                        break;
                    }
                } else {
                    outputView.printMap(bridgeGame.getPlayer(), true);
                }

                if(bridgeGame.isGameSuccess()) {
                    bridgeGame.winGame();
                    break;
                }

            }
            outputView.printResult(bridgeGame.getPlayer(), flag);
        } catch (RuntimeException exception) {
            outputView.printError(exception);
        }
    }
}
