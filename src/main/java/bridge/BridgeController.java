package bridge;

import java.util.List;

public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;


    public static void main(String[] args) {
        BridgeController bridgeController = new BridgeController(new InputView(), new OutputView());
        bridgeController.startBridgeGame();
    }

    BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void startBridgeGame() {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        outputView.printStartMessage();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);

        int i = 0;
        while (i < bridgeSize) {
            String moving = inputView.readMoving();
            boolean isSuccess = bridgeGame.move(i, moving);
            outputView.printMap(bridgeGame.getResults());
            if (!isSuccess) {
                String gameCommand = inputView.readGameCommand();
                if (gameCommand.equals("Q")) {
                    System.out.println("종료");
                    break;
                }
                bridgeGame.retry();
                i = 0;
            }
            i++;
        }
        outputView.printTotalTryCount(bridgeGame.getTryCount());
        outputView.printResult(bridgeGame.getResults());
    }
}
