package bridge;
import java.util.List;

public class GameController {
    BridgeRandomNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    BridgeGame bridgeGame = new BridgeGame();

    public List<String> bridge (int size){
        return bridgeMaker.makeBridge(size);
    }

    public void gameStart(List<String> bridge){
        for(int i=0 ; i<bridge.size() ; i++){
            bridgeGame.move(bridge.get(i), InputView.readMoving(bridgeGame.upBridge, bridgeGame.downBridge));
            OutputView.printMap(bridgeGame.upBridge, bridgeGame.downBridge);
            if (i != bridge.size() - 1 ){ bridgeGame.midStick();}
            if (bridgeGame.upBridge.contains("X") || bridgeGame.downBridge.contains("X")) {
                i = bridgeGame.retry(bridge.size(), i, InputView.readGameCommand());
            }
        }
    }

    public void gameResult(){
        OutputView.printResult(bridgeGame.upBridge, bridgeGame.downBridge);
        OutputView.printCount(bridgeGame.gameCount());
    }

}
