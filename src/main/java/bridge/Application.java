package bridge;

import java.util.List;

public class Application {

    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();
    static BridgeGame bridgeGame = new BridgeGame();
    static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        outputView.printGameStartMessage();
        int brideSize = inputView.readBridgeSize();
        List<String> answerBridge = bridgeMaker.makeBridge(brideSize);
        do {
            String userRemoveCommand = inputView.readMoving();
            boolean gameChecked = bridgeGame.move(answerBridge,userRemoveCommand);
            outputView.printMap(bridgeGame.upBridge);
            outputView.printMap(bridgeGame.downBridge);
            if(!gameChecked){
                String userGameCommand = inputView.readGameCommand();
                if (userGameCommand.equals("Q")){
                    break;
                }
                bridgeGame.retry();
            }
        }while (!bridgeGame.compareMoveCount(brideSize));
        outputView.printResult(bridgeGame.upBridge,bridgeGame.downBridge,
                bridgeGame.gameCount, bridgeGame.gameStatus);
    }
}
