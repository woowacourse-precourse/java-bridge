package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String RESULT_MESSAGE = "최종 게임 결과";
    private static final String SUCCESS_OR_FAIL = "게임 성공 여부: ";
    private static final String TRY_NUMBER = "총 시도한 횟수: ";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private static final String BRIDGE_END = "]";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> upBridge, List<String> downBridge) {
        for(int i=0; i<upBridge.size(); i++) {
            System.out.print(upBridge.get(i));
        }
        System.out.println(BRIDGE_END);
        for(int i=0; i<downBridge.size(); i++) {
            System.out.print(downBridge.get(i));
        }
        System.out.println(BRIDGE_END);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printIsSuccess(boolean isSuccess, int tryNumber) {
        System.out.print(SUCCESS_OR_FAIL);
        if(isSuccess) {
            System.out.println(SUCCESS);
            System.out.println(TRY_NUMBER + tryNumber);
            return;
        }
        System.out.println(FAIL);
        System.out.println(TRY_NUMBER + tryNumber);
    }
}
