package bridge;

import java.util.List;

public class Application {
    private static BridgeGame bridgeGame = new BridgeGame();
    private static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private static BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private static OutputView outputView = new OutputView();
    private static InputView inputView = new InputView();
    private static User user = new User();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        outputView.startGame();
        int size = inputView.readBridgeSize();
        if(size == -1){
            System.exit(0);
        }
        List<String> bridge = bridgeMaker.makeBridge(size);
        user.addUserAttempt();
        while(true){
            String direction = inputView.readMoving();
            boolean checkDirection = progressGame(direction, bridge);
            if(checkDirection){
                if(gameIsOverByWinning(user, direction, size, bridge) == true) break;
            }else{
                if(inputView.readGameCommand() == "R") {
                    user.addUserAttempt();
                    bridgeGame.retry(user);
                }else{
                    outputView.printResult(user, direction, false, bridge, false);
                    break;
                }
            }
        }
    }

    public static boolean progressGame(String direction, List<String> bridge){
        bridgeGame.move(user);
        boolean checkDirection = bridgeGame.checkBridgeValueInUserPosition(user, direction, bridge);
        outputView.printMap(user.getUserPosition(), direction, checkDirection, bridge);

        return checkDirection;
    }

    public static boolean gameIsOverByWinning(User user, String direction, int size, List<String> bridge){
        if(bridgeGame.checkGameIsOver(user, direction, size, bridge)){
            outputView.printResult(user, direction, true, bridge, true);
            return true;
        }
        return false;
    }
}
