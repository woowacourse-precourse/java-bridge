package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(BridgeGame bridgeGame) {
        System.out.print("[ ");
        printUpFront(bridgeGame.getBridge(), bridgeGame.getLocation());
        printUpBack(bridgeGame.getBridge(), bridgeGame.getLocation(), bridgeGame.getResult());
        System.out.print("[ ");
        printDownFront(bridgeGame.getBridge(), bridgeGame.getLocation());
        printDownBack(bridgeGame.getBridge(), bridgeGame.getLocation(), bridgeGame.getResult());
    }

    private static void printUpFront(List<String> bridge, int location) {
        if (location != 0) {
            for ( int i = 0; i < location; i++) {
                if (bridge.get(i).equals("U")) {
                    System.out.print("O");
                }
                else {
                    System.out.print(" ");
                }
                System.out.print(" | ");
            }
        }
    }

    private static void printUpBack(List<String> bridge, int location, Boolean result) {
        if (bridge.get(location).equals("U")) {
            if (result) {
                System.out.println("O ]");
            }
            else {
                System.out.println("  ]");
            }
        }
        else {
            if (result) {
                System.out.println("  ]");
            }
            else {
                System.out.println("X ]");
            }
        }
    }

    private static void printDownFront(List<String> bridge, int location) {
        if (location != 0) {
            for ( int i = 0; i < location; i++) {
                if (bridge.get(i).equals("D")) {
                    System.out.print("O");
                }
                else {
                    System.out.print(" ");
                }
                System.out.print(" | ");
            }
        }
    }

    private static void printDownBack(List<String> bridge, int location, Boolean result) {
        if (bridge.get(location).equals("D")) {
            if (result) {
                System.out.println("O ]");
            }
            else {
                System.out.println("  ]");
            }
        }
        else {
            if (result) {
                System.out.println("  ]");
            }
            else {
                System.out.println("X ]");
            }
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(BridgeGame bridgeGame) {
        if (bridgeGame.getResult()) {
            System.out.println("게임 성공 여부: 성공");
        }
        else {
            System.out.println("게임 성공 여부: 실패");
        }
        System.out.println("총 시도한 횟수: " + bridgeGame.getCount());
    }
}
