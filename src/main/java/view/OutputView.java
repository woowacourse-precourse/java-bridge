package view;

import bridge.Bridge;
import bridge.BridgeGame;

import java.util.List;
import java.util.Objects;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    static final String IS_CLEAR = "게임 성공 여부 : ";
    static final String TOTAL_NUMBER_ATTEMPTS  = "총 시도한 횟수: ";
    static final String UP = "U";
    static final String DOWN = "D";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(BridgeGame bridgeGame) {
        List<String> movingPosition = bridgeGame.getMovingPositions();
        List<String> result = bridgeGame.getResult();
        printTopBridge(movingPosition, result, UP);
        printTopBridge(movingPosition, result, DOWN);
        System.out.println();
    }

    private static void printTopBridge(List<String> movingPosition, List<String> result, String POSITION) {
        for(int i = 0; i< result.size(); i++){
            if(i == 0){
                System.out.print("[");
            }
            if(Objects.equals(movingPosition.get(i), POSITION)){
                System.out.print(" " + result.get(i) + " ");
            }
            if(!Objects.equals(movingPosition.get(i), POSITION)){
                System.out.print(" " + " " + " ");
            }
            if(i != result.size()-1){
                System.out.print("|");
            }
            if(i == result.size()-1){
                System.out.println("]");
            }
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(BridgeGame bridgeGame) {
        System.out.print(IS_CLEAR);
        if(bridgeGame.isFailure()){
            System.out.println("실패");
        }
        if(!bridgeGame.isFailure()){
            System.out.println("성공");
        }
        System.out.println(TOTAL_NUMBER_ATTEMPTS + bridgeGame.getCount());
    }
}
