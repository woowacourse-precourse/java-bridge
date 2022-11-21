package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.Results;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeSystem {


    public void run(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        int bridgeSize = inputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println(bridge);
        Results results = new Results();
        BridgeGame bridgeGame = new BridgeGame(bridge, results);
        for (int round = 0; round < bridgeSize; round++) {
            String userCommand = inputView.readMoving();
            bridgeGame.move(userCommand, round);
            outputView.printMap(results);
        }


    }

}
