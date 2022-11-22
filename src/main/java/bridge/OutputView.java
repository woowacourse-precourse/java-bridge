package bridge;

public class OutputView {

    public static void printGameStartMsg() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    public static void printMap(Bridges bridges, PlayerBridgeChoices playerBridgeChoices, PlayerLocation playerLocation) {
        for (int i = 0; i < 2; i++) {
            System.out.print("[ ");
            printBridges(bridges, playerBridgeChoices, playerLocation, i);
            System.out.println(" ]");
        }
    }

    public static int findBridge(PlayerBridgeChoices playerBridgeChoices, int j) {
        if (playerBridgeChoices.getPlayerBridgeChoices().get(j).getPlayerBridgeChoice().equals("U")) {
            return 0;
        }
        return 1;
    }

    public static void printBridges(Bridges bridges, PlayerBridgeChoices playerBridgeChoices, PlayerLocation playerLocation, int i) {
        for (int j = 0; j < playerLocation.getLocation(); j++) {
            int num = findBridge(playerBridgeChoices, j);
            String ox = bridges.getBridgeLines().get(i).getBridgeLine().get(j);
            boolean bridgeStateX = true;
            if (num == i) {
                bridgeStateX = printBridge(ox, playerLocation, j);
            } else {
                printBridge1(playerLocation, j);
            }
            if (!bridgeStateX) {
                break;
            }
        }
    }

    public static boolean printBridge(String ox, PlayerLocation playerLocation, int j) {
        if (ox.equals("O")) {
            System.out.print("O");
            if (playerLocation.getLocation() - 1 != j) {
                System.out.print(" | ");
            }
            return true;
        }
        return printBridgePassX(playerLocation, j);
    }

    public static boolean printBridgePassX(PlayerLocation playerLocation, int j) {
        System.out.print("X");
        if (playerLocation.getLocation() - 1 != j) {
            System.out.print(" | ");
        }
        return false;
    }

    public static void printBridge1(PlayerLocation playerLocation, int j) {
        System.out.print(" ");
        if (playerLocation.getLocation() - 1 != j) {
            System.out.print(" | ");
        }
    }

    public static void printResult(Bridges bridges, PlayerBridgeChoices playerBridgeChoices,
                                   PlayerLocation playerLocation, int totalCount) {
        System.out.println("최종 게임 결과");
        printMap(bridges, playerBridgeChoices, playerLocation);
        if (totalCount >= bridges.getBridgeLines().size()) {
            System.out.println("게임 성공 여부: " + "성공");
        } else {
            System.out.println("게임 성공 여부: " + "실패");
        }
        System.out.println("총 시도한 횟수: " + totalCount);
    }

}
