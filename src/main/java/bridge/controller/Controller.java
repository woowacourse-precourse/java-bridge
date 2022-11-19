package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.service.BridgeGame;
import bridge.validator.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;


public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final String UPPER_BRIDGE = "U";
    private final String DOWNER_BRIDGE = "D";
    private final String COMMAND_RETRY = "R";
    private final String COMMAND_QUIT = "Q";
    private BridgeGame bridgeGame;

    public void run(){
        startGame();
        playGame();
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
            System.out.println("[ERROR] 다리 길이는 3~20 사이의 값을 가져야 합니다. 다시 입력해 주십시오.");
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
            System.out.println("[ERROR] 이동 방향은 'U'/'D' 중 한가지로 입력되어야 합니다. 다시 입력해 주십시오.");
            movePlayer();
        }
    }

    private void showRoundResult(){
        outputView.printMap(bridgeGame.getRoundResult(),UPPER_BRIDGE);
        outputView.printMap(bridgeGame.getRoundResult(),DOWNER_BRIDGE);
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
        if( command.equals("R")){
            bridgeGame.retry();
            playGame();
        }
    }

    private String getRetryOrQuitCommand(){
        String command;
        try{
            command = inputView.readGameCommand();
            Validator.validateIsStringOneCharacter(command, COMMAND_RETRY, COMMAND_QUIT);
        } catch (IllegalArgumentException error) {
            System.out.println("[ERROR] 입력값은 'R'/'Q' 중 한가지로 입력되어야 합니다. 다시 입력해 주십시오.");
            return getRetryOrQuitCommand();
        }
        return command;
    }
}