package bridge.controller;

import static bridge.controller.InputController.getBridgeSize;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.Diagram;
import bridge.model.FinalResult;
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
        Diagram diagram = new Diagram();
        FinalResult finalResult = new FinalResult();

        // 다리 게임
        BridgeGame bridgegame = new BridgeGame(bridge, diagram, finalResult);
        bridgegame.move();

        // 성공, 실패 여부가 결정
        System.out.println(finalResult.isFinalSuccess());
        if (finalResult.isFinalSuccess()) {
            outputView.printResult(diagram, finalResult);
        }


    }

}
