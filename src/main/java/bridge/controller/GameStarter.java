package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameStarter {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;


    public GameStarter(){
        inputView = new InputView();
        outputView = new OutputView();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
    }

    private void playBridgeGameOnce(){
        while (true) {
            if(!bridgeGame.move(inputView.readMoving()) || bridgeGame.isOverSuccessfully()){
                outputView.printMap(bridgeGame.createBridgePrintFormat());
                break;
            }
            outputView.printMap(bridgeGame.createBridgePrintFormat());
        }
    }

    public void run(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        while(true){
            playBridgeGameOnce();
            if(bridgeGame.isOverSuccessfully() || "Q".equals(inputView.readGameCommand())) {
                outputView.printResult(bridgeGame);
                break;
            }
            bridgeGame.retry();
        }
    }
}
