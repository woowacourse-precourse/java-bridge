package bridge;

import java.util.List;

public class BridgeGame {
    private static List<String> bridge;
    private static boolean stop;
    private static int location, countGame;

    public static void makeGame(int bridgeSize) {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        bridge = bridgeMaker.makeBridge(bridgeSize);
        location = -1;
        countGame = 1;
        stop = false;
    }

    public static void move(String selectWay) {
        if (!selectWay.equals(bridge.get(location++ + 1)))
            stop = true;
    }

    public static boolean play() {
        if (stop || location > bridge.size() - 2)
            return false;
        return true;
    }

    public static void replay() {
        stop = false;
        location = -1;
        countGame++;
    }

    public static boolean getstop() {
        return stop;
    }

    public static int getGameCount() {
        return countGame;
    }

    public static String getLocation() {
        return bridge.get(location);
    }
}
