package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;
    private BridgeMaker bridgeMaker;
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator;

    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridgeGame = new BridgeGame(inputView.readBridgeSize(), bridgeMaker);
    }


    public void start() {
        while (true) {
            String movingCommand = inputView.readMoving();
            String sign = bridgeGame.move(movingCommand);
            bridgeGame.getBridgeGameResult().addResult(movingCommand, sign);
//            System.out.println(bridgeGame.getBridgeGameResult().getUpBridge());
//            System.out.println(bridgeGame.getBridgeGameResult().getUpBridge());

            outputView.printMap(bridgeGame.getBridgeGameResult());
//            if (!bridgeGame.getBridgeGameResult().getSuccess()) {
////                restartOrQuit(inputView.readGameCommand());
//                String gameCommand = inputView.readGameCommand();
//                if (gameCommand.equals("R")) {
//                    bridgeGame.retry();
//                }
//                if (gameCommand.equals("Q")) {
//                    break;
//                }
//            }
            if (crossingBridge(sign) == false) {
                break;
            }
            if (bridgeGame.getBridge().compareLength(bridgeGame.getUser())) {
                break;
            }
        }
        outputView.printResult(bridgeGame.getBridgeGameResult(), bridgeGame);
    }

    public boolean crossingBridge(String sign) {
        if (!bridgeGame.getBridgeGameResult().getComparison(sign)) {
            String gameCommand = inputView.readGameCommand();
            if (gameCommand.equals("R")) {
                bridgeGame.retry();
                return true;
            }
            return false;
        }
        return true;
    }

//    public void restartOrQuit(String gameCommand) {
//        if (isRestart(gameCommand)) {
//            bridgeGame.retry();
//        }
//    }

    public void printResult() {
        outputView.printResult(bridgeGame.getBridgeGameResult(), bridgeGame);
    }

    public boolean isRestart(String sign) {
        return GameCommand.fromCommand(sign)
                .getRestart();
    }
}