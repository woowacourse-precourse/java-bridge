package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeGame game = new BridgeGame();
        int bridgeLength=game.bridgeLength;

        setBridge(game);
        gamePlay(game);
        totalResult(game);
    }

    public static void setBridge(BridgeGame game){
        PrintCommand printCommand = new PrintCommand();
        InputView input = new InputView();
        BridgeNumberGenerator numGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numGenerator);

        printCommand.gameStart();
        game.bridgeLength = input.readBridgeSize();
        game.bridgeRoute = bridgeMaker.makeBridge(game.bridgeLength);
    }
    public static void totalResult(BridgeGame game){
        OutputView output = new OutputView();
        output.printResult(game.bridgeLength,game.bridgeRoute, game.myRoute);
        output.printSuccessOrFail(game);
        output.printTrialCount(game);
    }

    public static boolean gameMove(BridgeGame game) {
        InputView input = new InputView();
        int length=game.bridgeLength;
        Boolean isSuccess;
        for (int loop = 0; loop < length; loop++) {
            isSuccess = game.move(input.readMoving(), loop);
            if (!isSuccess) {
                return false;
            }
        }
        return true;
    }

    public static void gamePlay(BridgeGame game) {
        InputView input = new InputView();
        game.trialCount += 1;
        Boolean isQuit;
        Boolean isSuccess;
        while (true) {
            isSuccess = gameMove(game);
            if (isSuccess) {
                game.isSuccess=isSuccess;
                break;
            }
            isQuit = game.retry(input.readGameCommand());
            if (isQuit) {
                break;
            }
        }
    }


}
