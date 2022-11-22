package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static int failCheck = 0; // 게임 실패 시 1

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> bridge, List<String> userMoving) {
        printUpperBridge(bridge,userMoving);
        printLowerBridge(bridge,userMoving);
    }

    public static void printUpperBridge(List<String> bridge, List<String> userMoving) {
        System.out.print("[");
        for (int turn = 0 ; turn < userMoving.size(); turn++) {
            printUpperMoveResult(bridge, userMoving, turn);
            printSeparateOrEndBridge(userMoving, turn);
        }
    }

    public static void printLowerBridge(List<String> bridge, List<String> userMoving){
        System.out.print("[");
        for (int turn = 0 ; turn < userMoving.size(); turn++) {
            printLowerMoveResult(bridge, userMoving, turn);
            printSeparateOrEndBridge(userMoving, turn);
        }
    }

    public static void printUpperMoveResult(List<String> bridge, List<String> userMoving, int turn) {
        if (userMoving.get(turn).equals("U")) {
            if(userMoving.get(turn).equals(bridge.get(turn))){
                System.out.print(" O");
            }
            if (!userMoving.get(turn).equals(bridge.get(turn))) {
                System.out.print(" X");
            }
        }
        if (userMoving.get(turn).equals("D")) {
            System.out.print(" ");
        }
    }
    public static void printLowerMoveResult(List<String> bridge, List<String> userMoving, int turn) {
        if (userMoving.get(turn).equals("D")) {
            if(userMoving.get(turn).equals(bridge.get(turn))){
                System.out.print(" O");
            }
            if (!userMoving.get(turn).equals(bridge.get(turn))) {
                System.out.print(" X");
            }
        }
        if (userMoving.get(turn).equals("U")) {
            System.out.print(" ");
        }
    }
    public static void printSeparateOrEndBridge(List<String> userMoving, int turn){
        if (turn == userMoving.size()-1) {
            System.out.println(" ]");
        }
        if (turn != userMoving.size()-1) {
            System.out.print(" |");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(int success, int playCount) {
        System.out.println("최종 게임 결과");
        if (success == 0) {
            System.out.println("게임 성공 여부: 실패");
        }
        if (success == 1) {
            System.out.println("게임 성공 여부: 성공");
        }
        System.out.println("총 시도한 횟수: " + playCount);
    }
}
