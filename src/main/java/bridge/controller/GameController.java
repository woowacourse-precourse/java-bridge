package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {
    private InputView inputView;
    private OutputView outputView;
    private BridgeMaker bridgeMaker;
    private List<String> bridge;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void start() {
        // 게임 시작

        // 다리 길이 입력받음, 다리 생성
        generateBridge();

        // U, D 입력 받으며 다리 위 이동

        // 결과 출력 및 종료
    }

    private void generateBridge() {
        try {
            outputView.printInputBridgeSize();
            int size = inputView.readBridgeSize();
            bridge = bridgeMaker.makeBridge(size);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            generateBridge();
        }
    }
}
