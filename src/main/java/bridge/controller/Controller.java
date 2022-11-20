package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Command;
import bridge.service.BridgeGame;
import bridge.validator.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private BridgeGame bridgeGame;

    public void run(){
        startGame();
        playGame();
        showGameResult();
    }

    public void startGame(){
        outputView.printStartGame();
        BridgeNumberGenerator bridgeNumberGenerator= new BridgeRandomNumberGenerator();
        initBridgeGame(bridgeNumberGenerator);
    }

    private void initBridgeGame(BridgeNumberGenerator generator){
        try{
            bridgeGame = new BridgeGame(generator, inputView.readBridgeSize());
        } catch (IllegalArgumentException error){
            outputView.printBridgeSizeInputError();
            initBridgeGame(generator);
        }
    }

    public void playGame(){
        movePlayer();
        showRoundResult();
        continueOrFinishGame();
    }

    private void movePlayer(){
        try{
            bridgeGame.move(inputView.readMoving());
        } catch (IllegalArgumentException error){
            outputView.printPlayerMoveInputError();
            movePlayer();
        }
    }

    private void showRoundResult(){
        outputView.printMap(bridgeGame.getRoundResult(), Command.MOVE_UP);
        outputView.printMap(bridgeGame.getRoundResult(), Command.MOVE_DOWN);
    }

    private void continueOrFinishGame(){
        if(bridgeGame.isGameCompleted()) {
            return;
        }
        if(bridgeGame.isGameOver()){
            replayOrExit();
            return;
        }
        playGame();
    }

    private void replayOrExit(){
        String command = getRetryOrQuitCommand();
        if(command.equals(Command.RETRY_GAME.getValue())){
            bridgeGame.retry();
            playGame();
        }
    }

    private String getRetryOrQuitCommand(){
        String command;
        try{
            command = inputView.readGameCommand();
            Validator.validateIsStringCommand(command, Command.RETRY_GAME, Command.QUIT_GAME);
        } catch (IllegalArgumentException error) {
            outputView.printRetryOrQuitInputError();
            return getRetryOrQuitCommand();
        }
        return command;
    }

    public void showGameResult(){
        outputView.printResultHeader();
        showRoundResult();
        outputView.printResult(bridgeGame);
    }
}