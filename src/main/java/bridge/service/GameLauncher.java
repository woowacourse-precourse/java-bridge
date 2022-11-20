package bridge.service;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GameLauncher {

    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeGame bridgeGame = new BridgeGame();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();


    static List<String> str = new ArrayList<>(Arrays.asList("[]","[]"));
    static boolean PF = false;
    static int gameCount = 0;

    public void run(){
        outputView.startBridge();
        int size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);
        while(true){
            gameCount++;
            if (!doGame(bridge,size)) break;
        }
        endGame(str,PF,gameCount);
    }

    private boolean doGame(List<String> bridge, int size){
    }
    

    private void endGame(List<String> str, boolean PF, int gameCount){
    }

}
