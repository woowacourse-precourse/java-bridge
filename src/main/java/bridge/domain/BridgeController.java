package bridge.domain;

import static bridge.option.GameCommand.RESTART;

import bridge.BridgeNumberGenerator;
import bridge.option.Command;
import bridge.option.GameCommand;
import bridge.result.Result;
import bridge.size.BridgeSize;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final BridgeService bridgeService;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeService = new BridgeService(bridgeNumberGenerator);
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void inputBridgeSize() {
        outputView.printStartGame();
        try {
            outputView.printInputBridgeSizeMessage();
            BridgeSize bridgeSize = inputView.readBridgeSize();
            bridgeService.generateBridge(bridgeSize.getSize());
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            inputBridgeSize();
        }
    }

    public Result inputPlayerMove() {
        try {
            outputView.printInputMoveMessage();
            Result result = bridgeService.insertMove(inputView.readMoving());
            outputView.printMap(result);
            return result;
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return inputPlayerMove();
        }
    }

    public boolean inputGameCommand() {
        try {
            outputView.printInputGameCommand();
            Command command = inputView.readGameCommand();
            return determineGameStatus(command);
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return inputGameCommand();
        }
    }

    public void restartGame() {
        bridgeService.clearPlayerBridge();
    }

    public void endGame(Result result, Integer gameCount) {
        outputView.printResult(result, gameCount);
    }

    private boolean determineGameStatus(Command command) {
        GameCommand gameCommand = GameCommand.findGameCommand(command.getCommand());
        return gameCommand.equals(RESTART);
    }
}
