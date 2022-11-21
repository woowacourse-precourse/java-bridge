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
        outputView.startGame();
        user.initializePosition();
        int size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);
        while(true){
            inputView.readMoving(user);
            boolean checkDirection = progressGame(user, bridge);
            if(checkDirectionToQuitGameByWinning(checkDirection, user, bridge) == true) break;
            if(checkDirectionToQuitOrRetryGameByLosing(checkDirection,user, bridge) == true) break; }
    }

    public static boolean checkDirectionToQuitGameByWinning(boolean checkDirection, User user, List<String> bridge ){
        if(checkDirection == true && gameIsOverByWinning(user, checkDirection, bridge) == true){
            return true;
        }
        return false;
    }

    public static boolean checkDirectionToQuitOrRetryGameByLosing(boolean checkDirection, User user, List<String> bridge){
        if(checkDirection == false && RetryOrQuitGame(user, checkDirection, bridge) == false){
            return true;
        }
        return false;
    }
    public static boolean progressGame(User user, List<String> bridge){
        bridgeGame.move(user);
        boolean checkDirection = bridgeGame.checkBridgeValueInUserPosition(user, bridge);
        outputView.printMap(user, checkDirection, bridge);

        return checkDirection;
    }

    public static boolean gameIsOverByWinning(User user,boolean checkDirection, List<String> bridge){
        if(bridgeGame.checkGameIsOver(user, bridge)){
            outputView.printResult(user, checkDirection, bridge);
            return true;
        }
        return false;
    }

    public static boolean RetryOrQuitGame(User user, boolean checkDirection, List<String> bridge){
        if(inputView.readGameCommand() == "R") {
            user.addAttempt();
            bridgeGame.retry(user);
            return true;
        }
        outputView.printResult(user, checkDirection, bridge);
        return false;
    }
}
