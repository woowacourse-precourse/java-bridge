package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeShapeMatcher;
import bridge.domain.Player;
import bridge.ui.InputView;
import bridge.ui.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameService {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private final BridgeGame bridgeGame = new BridgeGame();
    private Player player;
    private Bridge bridge;

    public void startBridgeGame() {
        List<String> bridgeShape = bridgeMaker.makeBridge(inputView.readBridgeSize());
        bridge = new Bridge(bridgeShape);
        List<BridgeShapeMatcher> bridgeShapeMatchers = new ArrayList<>();
        player = new Player(bridgeShapeMatchers);

    }

    public void playLoop() {
        String gameCommand = null;
        do {
            player.addTryNumber();
            playerMoving();
            if(!player.isSuccess()){
                gameCommand = inputView.readGameCommand();
            }
        } while (bridgeGame.retry(player,gameCommand));
    }

    private void playerMoving() {
        boolean isSuccess = true;
        while (!player.isSuccess() && isSuccess) {
            String input = inputView.readMoving();
            isSuccess = bridgeGame.move(input,bridge, player);
            outputView.printMap(player);
            if (bridge.getBridgeSpace().size() == player.getBridgeShapeMatcher().size()) {
                player.success();
            }
        }
    }

    public void printResult() {
        outputView.printResult(player);
    }


}
