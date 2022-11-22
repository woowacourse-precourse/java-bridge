package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.constant.ErrorCode;
import bridge.constant.MatchConst;
import bridge.domain.Bridge;
import bridge.domain.BridgeShapeMatcher;
import bridge.domain.Player;
import bridge.ui.InputView;
import bridge.ui.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BridgeGameService {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private final BridgeGame bridgeGame = new BridgeGame(inputView);
    private Player player;
    private Bridge bridge;

    public void startBridgeGame() {
        List<String> bridgeShape = bridgeMaker.makeBridge(inputView.readBridgeSize());
        bridge = new Bridge(bridgeShape);
        List<BridgeShapeMatcher> bridgeShapeMatchers = new ArrayList<>();
        player = new Player(bridgeShapeMatchers);

        System.out.println(bridge.getBridgeSpace());

    }

    public void playLoop() {
        do {
            player.addTryNumber();
            playerMoving();
        } while (bridgeGame.retry(player));
    }

    private void playerMoving() {
        boolean isSuccess = true;
        while (!player.isSuccess() && isSuccess) {
            isSuccess = bridgeGame.move(bridge, player);
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
