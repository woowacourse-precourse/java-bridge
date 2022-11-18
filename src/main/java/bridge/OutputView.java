package bridge;

import java.util.List;

import static bridge.Application.myBridge;
import static bridge.Application.resultMap;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static String printMap(String[][] map) {
        resultMap = map;
        System.out.print("[");
        for(int i = 0; i < map[0].length; i++){
            if(i != 0 && i != map[0].length - 1) System.out.print("|");
            System.out.print(" " + map[0][i] + " ");
        }
        System.out.println(" ]");
        System.out.print("[");
        for(int i = 0; i < map[1].length; i++){
            if(i != 0 && i != map[1].length - 1) System.out.print("|");
            System.out.print(" " + map[1][i] + " ");
        }
        System.out.println(" ]");
        if(BridgeGame.isExit){
            String exitCommend = InputView.readGameCommand();
            if(exitCommend.equals("R")){
                myBridge.clear();
                return "R";
            }
            if(exitCommend.equals("Q")){
                return "Q";
            }
        }
        return "K";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult() {
        System.out.println("최종 게임 결과");
        System.out.print("[");
        for(int i = 0; i < resultMap[0].length; i++){
            if(i != 0 && i != resultMap[0].length - 1) System.out.print("|");
            System.out.print(" " + resultMap[0][i] + " ");
        }
        System.out.println(" ]");
        System.out.print("[");
        for(int i = 0; i < resultMap[1].length; i++){
            if(i != 0 && i != resultMap[1].length - 1) System.out.print("|");
            System.out.print(" " + resultMap[1][i] + " ");
        }
        System.out.println(" ]");
    }
}
