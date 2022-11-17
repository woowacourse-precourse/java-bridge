package bridge;

import java.util.List;

public class BridgeController {
    private static InputView inputView = new InputView();
    public List<String> doBridgeMake(){

        int bridgeSize = inputView.readBridgeSize();

        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        return bridgeMaker.makeBridge(bridgeSize);
    }

    public void doBridgeMove(List<String> bridgeMaker){
        String moveWay = inputView.readMoving();
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker);
        boolean isPossibleMove = bridgeGame.move(moveWay);
        printMove(isPossibleMove);
    }
    public void printMove(boolean isPossibleMove){
        OutputView outputView = new OutputView();
        outputView.printMap();
    }
}
