package bridge;

import bridge.domain.Game;
import bridge.ui.InputView;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        InputView inputView = new InputView();
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        Game game = new Game(bridge, bridgeSize);
        game.start();
        }
    }

