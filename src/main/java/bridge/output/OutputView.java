package bridge.output;


import bridge.constants.Command;
import java.util.HashMap;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(HashMap<String, StringBuilder> bridgeConnection) {
        System.out.println(bridgeConnection.get(Command.UP.getCommand()));
        System.out.println(bridgeConnection.get(Command.DOWN.getCommand()));
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(HashMap<String, StringBuilder> bridgeState, int count, boolean success) {
        System.out.println("최종 게임 결과");
        System.out.println(bridgeState.get(Command.UP.getCommand()));
        System.out.println(bridgeState.get(Command.DOWN.getCommand()));

        System.out.println();

        if (success == true) {
            System.out.println("게임 성공 여부: 성공");
        }

        if (success == false) {
            System.out.println("게임 성공 여부: 실패");
        }

        System.out.println("총 시도한 횟수: " + count);
    }
}


