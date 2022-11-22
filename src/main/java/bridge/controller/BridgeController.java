package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.InputView;
import bridge.OutputView;
import bridge.enums.BridgeGameCommand;
import bridge.models.BridgeBluePrint;

/**
 * MVC 중 컨트롤러 역할을 하는 class, view와 model을 소통시킨다.
 */
public class BridgeController {

    private InputView inputView;
    private OutputView outputView;
    private BridgeGame game;

    public BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        game = makeBridgeGame();
    }

    private BridgeGame makeBridgeGame() {
        outputView.printStartStatement();
        BridgeBluePrint bluePrint = makeBridgeBluePrint();
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new BridgeGame(bluePrint, maker);
    }

    private BridgeBluePrint makeBridgeBluePrint() {
        BridgeBluePrint bluePrint = null;
        while (bluePrint == null) {
            outputView.printBridgeSizeStatement();
            bluePrint = makeBridgeBluePrintOrNull();
        }
        outputView.printEmptyLine();
        return bluePrint;
    }

    private BridgeBluePrint makeBridgeBluePrintOrNull() {
        try {
            int number = inputView.readBridgeSize();
            return new BridgeBluePrint(number);
        } catch (IllegalStateException e1) {
            outputView.printError(e1);
        } catch (IllegalArgumentException e2) {
            outputView.printError(e2);
        }
        return null;
    }

    public void retry() {
        game.retry();
    }

    public boolean move() {
        String moving = inputMoving();
        Boolean block = game.move(moving);
        outputView.printMap(game.getMap());
        return block;
    }

    private String inputMoving() {
        String moving = null;
        while (moving == null) {
            outputView.printMovingStatement();
            moving = inputMovingOrNull();
        }
        return moving;
    }

    private String inputMovingOrNull() {
        try {
            return inputView.readMoving();
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
        }
        return null;
    }

    public boolean command() {
        if (game.isSuccess()) {
            return false;
        }
        return inputGameCommand();
    }

    private boolean inputGameCommand() {
        String gameCommand = null;
        while (gameCommand == null) {
            outputView.printGameCommandStatement();
            gameCommand = getGameCommandOrNull();
        }
        return BridgeGameCommand.getBool(gameCommand);
    }

    private String getGameCommandOrNull() {
        try {
            return inputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
        }
        return null;
    }

    public void exit() {
        outputView.printResult(game.getMap(), game.isSuccess(), game.getRetryCount());
    }
}
