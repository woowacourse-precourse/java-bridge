package bridge;

import static bridge.Constants.*;

public class Application {
    static OutputView outputView = new OutputView();
    static InputView inputView = new InputView();
    static BridgeGame bridgeGame;
    static int bridgeSize;

    static void init(){
        outputView.printInit();
        bridgeSize = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);
    }

    static int isRetry(String result, int size){
        if(result.equals(CANNOT_CROSS)){
            outputView.printRetry();
            String command = inputView.readGameCommand();
            size = bridgeGame.retry(command, bridgeSize);
        }
        return size;
    }

    public static void main(String[] args) {
        init();
        for(int size = 0; size < bridgeSize; size++) {
            outputView.printSelect();
            String moving = inputView.readMoving();
            String result = bridgeGame.move(moving, size);
            outputView.printMap(bridgeGame.getMoveResults(), size, bridgeGame.getUserMove());
            if(result.equals(CANNOT_CROSS)){
                size = isRetry(result, size);
            }
        }
        outputView.printResult(bridgeGame.getMoveResults(), bridgeGame.getUserMove(), bridgeGame.getTryCount());
    }


}
