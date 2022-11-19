package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;


public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
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
        playGame();
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
        outputView.printMap(bridgeGame.getRoundResult(),"U");
        outputView.printMap(bridgeGame.getRoundResult(),"D");
    }
}