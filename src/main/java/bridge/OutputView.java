package bridge;

import bridge.constant.State;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Result result) {
        print(result.getTop());
        print(result.getBottom());
    }
    private void print(String s) {
        System.out.println(s);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Result result) {
        System.out.println("최종 게임 결과");
        printMap(result);
        System.out.println();
        System.out.println("게임 성공 여부: "+result.getState().getMsg());
        System.out.println("총 시도한 횟수: "+result.getTime());
    }
}
