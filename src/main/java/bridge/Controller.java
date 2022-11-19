package bridge;

import java.util.List;

public class Controller {
    private BridgeGame bridgeGame;
    private OutputView outputView;
    private static int tryNumber=1;
    public static List<String> answerBridge;

    public void run(){
        System.out.println(MessageView.START_GAME_MESSAGE);
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        answerBridge = bridgeMaker.makeBridge(getBridgeSize());
        boolean isSuccess = moveBridgeController();
        printBridgeResult(isSuccess,tryNumber);
    }

    private int getBridgeSize(){
        InputView inputView = new InputView();
        int result=0;
        System.out.println(MessageView.PRINT_BRIDGE_INPUT_MESSAGE);
        while(true) {
            try {
                result = inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            return result;
        }
    }

    private boolean moveBridgeController(){
        InputView inputView = new InputView();
        boolean isSuccess;
        while(isSuccess = !moveBridge()){
            if(!moveBridgeError(inputView))
                break;
            tryNumber++;
        }
        return isSuccess;
    }
    private boolean moveBridgeError(InputView inputView){
        while(true) {
            System.out.println(MessageView.PRINT_GAME_RESTART_MESSAGE);
            try {
                if (!bridgeGame.retry(inputView.readGameCommand()))
                    return false;
                return true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
    }

    private boolean moveBridge(){
        InputView inputView = new InputView();
        bridgeGame = new BridgeGame();
        outputView = new OutputView();
        int addNumber=0;
        while(addNumber++ !=answerBridge.size()) {
            if(moveBridgePrint(inputView)==true)
                continue;
            return false;
        }
        return true;
    }

    private boolean moveBridgePrint(InputView inputView){
        while(true) {
            try {
                System.out.println(MessageView.PRINT_BRIDGE_MOVE_MESSAGE);
                if (bridgeGame.move(inputView.readMoving())) {
                    outputView.printMap(bridgeGame.upBridge, bridgeGame.downBridge);
                    return true;
                }
                outputView.printMap(bridgeGame.upBridge,bridgeGame.downBridge);
                return false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
    }

    private void printBridgeResult(boolean isSuccess,int tryNumber){
        System.out.println(MessageView.PRINT_GAME_RESULT);
        outputView.printMap(bridgeGame.upBridge,bridgeGame.downBridge);
        outputView.printResult(isSuccess,tryNumber);
    }
}
