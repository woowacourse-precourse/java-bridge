package bridge;

import bridge.controller.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        startGame();
        boolean moveSuccess;
        do {
            moveSuccess = isSuccessMoving();
            outputView.printMap(bridgeGame.getUser());
        } while (retryStatus(moveSuccess));

        outputView.printResult(moveSuccess,bridgeGame.getUser());
    }

    private static void startGame(){
        while(true){
            try {
                bridgeGame.initGame(inputView.readBridgeSize());
                return;
            }catch (IllegalArgumentException i){
                System.out.println(i.getMessage());
            }
        }
    }

    private static boolean isSuccessMoving(){
        while(true){
            try {
                return bridgeGame.move(inputView.readMoving());
            }catch (IllegalArgumentException i){
                System.out.println(i.getMessage());
            }
        }
    }

    private static boolean retryStatus(boolean moveSuccess){
        while(true){
            try {
                if(moveSuccess)
                    return bridgeGame.gameRetryStatus();
                if(!moveSuccess)
                    return bridgeGame.retry(inputView.readGameCommand());
            }catch (IllegalArgumentException i){
                System.out.println(i.getMessage());
            }
        }
    }
}
