package bridge;

public class BridgeGameViewManager { //ViewManager 입출력 담당 클래스로 바꾸기

    public static void linkOutputGameStartMsg() {
        OutputView.printGameStartMsg();
    }

    public static void linkOutputMap(Bridges bridges, PlayerBridgeChoices playerBridgeChoices,
                                     PlayerLocation playerLocation) {
        OutputView.printMap(bridges, playerBridgeChoices, playerLocation);
    }

    public static void linkOutputResult(PlayerLocation playerLocation, BridgeGameCount bridgeGameCount, Bridges bridges,
                                        PlayerBridgeChoices playerBridgeChoices) {
        OutputView.printResult(bridges, playerBridgeChoices, playerLocation, bridgeGameCount.getGameCount());
    }

}
