package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static BridgeGame bridgeGame;
    static OutputView outputView;
    static BridgeMaker bridgeMaker;
    static InputView inputView;

    public static void define() {
        bridgeGame = new BridgeGame();
        outputView = new OutputView(bridgeGame);
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        inputView = new InputView();
    }
    public static boolean returnSuccess(int i, int size) {
        if(i == size-1) {
            return  true;
        }
        return false;
    }
    public static int wrongMove(int size) {
        if(bridgeGame.retry(inputView.readGameCommand())) {
            return -1;
        }
        return size +1;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int size;
        boolean isSuccess = false;
        String userMove = null;
        List<String> bridgeInfo = new ArrayList<>();

        define();
        size = inputView.readBridgeSize();
        bridgeInfo = bridgeMaker.makeBridge(size);

        //dogame
        for(int i = 0; i < size; i++){

            userMove = inputView.readMoving();
            outputView.printMap(bridgeInfo, i, userMove);

            if(bridgeGame.move(bridgeInfo, userMove, i)) {
                isSuccess = returnSuccess(i, size);
                continue;
            }
            if(!bridgeGame.move(bridgeInfo, userMove, i)) {
                i = wrongMove(size);
            }
        }
        //isSuccess = doGame();
        outputView.printResult(isSuccess, bridgeInfo, size-1, userMove, bridgeGame);
    }

}
