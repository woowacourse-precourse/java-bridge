package bridge;

import bridge.view.InputConsole;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameLogic {
    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;
    GameLogic(){
        bridgeGame = new BridgeGame();
        inputView =new InputView(new InputConsole());

    }
    public void start(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        int input = inputView.readBridgeSize();
        bridgeGame.inputBridgeSize(input);
        outputView = new OutputView(bridgeGame.getBridge().getBridgeList());
        changeLine();
        playOneGame();
    }
    private void playOneGame(){
        String inputMove = inputView.readMoving();
        bridgeGame.move(inputMove);
        changeLine();
        outputView.printMap(bridgeGame.getUser().getResult(),bridgeGame.getUser().getPosition());
        changeLine();
        checkEnd();
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
        String inputRetry = inputView.readGameCommand();
        bridgeGame.retry(inputRetry);
        if(bridgeGame.getRetryInput()){
            playOneGame();
            return;
        }
        showResult();
    }
    private void showResult(){

    }
    private void changeLine(){
        System.out.println();
    }
}
