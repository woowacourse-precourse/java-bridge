package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    static BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();
    static GameState state;
    static String direction;
    static int bridgeSize;
    static BridgeGame bridgeGame;
    static List<String> bridge;
    static boolean playing;
    public static void main(String[] args) {
        gameSetting();
        play(playing);
        outputView.printResult(state,bridgeGame.retryStack);
    }

    private static void gameSetting(){
        inputView.readBridgeSize();
        bridgeSize = inputView.getSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame = new BridgeGame(bridge);
        outputView.gameStart();
        playing  = true;
    }
    private static void play(boolean playing){
        while(playing){
            direction = inputView.readMoving();
            state = bridgeGame.play(direction);
            outputView.printMap(direction, bridge,state);
            if(state == GameState.WIN){break;}
            if(state == GameState.FALL){
                String retry = inputView.readGameCommand();
                playing = bridgeGame.isRetry(retry);
                if(playing == true){outputView.init();}
            }
        }
    }

}
