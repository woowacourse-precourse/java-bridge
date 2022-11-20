package bridge;

import java.util.List;

public class BridgeController {
    private static InputView inputView = new InputView();
    public BridgeGame doBridgeMake(){

        int bridgeSize = inputView.readBridgeSize();

        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridgeList = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridgeList);
        return bridgeGame;
    }

    public void doBridgeMove(BridgeGame bridgeGame){
        String moveWay = inputView.readMoving();

        BirdgeMoveType isPossibleMove = bridgeGame.move(moveWay);
        printMove(isPossibleMove);
    }
    public void printMove(BirdgeMoveType isPossibleMove){
        OutputView outputView = new OutputView();
        outputView.printMap(isPossibleMove);
    }
}
