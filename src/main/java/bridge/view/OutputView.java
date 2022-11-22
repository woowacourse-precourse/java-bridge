package bridge.view;

import bridge.service.BridgeGame;
import bridge.util.Constants;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void printStartGame() {
        System.out.println(Constants.OUTPUT_BRIDGE_GAME_START);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(BridgeGame bridgeGame) {
        StringBuilder upperLine = printMapUpper(bridgeGame);
        StringBuilder LowerLine = printMapLower(bridgeGame);

        System.out.println(upperLine);
        System.out.println(LowerLine);
    }

    private static StringBuilder printMapUpper(BridgeGame bridgeGame) {
        StringBuilder printLine = new StringBuilder("[");
        int location = bridgeGame.getUserBridge().getBridgeLength();
        for (int index = 0; index < location - 1; index++) {
            printLine.append(printEachLocation(bridgeGame.getComputerBridge().getBridge().get(index),
                    bridgeGame.getUserBridge().getBridge().get(index), "U"));
        }
        printLine.append(printMapUpperLast(bridgeGame.getComputerBridge().getBridgeInfo(location -1),
                bridgeGame.getUserBridge().getBridgeLast()));
        return printLine;
    }

    private static StringBuilder printMapLower(BridgeGame bridgeGame) {
        StringBuilder printLine = new StringBuilder("[");
        int location = bridgeGame.getUserBridge().getBridgeLength();
        for (int index = 0; index < location - 1; index++) {
            printLine.append(printEachLocation(bridgeGame.getComputerBridge().getBridge().get(index),
                    bridgeGame.getUserBridge().getBridge().get(index), "D"));
        }
        printLine.append(printMapLowerLast(bridgeGame.getComputerBridge().getBridgeInfo(location -1),
                bridgeGame.getUserBridge().getBridgeLast()));
        return printLine;
    }



    private static String printMapUpperLast(String computerLocation, String userLocation) {
        if ((computerLocation.equals(userLocation)) &&
                (computerLocation.equals("U"))) {
            return " O ]";
        }
        if (!(computerLocation.equals(userLocation)) &&
                (userLocation.equals("U"))) {
            return " x ]";
        }
        return"   ]";
    }

    private static String printMapLowerLast(String computerLocation, String userLocation) {
        if ((computerLocation.equals(userLocation)) &&
                (computerLocation.equals("D"))) {
            return " O ]";
        }
        if (!(computerLocation.equals(userLocation)) &&
                (userLocation.equals("D"))) {
            return " x ]";
        }
        return "   ]";
    }

    private static String printEachLocation(String computerLocation, String userLocation, String location) {
        if (location.equals(computerLocation) && location.equals(userLocation)) {
            return " O |";
        }
        return "   |";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(BridgeGame bridgeGame) {
        System.out.println(Constants.OUTPUT_FINAL_RESULT);
        printMap(bridgeGame);
        System.out.println();
        printSuccess(bridgeGame.getGameClear());
        printGameCount(bridgeGame.getGameCount());
    }

    public static void printSuccess(boolean clear) {
        System.out.print(Constants.OUTPUT_BRIDGE_GAME_SUCCESS);
        if (clear) {
            System.out.println(Constants.OUTPUT_SUCCESS);
            return;
        }
        System.out.println(Constants.OUTPUT_FAIL);
    }

    public static void printGameCount(int gameCount) {
        System.out.println(Constants.OUTPUT_BRIDGE_GAME_COUNT + gameCount);
    }
}
