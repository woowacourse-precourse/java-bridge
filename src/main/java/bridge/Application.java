package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        PrintCommand printCommand= new PrintCommand();
        BridgeGame game = new BridgeGame();
        InputView input = new InputView();
        BridgeNumberGenerator numGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker= new BridgeMaker(numGenerator);

        printCommand.gameStart();
        int bridgeLength=input.readBridgeSize();
        List<String> bridgeRoute = bridgeMaker.makeBridge(bridgeLength);
        game.bridgeRoute=bridgeRoute;
        game.trialCount+=1;

        for(int loop=0;loop<bridgeLength;loop++){
            if(!game.move(input.readMoving())){
                game.retry();
            };
        }

    }

}
