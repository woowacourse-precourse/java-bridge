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
     * @param CurrentBridgeState
     */
    public void printMap(CurrentBridgeState currentBridgeState) {

        List<String> upBridgeResult = currentBridgeState.getUpBridgeState();
        List<String> downBridgeResult = currentBridgeState.getDownBridgeState();

        if (upBridgeResult.size() == 1) {
            printOneArgument(upBridgeResult, downBridgeResult);
        } else if (upBridgeResult.size() > 1) {
            printManyArgument(upBridgeResult, downBridgeResult);
        }
    }

    private void printManyArgument(List<String> upBridgeResult, List<String> downBridgeResult) {
        System.out.print("[ " + upBridgeResult.get(0) + " ");
        for (int index = 1; index < upBridgeResult.size(); index++) {
            System.out.print("| " + upBridgeResult.get(index) + " ");
        }
        System.out.print("]\n[ " + downBridgeResult.get(0) + " ");
        for (int index = 1; index < downBridgeResult.size(); index++) {
            System.out.print("| " + downBridgeResult.get(index) + " ");
        }
        System.out.print("]\n\n");
    }

    private void printOneArgument(List<String> upBridgeResult, List<String> downBridgeResult) {
        System.out.print("[ " + upBridgeResult.get(0) + " ]\n");
        System.out.print("[ " + downBridgeResult.get(0) + " ]\n\n");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @param currentBridgeState
     */
    public void printResult(CurrentBridgeState currentBridgeState, boolean isSuccess, int tryNumber) {

        System.out.println("최종 게임 결과");
        printMap(currentBridgeState);
        System.out.print("게임 성공 여부: ");
        if (isSuccess == true) {
            System.out.println("성공");
        } else if (isSuccess == false) {
            System.out.println("실패");
        }
        System.out.println("총 시도한 횟수: " + tryNumber);
    }
}
