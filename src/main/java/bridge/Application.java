package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        InputView inputView = new InputView();
        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();
        int bridgeSize = inputView.readBridgeSize(inputView.readline());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        while (bridgeSize-- > 0){
            String readMove = inputView.readMoving(inputView.readline());
            boolean move = bridgeGame.move(bridge, readMove);
            outputView.printMap(readMove, move);
            bridgeGame.index++;
            if (!move) {
                break ;
            }
        }
        String retry = inputView.readGameCommand(inputView.readline());


    }
}
