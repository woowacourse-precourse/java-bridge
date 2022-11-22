package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.Results;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeSystem {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeSystem() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        int bridgeSize = inputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println(bridge);
        BridgeGame bridgeGame = new BridgeGame(bridge, new Results());
        play(bridgeSize, bridgeGame);
        outputView.printResult(bridgeGame);

    }

    public void play(int bridgeSize, BridgeGame bridgeGame) {
        for (int round = 0; round < bridgeSize; round++) {
            String userCommand = inputView.readMoving();
            boolean isAlive = bridgeGame.move(userCommand, round);
            outputView.printMap(bridgeGame.getResults());
            if(!isAlive){
                String gameCommand = inputView.readGameCommand();
                if(gameCommand.equals("Q")){
                    bridgeGame.setSuccessOrFail("실패");
                    return;
                }else{
                    bridgeGame.retry();
                    round = -1;
                }
            }
        }
        bridgeGame.setSuccessOrFail("성공");
    }
    /*

 */
}
