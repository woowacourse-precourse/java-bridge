package bridge;

import bridge.model.UserDTO;
import bridge.view.InputConsole;
import bridge.view.InputView;
import bridge.view.OutputView;
import static bridge.option.Option.*;
public class GameLogic {
    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;
    private String inputMove;
    private String inputRetry;
    private UserDTO userDTO = new UserDTO();
    GameLogic(){
        bridgeGame = new BridgeGame();
        inputView =new InputView(new InputConsole());
    }
    public void start(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        changeLine();
        catchSizeException();
        outputView = new OutputView(bridgeGame.getBridge().getBridgeList());
        changeLine();
        playOneGame();
        showResult();
    }
    private void catchSizeException(){
        try{
            int input = inputView.readBridgeSize();
            bridgeGame.inputBridgeSize(input);
        }catch (IllegalArgumentException error){
            System.out.println(error);
            catchSizeException();
        }
    }
    private void playOneGame(){
        catchMoveException();
        bridgeGame.isCorrect(inputMove);
        userDTO.setUserDTO(bridgeGame.getUser());
        outputView.printMap(userDTO,inputMove);
        bridgeGame.move();
        changeLine();
        checkEnd();
    }
    private void catchMoveException(){
        try{
            this.inputMove = inputView.readMoving();
        }catch (IllegalArgumentException error){
            System.out.println(error);
            catchMoveException();
        }
    }
    private void checkEnd(){
        if(!bridgeGame.isEnd()) {
            playOneGame();
            return;
        }
        if(!bridgeGame.getUser().getResult()){
            askRetry();
        }
    }
    private void askRetry(){
        catchRetryException();
        if(inputRetry.equals(RETRY)){
            bridgeGame.retry();
            playOneGame();
        }
    }
    private void catchRetryException(){
        try{
            this.inputRetry = inputView.readGameCommand();
        }catch (IllegalArgumentException error){
            System.out.println(error);
            catchRetryException();
        }
    }
    private void showResult(){
        userDTO.setUserDTO(bridgeGame.getUser());
        outputView.printResult(userDTO,this.inputMove);
    }
    private void changeLine(){
        System.out.println();
    }
}