package bridge;

import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;

public class Application {
    public static List<String> bridge;
    public static boolean success;
    public static int currentLocation;
    public static int tryCount;

    public static void execute(){
        InputView inputView = new InputView();
        int bridgeSize = inputView.readBridgeSize();

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridge = bridgeMaker.makeBridge(bridgeSize);

        currentLocation = 0;
        tryCount = 1;

        BridgeGame bridgeGame = new BridgeGame();
        String inputMove;
        String correctMove;
        String gameCommand;
        boolean safe;
        success = true;

        OutputView outputView = new OutputView();
        while(currentLocation < bridgeSize){
            inputMove = inputView.readMoving();
            correctMove = bridge.get(currentLocation);
            safe = bridgeGame.move(inputMove, correctMove);
            currentLocation += 1;
            outputView.printMap();
            if(safe){
                continue;
            }
            gameCommand = inputView.readGameCommand();
            if(gameCommand.equals("Q")){
                success = false;
                break;
            }
            success = true;
            tryCount += 1;
        }
        outputView.printResult();
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
