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
    public static void doGame() {

    }
    public static int wrongMove(int size) {
        String command = inputView.readGameCommand();
        if(command.equals("R")) {
            return -1;
        }
        return size + 1;
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
                if(i == size-1) {
                    isSuccess = true;
                }
                continue;
            }
            if(!bridgeGame.move(bridgeInfo, userMove, i)) {
                i = wrongMove(size);
            }
        }
        outputView.printResult(isSuccess, bridgeInfo, size-1, userMove, bridgeGame);
    }

}
