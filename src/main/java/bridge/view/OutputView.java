package bridge.view;

import bridge.vo.GameProgressMessage;

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
    public void printMap(List<StringBuilder> currentBridge) {
        final int UP_INDEX = 1;
        final int DOWN_INDEX = 0;

        System.out.println(currentBridge.get(UP_INDEX));
        System.out.println(currentBridge.get(DOWN_INDEX));
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<StringBuilder> currentBridge, long count, String endResult) {
        System.out.println(GameProgressMessage.FINAL_RESULT_MESSAGE);
        printMap(currentBridge);
        System.out.println(GameProgressMessage.SUCCESS_OR_NOT_MESSAGE + endResult);
        System.out.print(GameProgressMessage.TOTAL_TRY_COUNT_MESSAGE + String.valueOf(count));
    }

    public void printGameProgressMessage(GameProgressMessage gameProgressMessage) {
        System.out.println(gameProgressMessage);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printSpace() {
        System.out.println();
    }
}
