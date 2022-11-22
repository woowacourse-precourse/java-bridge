package bridge;

import java.util.ArrayList;
import java.util.List;



public class Application {
    public static List<String> bridge = new ArrayList<>();
    public static String move;
    public static boolean goOrStop = true;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        inputView.readBridgeSize();
        if(inputView.bridgesize_len>2) {
            BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
            BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
            bridge = bridgeMaker.makeBridge(inputView.bridgesize_len);
            BridgeGame bridgeGame = new bridge.BridgeGame(inputView.bridgesize_len);
            System.out.println(goOrStop);
            while(goOrStop) {
                move = inputView.readMoving();
                bridgeGame.move(move);
            }
        }



    }
}
