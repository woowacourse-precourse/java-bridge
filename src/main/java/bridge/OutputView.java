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
    public static void printMap(List<String> bridge, List<String> userMoving) {
        System.out.println(OutputView.upperBridge(bridge, userMoving));
        System.out.println(OutputView.lowerBridge(bridge, userMoving));
    }

    public static String upperBridge(List<String> bridge, List<String> userMoving) {
        String upperBridge = "[";
        for (int turn = 0 ; turn < userMoving.size(); turn++) {
            upperBridge = upperBridge.concat(upperMoveResult(bridge, userMoving, turn));
            upperBridge = upperBridge.concat(separateOrEndBridge(userMoving, turn));
        }
        return upperBridge;
    }

    public static String lowerBridge(List<String> bridge, List<String> userMoving){
        String lowerBridge = "[";
        for (int turn = 0 ; turn < userMoving.size(); turn++) {
            lowerBridge = lowerBridge.concat(lowerMoveResult(bridge, userMoving, turn));
            lowerBridge = lowerBridge.concat(separateOrEndBridge(userMoving, turn));
        }
        return lowerBridge;
    }

    public static String upperMoveResult(List<String> bridge, List<String> userMoving, int turn) {
        if (userMoving.get(turn).equals("U")) {
            if(userMoving.get(turn).equals(bridge.get(turn))){
                return " O";
            }
            BridgeGame.failMove(bridge, userMoving, turn);
            return " X";
        }
        return "  ";
    }
    public static String lowerMoveResult(List<String> bridge, List<String> userMoving, int turn) {
        if (userMoving.get(turn).equals("D")) {
            if(userMoving.get(turn).equals(bridge.get(turn))){
                return " O";
            }
            BridgeGame.failMove(bridge, userMoving, turn);
            return " X";
        }
        return "  ";
    }
    public static String separateOrEndBridge(List<String> userMoving, int turn){
        if (turn == userMoving.size()-1) {
            return " ]";
        }
        return " |";
    }

    public static String gameResult(int failCheck) {
        if (failCheck == 1) {
            return "게임 성공 여부: 실패";
        }
        return "게임 성공 여부: 성공";
    }

//    public static void printUpperBridge(List<String> bridge, List<String> userMoving) {
//        System.out.print("[");
//        for (int turn = 0 ; turn < userMoving.size(); turn++) {
//            printUpperMoveResult(bridge, userMoving, turn);
//            printSeparateOrEndBridge(userMoving, turn);
//        }
//    }
//
//    public static void printLowerBridge(List<String> bridge, List<String> userMoving){
//        System.out.print("[");
//        for (int turn = 0 ; turn < userMoving.size(); turn++) {
//            printLowerMoveResult(bridge, userMoving, turn);
//            printSeparateOrEndBridge(userMoving, turn);
//        }
//    }
//
//    public static void printUpperMoveResult(List<String> bridge, List<String> userMoving, int turn) {
//        if (userMoving.get(turn).equals("U")) {
//            if(userMoving.get(turn).equals(bridge.get(turn))){
//                System.out.print(" O");
//            }
//            BridgeGame.failMove(bridge, userMoving, turn);
//        }
//        if (userMoving.get(turn).equals("D")) {
//            System.out.print(" ");
//        }
//    }
//    public static void printLowerMoveResult(List<String> bridge, List<String> userMoving, int turn) {
//        if (userMoving.get(turn).equals("D")) {
//            if(userMoving.get(turn).equals(bridge.get(turn))){
//                System.out.print(" O");
//            }
//            BridgeGame.failMove(bridge, userMoving, turn);
//        }
//        if (userMoving.get(turn).equals("U")) {
//            System.out.print(" ");
//        }
//    }
//    public static void printSeparateOrEndBridge(List<String> userMoving, int turn){
//        if (turn == userMoving.size()-1) {
//            System.out.println(" ]");
//        }
//        if (turn != userMoving.size()-1) {
//            System.out.print(" |");
//        }
//    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public static void printResult(List<String> bridge, List<String> userMoving, int failCheck, int playCount) {
        System.out.println("최종 게임 결과");
        System.out.println(upperBridge(bridge,userMoving));
        System.out.println(lowerBridge(bridge,userMoving));
        System.out.println(gameResult(failCheck));
        System.out.println("총 시도한 횟수: " + playCount);
    }

    public static void printGameResult(int failCheck) {
        if (failCheck == 1) {
            System.out.println("게임 성공 여부: 실패");
        }
        if (failCheck == 0) {
            System.out.println("게임 성공 여부: 성공");
        }
    }

}
