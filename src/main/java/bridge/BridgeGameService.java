package bridge;

import bridge.domain.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameService {
    private static final String RETRY_COMMAND = "R";
    private BridgeGame bridgeGame;

    public BridgeGameService() {
    }

    public void init(){
        bridgeGame = makeBridgeGame();

        startGame();

        OutputView.printResult(bridgeGame, bridgeGame.isGameSuccess());
    }

    public void startGame(){
        while (true){
            boolean crossSuccess = move();
            OutputView.printMap(bridgeGame);

            if (bridgeGame.isGameSuccess())
                break;
            if (crossSuccess)
                continue;

            if (isRetry()) {
                retry();
                continue;
            }
            return;
        }
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

    public void retry(){
        bridgeGame.retry();
    }

    public boolean isGameSuccess(){
        return bridgeGame.isGameSuccess();
    }

    public boolean isRetry(){
        String command = InputView.readGameCommand();
        return command.equals(RETRY_COMMAND);
    }

    private BridgeMaker getBridgeMaker(){
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        return new BridgeMaker(bridgeNumberGenerator);
    }

}
