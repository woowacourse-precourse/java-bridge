package bridge.contoller;

import bridge.model.BridgeGame;
import bridge.validator.ValueValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private ValueValidator validator = new ValueValidator();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BridgeGame bridgeGame = new BridgeGame();
    private boolean isContinued = true;

    public void play(){
        if(bridgeGame.getTryCount() == 1){
            start();
            createBridge();
        }
        for(int i = 0; i < bridgeGame.getBridge().getSize(); i++){
            playRound();
            if(bridgeGame.isGameFail()){
                askRetryOrNot();
                break;
            }
            goNextRound();
        }
        finish();
    }

    public boolean isContinued(){
        return isContinued;
    }

    private void start(){
        outputView.printGameStart();
    }

    private void createBridge(){
        try{
            outputView.printChooseBridgeSize();
            int size = inputView.readBridgeSize();
            bridgeGame.createBridge(size);
        }catch(IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            createBridge();
        }
    }

    private void playRound(){
        try{
            outputView.printChooseMoving();
            String input = inputView.readMoving();
            bridgeGame.checkAnswerOfRound(input);
            bridgeGame.checkGameSuccess();
            outputView.printMap(bridgeGame.getBridge(), bridgeGame.getRound(), bridgeGame.getGameStatus());
        }catch(IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            playRound();
        }
    }

    private void goNextRound(){
        bridgeGame.move();
    }

    private void askRetryOrNot(){
        try{
            outputView.printChooseGameCommand();
            String input = inputView.readGameCommand();
            validator.validateRetryOrQuit(input);
            if(input.equals("R")){
                bridgeGame.retry();
            }
            if(input.equals("Q")){
                isContinued = false;
            }
        }catch(IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            askRetryOrNot();
        }
    }

    private void finish(){
        bridgeGame.checkGameSuccess();
        if(bridgeGame.isGameSuccess()){
            outputView.printResult(bridgeGame);
            isContinued = false;
        }
        if(bridgeGame.isGameFail() && isContinued == false){
            outputView.printResult(bridgeGame);
        }
    }



}
