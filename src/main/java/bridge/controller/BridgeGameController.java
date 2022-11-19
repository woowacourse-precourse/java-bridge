package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;

public class BridgeGameController {
    private BridgeGame bridgeGame;

    public void start() {
        set();
    }

    private void set() {
        int size = Integer.parseInt(InputView.readBridgeSize());
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(size));
    }

    private void progress() {
        for(int i=0; i<bridgeGame.getBridgeSize(); i++) {
            String square = InputView.readMoving();
            if(!bridgeGame.move(i, square)) break;
            //다리 건너기 결과 출력
        }

        if(bridgeGame.getBridgeSize() != bridgeGame.getResultSize()) retry();
    }

    private void end() {
    }

    private void retry() {
    }
}
