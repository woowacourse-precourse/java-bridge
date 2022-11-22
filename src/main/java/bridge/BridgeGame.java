package bridge;

import java.util.ArrayList;

public class BridgeGame {

    private static final int LOCATION_DEFAULT_VALUE = 1;
    private static final int GAME_COUNT_DEFAULT_VALUE = 0;

    private static final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();

    public void proceed() {
        BridgeGameViewManager.linkOutputGameStartMsg();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        BridgeLength bridgeLength = new BridgeLength(InputView.readBridgeSize());
        Bridges bridges = new Bridges(bridgeMaker.makeBridges(bridgeLength));
        BridgeGameCount bridgeGameCount = new BridgeGameCount(GAME_COUNT_DEFAULT_VALUE);
        startedBridgeGame(bridges, bridgeLength, bridgeGameCount);
    }

    public void startedBridgeGame(Bridges bridges, BridgeLength bridgeLength, BridgeGameCount bridgeGameCount) {
        boolean restart = true;
        while (restart) {
            bridgeGameCount = bridgeGameCount.addCount();
            PlayerBridgeChoices playerBridgeChoices = new PlayerBridgeChoices(new ArrayList<>());
            PlayerLocation playerLocation = new PlayerLocation(LOCATION_DEFAULT_VALUE);
            while (isBridgeTotalPass(playerLocation, bridgeLength, bridgeGameCount, bridges, playerBridgeChoices)) {
                if (!move(bridges, playerBridgeChoices, playerLocation)) {
                    break;
                }
                BridgeGameViewManager.linkOutputMap(bridges, playerBridgeChoices, playerLocation);
                playerLocation = playerLocation.addLocation();
            }
            restart = retry();
        }
    }

    public boolean move(Bridges bridges, PlayerBridgeChoices playerBridgeChoices, PlayerLocation playerLocation) {
        bridges.checkBridgesOX(bridgeRandomNumberGenerator);
        PlayerBridgeChoice bridgeChoice = new PlayerBridgeChoice(InputView.readMoving());
        playerBridgeChoices.addBridgeChoice(bridgeChoice);
        return isPassBySelectBridge(bridges, bridgeChoice, playerLocation, playerBridgeChoices);
    }

    public boolean isBridgeTotalPass(PlayerLocation playerLocation, BridgeLength bridgeLength, BridgeGameCount bridgeGameCount,
                                     Bridges bridges, PlayerBridgeChoices playerBridgeChoices) {
        if (playerLocation.getLocation() > bridgeLength.getBridgeLength()) {
            BridgeGameViewManager.linkOutputResult(playerLocation, bridgeGameCount, bridges, playerBridgeChoices);
            return false;
        }
        return true;
    }

    public boolean isPassBySelectBridge(Bridges bridges, PlayerBridgeChoice bridgeChoice, PlayerLocation playerLocation,
                                        PlayerBridgeChoices playerBridgeChoices) {
        if (!bridges.checkPlayerChoiceBridge(bridgeChoice, playerLocation)) {
            BridgeGameViewManager.linkOutputMap(bridges, playerBridgeChoices, playerLocation);
            return false;
        }
        return true;
    }

    public boolean retry() {
        BridgeGameRestart bridgeGameRestart = new BridgeGameRestart(InputView.readGameCommand());
        return bridgeGameRestart.isRestart();
    }

}
