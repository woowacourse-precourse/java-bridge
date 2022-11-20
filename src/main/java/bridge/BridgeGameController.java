package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeGameController {
    InputView inputView = new InputView();
    int size = inputView.readBridgeSize();
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    List<String> bridge = bridgeMaker.makeBridge(size);
    BridgeGame bridgeGame = new BridgeGame();
    OutputView outputView = new OutputView();
    List<Integer> gameResult = List.of(0, 0);

    public List<String> playBridgeGame(){
        List<String> stepResult = new ArrayList<>();
        for(int idx = 0; idx < size; idx++){
            String moving = inputView.readMoving();
            stepResult.add(moving);
            outputView.printMap(stepResult, bridge);
            if(bridgeGame.move(idx, moving, bridge)){
                break;
            }
        }
        return stepResult;
    }

    public void afterBridgeGame(){
        while(true){
            List<String> stepResult = playBridgeGame();
            List<Integer> resultStatistics = bridgeGame.retry(stepResult, bridge, gameResult);
            String gameCommand = inputView.readGameCommand();
            if(gameResult.get(0) == 1 || gameCommand.equals("Q")){
                outputView.printResult(stepResult, bridge, gameResult);
                return;
            }
        }
    }




}
