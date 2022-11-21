package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());

        int gameCount = 1;
        boolean restart = true;
        boolean game = true;

        List<String> upperLine = new ArrayList<>();
        List<String> lowerLine= new ArrayList<>();
        System.out.println(bridge);

        while (restart){

            game = true;
            int index = 0;
            BridgeGame bridgeGame = new BridgeGame(bridge);
            upperLine = bridgeGame.upperLine;
            lowerLine = bridgeGame.lowerLine;

            while (game && bridgeGame.lowerLine.size() != bridge.size()){

                game = bridgeGame.move(index, inputView.readMoving());
                index++;
                upperLine = bridgeGame.upperLine;
                lowerLine = bridgeGame.lowerLine;

                System.out.println(index);
                System.out.println(bridgeGame.upperLine);
                System.out.println(bridgeGame.lowerLine);
            }

            if (game){
                restart = false;
                break;
            }
            restart = bridgeGame.retry(inputView.readGameCommand());
            gameCount++;

        }

        outputView.printEndMessage();
        outputView.printMap(upperLine,lowerLine);
        outputView.printResult(game,gameCount);

    }
}