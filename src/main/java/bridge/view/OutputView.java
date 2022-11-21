package bridge.view;

import bridge.service.UserBridge;
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
    public static boolean printMap(UserBridge userBridge, String location) {
        printMapUpper(userBridge, location);
        printMapLower(userBridge, location);

        return (userBridge.getBridgeLast() == location);
    }

    private static void printMapUpper(UserBridge userBridge, String location) {
        System.out.print("[");
        for (int index = 0; index < userBridge.getBridgeLength() - 1; index++) {
            if (userBridge.getBridgeInfo(index) == "U") {
                System.out.print(" O |");
                continue;
            }
            System.out.print("   |");
        }
        printMapUpperLast(userBridge.getBridgeLast(), location);
    }

    private static void printMapLower(UserBridge userBridge, String location) {
        System.out.print("[");
        for (int index = 0; index < userBridge.getBridgeLength() - 1; index++) {
            if (userBridge.getBridgeInfo(index) == "D") {
                System.out.print(" O |");
                continue;
            }
            System.out.print("   |");
        }
        printMapLowerLast(userBridge.getBridgeLast(), location);
    }

    private static void printMapUpperLast(String userBridgeLast, String location) {
        if ((userBridgeLast == location) && (location == "U")) {
            System.out.println(" O ]");
            return;
        }
        if ((userBridgeLast != location) && (location == "U")) {
            System.out.println(" X ]");
            return;
        }
        System.out.print("   ]");
    }

    private static void printMapLowerLast(String userBridgeLast, String location) {
        if ((userBridgeLast == location) && (location == "D")) {
            System.out.println(" O ]");
            return;
        }
        if ((userBridgeLast != location) && (location == "D")) {
            System.out.println(" X ]");
            return;
        }
        System.out.print("   ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult() {
    }
}
