package bridge;

import bridge.domain.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameService {
    private BridgeGame bridgeGame;

    public BridgeGameService() {
    }

    public void init(){
        bridgeGame = makeBridgeGame();

        move();
        OutputView.printMap(bridgeGame);
    }

    public BridgeGame makeBridgeGame(){
        List<String> bridge = makeBridge();
        Player player = makePlayer();

        return new BridgeGame(bridge, player);
    }
    public List<String> makeBridge(){
        int bridgeSize = InputView.readBridgeSize();
        List<String> bridge = getBridgeMaker().makeBridge(bridgeSize);

        return bridge;
    }
    public Player makePlayer(){
        return new Player();
    }

    public boolean move(){
        String command = InputView.readMoving();
        return bridgeGame.move(command);
    }

    private BridgeMaker getBridgeMaker(){
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        return new BridgeMaker(bridgeNumberGenerator);
    }

}
