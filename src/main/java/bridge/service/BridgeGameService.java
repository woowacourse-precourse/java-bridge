package bridge.service;

import bridge.BridgeRandomNumberGenerator;
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
    private final BridgeGame bridgeGame = new BridgeGame(inputView, outputView);
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
        } while (isRetry());
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

    private boolean isRetry() {
        if (player.isSuccess()) return false;
        String gameCommand = inputView.readGameCommand();
        if (Objects.equals(gameCommand, "R")) {
            player.removeAllMatcher();
            return true;
        }
        if (Objects.equals(gameCommand, "Q")) {
            return false;
        }
        throw new IllegalArgumentException("[ERROR] 입력값이 잘못 됐습니다.");
    }

    public void printResult() {
        outputView.printFinalResult(player);
    }


}
