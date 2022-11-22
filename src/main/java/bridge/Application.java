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
        if(!gameRound(answerBridge,brideSize)){
            gameExit(answerBridge,brideSize);
        }
        outputView.printResult(bridgeGame);
    }

    public static boolean gameRound(List<String> answerBridge, int brideSize){
        boolean gameChecked;
        do {
            String userRemoveCommand = inputView.readMoving();
            gameChecked = bridgeGame.move(answerBridge,userRemoveCommand);
            outputView.printMap(bridgeGame.getBridgeToString());
            if(!gameChecked){
                break;
            }
        }while (!bridgeGame.compareMoveCount(brideSize));
        return gameChecked;
    }

    public static void gameExit(List<String> answerBridge, int brideSize){
        String userGameCommand = inputView.readGameCommand();
        if (userGameCommand.equals("R")){
            bridgeGame.retry();
            if(!gameRound(answerBridge,brideSize)){
                gameExit(answerBridge,brideSize);
            }
        }
    }
}
