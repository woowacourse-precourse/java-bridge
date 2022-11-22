package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeGame game = new BridgeGame();

        setBridge(game);
        gamePlay(game);
        totalResult(game);
    }

    public static void setBridge(BridgeGame game){
        BridgeNumberGenerator numGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numGenerator);
        new PrintCommand().gameStart();
        game.bridgeLength = new InputView().readBridgeSize();
        game.bridgeRoute = bridgeMaker.makeBridge(game.bridgeLength);
    }

    public static void totalResult(BridgeGame game){
        OutputView output = new OutputView();
        output.printResult(game.howFar,game.bridgeRoute, game.myRoute);
        output.printSuccessOrFail(game);
        output.printTrialCount(game);
    }

    public static boolean gameMove(BridgeGame game) {
        int length=game.bridgeLength;
        Boolean isSuccess;
        for (int loop = 0; loop < length; loop++) {
            isSuccess = game.move(new InputView().readMoving(), loop);
            if (!isSuccess) return false;
        }
        return true;
    }

    public static void gamePlay(BridgeGame game) {
        while (true) {
            game.trialCount += 1;
            if (gameMove(game)) {
                game.isSuccess=true;
                break;
            }
            Boolean isQuit = game.retry(new InputView().readGameCommand());
            if (isQuit) {
                break;
            }
        }
    }
}
