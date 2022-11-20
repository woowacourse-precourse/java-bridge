package bridge;

import bridge.BridgeMaker.BridgeMaker;
import bridge.BridgeMaker.NumberGenerator.BridgeRandomNumberGenerator;
import bridge.UI.Input.InputView;
import bridge.UI.Output.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);

        System.out.print("다리 사이즈 : ");
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        OutputView outputView = new OutputView(bridge);

        System.out.println(bridge);

        for(int i = 0; i < bridgeSize; i++) {
            System.out.print("움직일 방향 : ");
            String move = inputView.readMoving();
            outputView.printMap(i, move);
        }

        System.out.print("재시작 여부 : ");
        inputView.readGameCommand();
    }
}
