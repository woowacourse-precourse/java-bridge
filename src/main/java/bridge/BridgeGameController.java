package bridge;

import java.util.*;

public class BridgeGameController {
    InputView inputView = new InputView();
    int size = inputView.readBridgeSize();
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    List<String> bridge = bridgeMaker.makeBridge(size);
    BridgeGame bridgeGame = new BridgeGame();
    OutputView outputView = new OutputView();
    int[] gameResult = new int[2];

    public List<String> playBridgeGame(){
        List<String> stepResult = new ArrayList<>();
        for(int idx = 0; idx < size; idx++){
            String moving = inputView.readMoving();
            stepResult.add(moving);
            outputView.printMap(stepResult, bridge);
            if(!bridgeGame.move(idx, moving, bridge)){ break; }
        }
        return stepResult;
    }

    public void controlBridgeGame(){
        while(true){
            List<String> stepResult = playBridgeGame();
            gameResult = bridgeGame.retry(stepResult, bridge, gameResult);
            if(gameResult[0] == 1){
                outputView.printResult(stepResult, bridge, gameResult);
                return;
            }
            if(inputView.readGameCommand().equals("Q")){
                outputView.printResult(stepResult, bridge, gameResult);
                return;
            }
        }
    }




}
