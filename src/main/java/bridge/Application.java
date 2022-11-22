package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    static BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();
    static final boolean START = true;
    static GameState state;
    public static void main(String[] args) {
        List<String> bridge;
        int bridgeSize;
        String direction;
        bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        boolean playing = true;
        outputView.gameStart();
        while(playing){
            direction = inputView.readMoving();
            state = bridgeGame.play(direction);
            outputView.printMap(direction, bridge,state);
            if(state == GameState.WIN){
                break;
            }
            //함수처리
            if(state == GameState.FALL){
                String retry = inputView.readRetry();
                playing = bridgeGame.isRetry(retry);
                if(playing == true){
                    outputView.init();
                }
            }
        }
        outputView.printResult(state,bridgeGame.retryStack);
    }
}
