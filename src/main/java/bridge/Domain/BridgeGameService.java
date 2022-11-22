package bridge.Domain;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;

public class BridgeGameService {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeGame bridgeGame = new BridgeGame();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public static void bridgeGameServiceStart(){
        init();
        bridgeGameDomain();
        finish();
    }

    private static void finish() {
        outputView.printResult(bridgeGame);
    }

    private static void init(){
        outputView.printGameStartMessage();
    }

    private static void bridgeGameDomain(){
        int brideSize = inputView.readBridgeSize();
        List<String> answerBridge = bridgeMaker.makeBridge(brideSize);
        if(!gameRound(answerBridge,brideSize)){
            gameExit(answerBridge,brideSize);
        }
    }

    private static boolean gameRound(List<String> answerBridge, int brideSize){
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
    private static void gameExit(List<String> answerBridge, int brideSize){
        String userGameCommand = inputView.readGameCommand();
        if (userGameCommand.equals("R")){
            bridgeGame.retry();
            if(!gameRound(answerBridge,brideSize)){
                gameExit(answerBridge,brideSize);
            }
        }
    }
}
