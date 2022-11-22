package bridge;

import java.util.List;
import java.util.stream.Stream;

public class OutputView {
    private static String targetOfFirstLine = "U";
    private static String targetOfSecondLine = "D";
    public void printMap(List<String> bridge, int playerLocation, boolean isMovingAvailable) {
        printFirstLine(bridge, playerLocation, isMovingAvailable);
        printSecondLine(bridge, playerLocation, isMovingAvailable);
    }

    public void printFirstLine(List<String> bridge, int playerLocation, boolean isMovingAvailable) {
        printStartPart();
        printMiddlePart(bridge, playerLocation, targetOfFirstLine);
        printEndPart( bridge.get(playerLocation+1), isMovingAvailable, targetOfFirstLine);
    }

    public void printSecondLine(List<String> bridge, int playerLocation, boolean isMovingAvailable) {
        printStartPart();
        printMiddlePart(bridge, playerLocation, targetOfSecondLine);
        printEndPart( bridge.get(playerLocation+1), isMovingAvailable, targetOfSecondLine);
    }

    private void printStartPart() {
        System.out.print("[ ");
    }

    private void printMiddlePart(List<String> bridge, int playerLocation, String target) {
        Stream<String> bridgeStream = bridge.stream()
                                            .limit(playerLocation + 1)
                                            .map(str -> {
                                                if (str == target) {
                                                    return "O";
                                                }
                                                return " ";
                                            });
        bridgeStream.forEach(str -> System.out.print(str + " | "));
    }

    private void printEndPart(String bridgeNextLocation, boolean isMovingAvailable, String direction) {
        if (isMovingAvailable) {
            if (direction.equals(bridgeNextLocation)) {
                System.out.println("O ]");
            }
            if (!direction.equals(bridgeNextLocation)) {
                System.out.println(("  ]"));
            }
        }
        if (!isMovingAvailable) {
            if (direction.equals(bridgeNextLocation)) {
                System.out.println("  ]");
            }
            if (!direction.equals(bridgeNextLocation)) {
                System.out.println(("X ]"));
            }
        }
    }

    public void printResult(List<String> bridge, int playerLocation, boolean isMovingAvailable) {
        System.out.println("\n최종 게임 결과");
        if (playerLocation == bridge.size()-1) {
            printMap(bridge, playerLocation-1, isMovingAvailable);
            System.out.println("게임 성공 여부: 성공");;
        }
        if (playerLocation < bridge.size()-1) {
            printMap(bridge, playerLocation, isMovingAvailable);
            System.out.println("게임 성공 여부: 실패");
        }
    }

    public void printTrialNumber(int trialNumber) {
        System.out.println("총 시도한 횟수: " + trialNumber);
    }
}
