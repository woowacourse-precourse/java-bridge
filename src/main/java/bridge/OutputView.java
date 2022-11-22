package bridge;

import java.util.List;
import java.util.Stack;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
//    private final BridgeGame bridgeGame = new BridgeGame();

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int playerLocate, String moving) {
        oneBridge(playerLocate, moving);
        oneBridge(playerLocate, moving);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int playerLocate, String moving, int count) {
        System.out.println(GameMessage.RESULT_MESSAGE);
        printMap(playerLocate, moving);
        System.out.println(GameMessage.SUCCESS_MESSAGE );
        System.out.println(GameMessage.TRYCOUNT_MESSAGE + count);
    }

    public void oneBridge(int playerLocate, String moving){
        System.out.print("[ ");
        for (int i = 0; i <= playerLocate; i++) {
            if(i != 0) {
                System.out.print(" | ");
            }
            System.out.print(equalCheck(playerLocate, moving));
        }
        System.out.println(" ]");
    }

    public String equalCheck(int playerLocate, String moving){
        String result = " ";
        if (moving.equals(BridgeGame.getBridge().get(playerLocate))){
            result = "O";
        }
//        if (!moving.equals(BridgeGame.getBridge().get(playerLocate))){
//            result = "X";
//        }
        return result;
    }

}
