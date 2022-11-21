package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    private BridgeGame bridgeGame;
    private List<String> bridge;
    public void startBridgeGame(){
        init();
        boolean b=true;
        do {
            bridgeGame = new BridgeGame(bridge);
            do {
                bridgeGame.move(InputView.getMoving());
                try {
                    OutputView.printMap(bridgeGame);
                }catch(IllegalArgumentException e){
                    String gameCommand=InputView.getGameCommand();
                    if(gameCommand.equals("Q")){
                        OutputView.printMap(bridgeGame);
                        b=false;
                    }
                    if(gameCommand.equals("R")){
                        break;
                    }
                }
            } while (b==true);
        }while(b==true);
    }

    public void init(){
        OutputView.printGameStart();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator=new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker=new BridgeMaker(bridgeRandomNumberGenerator);
        bridge=bridgeMaker.makeBridge(InputView.getBridgeSize());
    }
}
