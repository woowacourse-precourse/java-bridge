package bridge;

import static bridge.BridgeGame.*;

import java.util.List;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private static final BridgeGame bridgeGame = new BridgeGame();
    private static int bridgesize;
    private static List<String> bridge;

    public static void main(String[] args) {
        startGame();
        preceedGame();
        outputView.printResult(userMove,bridge,count);
    }

    public static void startGame(){
        outputView.printGameStartMessage();
        bridgesize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgesize);
    }

    public static void preceedGame(){
        while(userMove.size()<bridgesize && gameQuiter.equals("R")){
            outputView.printSelectMessage();
            bridgeGame.move(inputView.readMoving());

            String printedMessage = outputView.printMap(userMove,bridge);
            determineRetry(printedMessage);
        }
    }

    public static void determineRetry(String printedMessage){
        if(printedMessage.contains("X")){
            outputView.printRestartMessage();
            bridgeGame.retry(inputView.readGameCommand());
        }
    }

}
