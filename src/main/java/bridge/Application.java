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


    }
}
