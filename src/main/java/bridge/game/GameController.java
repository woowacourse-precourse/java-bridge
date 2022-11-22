package bridge.game;

import static bridge.command.enums.GameCommand.RESTART;

import bridge.command.Command;
import bridge.command.enums.GameCommand;
import bridge.result.Result;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public boolean commandTheGame() {
        try {
            return inputGameCommand();
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return commandTheGame();
        }
    }

    public void endGame(Result result, Integer gameCount) {
        outputView.printResult(result, gameCount);
    }

    private boolean determineNextGame(Command command) {
        GameCommand gameCommand = GameCommand.findGameCommand(command.getCommand());
        return gameCommand.equals(RESTART);
    }

    private boolean inputGameCommand() {
        outputView.printInputGameCommand();
        Command command = inputView.readGameCommand();
        return determineNextGame(command);
    }
}
