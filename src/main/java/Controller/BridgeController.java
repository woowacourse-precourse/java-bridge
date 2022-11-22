package Controller;

import bridge.*;

import java.util.List;

public class BridgeController {
    private InputView inputView = new InputView();
    private OutputView outView = new OutputView();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    private BridgeGame bridgeGame;
    private final int bridgeSize;
    private final List<String> bridge;
    private int numberOfMoving;

    private static final String MOVINGIMPOSSIBLE = "X";
    private static final String GAMEQUIT = "Q";
    private static final String GAMESUCCESS = "성공";
    private static final String GAMEFAILURE = "실패";

    public BridgeController() {
        outView.printStartGame();
        System.out.println();

        this.bridgeSize = inputView.readBridgeSize();
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
        this.bridgeGame = new BridgeGame(bridge);
    }

    public String playGame() {
        numberOfMoving = 1;
        while (numberOfMoving <= bridgeSize) {
            String moving = inputView.readMoving();
            String movingResult = bridgeGame.move(numberOfMoving++, moving);
            if (movingResult.equals(MOVINGIMPOSSIBLE)) {
                return Failure();
            }
        }
        bridgeGame.gameOver(GAMESUCCESS);
        return GAMEQUIT;
    }


    public String Failure() {
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals("R")) {
            bridgeGame.retry();
            return gameCommand;
        }
        bridgeGame.gameOver(GAMEFAILURE);
        return gameCommand;
    }
}



