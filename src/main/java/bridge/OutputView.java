package bridge;

import java.util.List;
import java.util.stream.Stream;

public class OutputView {
    private static String directionOfFirstLine = "U";
    private static String directionOfSecondLine = "D";

    public void printMap(List<String> bridge, int playerLocation, boolean isMovingAvailable) {
        printFirstLine(bridge, playerLocation, isMovingAvailable);
        printSecondLine(bridge, playerLocation, isMovingAvailable);
    }

    public void printFirstLine(List<String> bridge, int playerLocation, boolean isMovingAvailable) {
        printStartPart();
        printMiddlePart(bridge, playerLocation, directionOfFirstLine);
        printEndPart(bridge.get(playerLocation+1), isMovingAvailable, directionOfFirstLine);
    }

    public void printSecondLine(List<String> bridge, int playerLocation, boolean isMovingAvailable) {
        printStartPart();
        printMiddlePart(bridge, playerLocation, directionOfSecondLine);
        printEndPart(bridge.get(playerLocation+1), isMovingAvailable, directionOfSecondLine);
    }

    private void printStartPart() {
        System.out.print("[ ");
    }

    private void printMiddlePart(List<String> bridge, int playerLocation, String directionOfLine) {
        Stream<String> bridgeStream = bridge.stream()
                                            .limit(playerLocation + 1)
                                            .map(str -> {
                                                if (str == directionOfLine) {
                                                    return "O";
                                                }
                                                return " ";
                                            });
        bridgeStream.forEach(str -> System.out.print(str + " | "));
    }

    private void printEndPart(String bridgeNextLocation, boolean isMovingAvailable, String directionOfLine) {
       printEndPartUnderMobility(bridgeNextLocation, isMovingAvailable, directionOfLine);
       printEndPartUnderImmobility(bridgeNextLocation, isMovingAvailable, directionOfLine);
    }

    private void printEndPartUnderMobility(String bridgeNextLocation,
                                                  boolean isMovingAvailable, String directionOfLine) {
        if (isMovingAvailable) {
            if (directionOfLine.equals(bridgeNextLocation)) {
                System.out.println("O ]");
            }
            if (!directionOfLine.equals(bridgeNextLocation)) {
                System.out.println(("  ]"));
            }
        }
    }

    private void printEndPartUnderImmobility(String bridgeNextLocation,
                                           boolean isMovingAvailable, String directionOfLine) {
        if (!isMovingAvailable) {
            if (directionOfLine.equals(bridgeNextLocation)) {
                System.out.println("  ]");
            }
            if (!directionOfLine.equals(bridgeNextLocation)) {
                System.out.println(("X ]"));
            }
        }
    }

    public void printResult(List<String> bridge, int playerLocation, boolean isMovingAvailable) {
        System.out.println("\n최종 게임 결과");
        if (playerLocation == bridge.size()-1) {
            printMap(bridge, playerLocation - 1, isMovingAvailable);
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
