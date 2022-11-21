package bridge;

import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;

public class Application {
    public static List<String> bridge;
    public static boolean success;
    public static int currentLocation;
    public static int tryCount;
    public static int bridgeSize;
    public static InputView inputView = new InputView();
    public static OutputView outputView = new OutputView();
    public static BridgeGame bridgeGame = new BridgeGame();

    public static void playGame(){
        String inputMove;
        String correctMove;
        String gameCommand;

        while(currentLocation < bridgeSize){
            inputMove = inputView.readMoving();
            correctMove = bridge.get(currentLocation);
            success = bridgeGame.move(inputMove, correctMove);
            currentLocation += 1;
            outputView.printMap();
            if(success){
                continue;
            }
            gameCommand = inputView.readGameCommand();
            if(gameCommand.equals("Q")) {
                success = false;
                break;
            }
            success = true;
            bridgeGame.retry();
        }
        outputView.printResult();

    }
    public static void execute(){
        bridgeSize = inputView.readBridgeSize();

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridge = bridgeMaker.makeBridge(bridgeSize);

        currentLocation = 0;
        tryCount = 1;
        success = true;

        playGame();
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            execute();
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] " + e);
        }

    }
}
