package bridge.contoller;

import bridge.model.BridgeGame;
import bridge.validator.ValueValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final ValueValidator validator = new ValueValidator();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();
    private boolean isContinued = true;

    public void play(){
        initializeGame();
        for(int i = 0; i < bridgeGame.getBridge().getSize(); i++){
            playRound();
            if(bridgeGame.isGameFail()){
                askRetryOrQuit();
                break;
            }
            goNextRound();
        }
        finish();
    }

    public boolean isContinued(){
        return isContinued;
    }

    private void initializeGame(){
        if(bridgeGame.getTryCount() == 0){
            outputView.printGameStart();
            createBridge();
        }
        if(bridgeGame.getTryCount() > 0){
            bridgeGame.retry();
        }
        bridgeGame.updateTryCount();
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

    private void askRetryOrQuit(){
        try{
            outputView.printChooseGameCommand();
            String input = inputView.readGameCommand();
            validator.validateRetryOrQuit(input);
            checkQuit(input);
        }catch(IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            askRetryOrQuit();
        }
    }

    private void checkQuit(String command){
        if(command.equals("Q")){
            isContinued = false;
        }
    }

    private void finish(){
        bridgeGame.checkGameSuccess();
        if(bridgeGame.isGameSuccess()){
            outputView.printResult(bridgeGame);
            isContinued = false;
        }
        if(bridgeGame.isGameFail() && !isContinued){
            outputView.printResult(bridgeGame);
        }
    }
}
