package bridge.controller;

import static bridge.controller.InputController.getBridgeSize;
import static bridge.model.FinalResult.isFinalSuccess;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public void play() {

        outputView.printStartGame();

        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        // 다리 길이 입력해 다리 만들기
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(getBridgeSize()));

        // 다리 게임
        BridgeGame bridgegame = new BridgeGame(bridge);
        bridgegame.move();

        // 성공, 실패 여부가 결정
        System.out.println(isFinalSuccess());
        if(isFinalSuccess()) {
            outputView.printResult();
        }


    }

}
