package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public static int playCount = 1;
    public static int failCheck = 0; // 실패 시 failCheck = 1

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void move(List<String> bridge, List<String>userMoving) {
        while(userMoving.size() != bridge.size() && failCheck == 0){
            userMoving = InputUserMoving(userMoving);
            OutputView.printMap(bridge,userMoving);
        }
     }

     public static List<String> InputUserMoving (List<String> userMoving) {
         String userMove = InputView.readMoving();
         userMoving.add(userMove);
         return userMoving;
     }
     public static void failMove(List<String> bridge, List<String> userMoving, int turn) {
         if (!userMoving.get(turn).equals(bridge.get(turn))) {
             System.out.print(" X");
             failCheck = 1;
         }
     }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void retry(List<String> bridge, List<String> userMoving) {
        String gameCommand = InputView.readGameCommand();
        if (gameCommand.equals("R")) {
            restartGame(bridge, userMoving);
        }
    }

    public static void restartGame(List<String> bridge, List<String> userMoving) {
        failCheck = 0;
        playCount++;
        userMoving.clear();
        move(bridge,userMoving);
        gameResult(bridge, userMoving);
    }

    public static void gameResult(List<String> bridge, List<String> userMoving) {
        if (failCheck == 1) {
            BridgeGame.retry(bridge,userMoving);
        }
    }
}
