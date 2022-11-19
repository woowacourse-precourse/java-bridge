package bridge;

import java.util.List;

public class Controller {
    private BridgeGame bridgeGame;
    public static List<String> answerBridge;
    private final OutputView outputView = new OutputView();

    public void run(){
        int tryNumber=1;
        System.out.println(MessageView.START_GAME_MESSAGE);
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        answerBridge = bridgeMaker.makeBridge(getBridgeSize());
        System.out.println(answerBridge);
        boolean tmp;
        while(tmp = !moveBridge()){
            System.out.println(MessageView.PRINT_GAME_RESTART_MESSAGE);
            if(!bridgeGame.retry())
                break;
            tryNumber++;
        }
        printBridgeResult(tmp,tryNumber);
    }

    private int getBridgeSize(){
        InputView inputView = new InputView();
        System.out.println(MessageView.PRINT_BRIDGE_INPUT_MESSAGE);
        return inputView.readBridgeSize();
    }

    private boolean moveBridge(){
        InputView inputView = new InputView();
        bridgeGame = new BridgeGame();
        int attemptMove=0;
        while(attemptMove!=answerBridge.size()) {
            attemptMove++;
            System.out.println(MessageView.PRINT_BRIDGE_MOVE_MESSAGE);
            if(bridgeGame.move(inputView.readMoving())){
                outputView.printMap(bridgeGame.upBridge,bridgeGame.downBridge);
                continue;
            }
            outputView.printMap(bridgeGame.upBridge,bridgeGame.downBridge);
            return false;
        }
        return true;
    }

    private void printBridgeResult(boolean isSuccess,int tryNumber){
        System.out.println(MessageView.PRINT_GAME_RESULT);
        outputView.printMap(bridgeGame.upBridge,bridgeGame.downBridge);
        outputView.printResult(isSuccess,tryNumber);
    }
}
