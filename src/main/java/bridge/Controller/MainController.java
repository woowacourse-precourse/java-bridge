package bridge.Controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.Enum.CrossResult;
import bridge.Enum.GameStatus;
import bridge.Model.BridgeGame;
import bridge.Model.WrappingType.*;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private BridgeGame bridgeGame;

    public void initGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        BridgeSize bridgeSize = inputSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize.getSize());
        List<ChoiceDirection> choiceDirections = new ArrayList<>();
        List<CrossResult> crossResults = new ArrayList<>();
        bridgeGame = new BridgeGame(bridge, choiceDirections, crossResults);
    }

    private BridgeSize inputSize(){
        BridgeSize bridgeSize = null;
        do {
            try {
                bridgeSize = inputView.readBridgeSize();
            } catch(IllegalArgumentException exception){
                System.out.println("[ERROR] " + exception.getMessage());
            }
        } while(bridgeSize == null);

        return bridgeSize;
    }

    public void run() {
        GameStatus gameStatus = GameStatus.RUNNING;
        while (gameStatus.equals(GameStatus.RUNNING)) {
            ChoiceDirection choice = inputChoice();
            bridgeGame.move(choice);
            gameStatus = bridgeGame.checkGameStatus();
            outputView.printMap(bridgeGame);
            gameStatus = checkKeepRunning(gameStatus);
        }
        outputView.printResult(bridgeGame, gameStatus);
    }

    private ChoiceDirection inputChoice(){
        ChoiceDirection choice = null;
        do {
            try {
                choice = inputView.readMoving();
            } catch (IllegalArgumentException exception){
                System.out.println("[ERROR] " + exception.getMessage());
            }
        }while(choice == null);

        return choice;
    }

    private GameStatus checkKeepRunning(GameStatus gameStatus) {
        if (gameStatus.equals(GameStatus.FAIL)) {
            Command command = inputCommand();
            if (command.isQuit()) {
                //pass
            } else if (command.isRetry()) {
                bridgeGame.retry();
                gameStatus = GameStatus.RUNNING;
            }
        }
        return gameStatus;
    }

    private Command inputCommand(){
        Command command = null;
        do {
            try {
                command = inputView.readGameCommand();
            } catch (IllegalArgumentException exception){
                System.out.println("[ERROR] " + exception.getMessage());
            }
        } while(command == null);

        return command;
    }
}
