package bridge;

import bridge.view.InputConsole;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameLogic {
    private static final String RESTART = "R";
    private static final String QUIT = "Q";
    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;
    private String inputMove;
    private String inputRetry;
    GameLogic(){
        bridgeGame = new BridgeGame();
        inputView =new InputView(new InputConsole());

    }
    public void start(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        catchSizeException();
        outputView = new OutputView(bridgeGame.getBridge().getBridgeList());
        changeLine();
        playOneGame();
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
        changeLine();
        outputView.printMap(bridgeGame.getUser().getResult(),bridgeGame.getUser().getPosition(),inputMove);
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
            return;
        }
        showResult();
    }

    private void askRetry(){
        catchRetryException();
        if(inputRetry.equals(RESTART)){
            bridgeGame.retry();
            playOneGame();
            return;
        }
        showResult();
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
        outputView.printResult(bridgeGame.getUser().getResult(),bridgeGame.getUser().getCount(),this.inputMove);
    }
    private void changeLine(){
        System.out.println();
    }
}
