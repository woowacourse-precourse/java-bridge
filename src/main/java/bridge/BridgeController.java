package bridge;

import java.util.List;

public class BridgeController {

    BridgeGame bridgeGame = new BridgeGame();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void startGame(){
        outputView.gameStart();
    }

    public List<String> bridgeMake(){
        int bridgeSize = inputView.readBridgeLen();
        return bridgeGame.makeBridge(bridgeSize);
    }

    public void playBridgeGame(List<String> bridge){
        while(bridgeGame.getSize() < bridge.size()){
            String move = inputView.readMoving();
            String oneBridge = bridgeGame.move(bridge, move, bridgeGame.getSize());
            outputView.printMap(oneBridge);
            bridgeGame.nextStep();
            if(isWrong(oneBridge)){
                bridgeGame.retry();
            }
        }
        outputView.printResult(bridge, bridgeGame);
    }

    private boolean isWrong(String bridge){
        if(bridge.contains(Variable.FAIL.getStr())){
            return true;
        }
        return false;
    }

}
