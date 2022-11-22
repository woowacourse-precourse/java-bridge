package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private static final String END_MESSAGE = "최종 게임 결과";
    private static final String GAME_SUCCESS_MESSAGE = "게임 성공 여부: ";
    private static final String GAME_COUNT_MESSAGE = "총 시도한 횟수: ";

    /**
     * 게임 시작 문구를 출력한다.
     */
    public void printStart() {
        System.out.println(START_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> result, List<String> bridge) {
        String upBridge = "[ ";
        String downBridge = "[ ";
        for (int resultIndex = 0; resultIndex < result.size(); resultIndex++) {
            upBridge += Compute.computeUpBridge(result.get(resultIndex), bridge.get(resultIndex));
            downBridge += Compute.computeDownBridge(result.get(resultIndex), bridge.get(resultIndex));
            upBridge = addBridge(resultIndex, result.size(), upBridge);
            downBridge = addBridge(resultIndex, result.size(), downBridge);
        }
        System.out.println(upBridge);
        System.out.println(downBridge);
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> result, List<String> bridge, int count) {
        System.out.println(END_MESSAGE);
        printMap(result, bridge);
        System.out.println(GAME_SUCCESS_MESSAGE + printSuccessOrFail(!result.contains("X")));
        System.out.println(GAME_COUNT_MESSAGE + count);
    }

    public String addBridge(int index, int size, String bridge) {
        if (index + 1 == size) {
            bridge += "]";
        }
        if (index + 1 != size) {
            bridge += "| ";
        }

        return bridge;
    }

    private String printSuccessOrFail(boolean isSuccess) {
        if (isSuccess) {
            return "성공";
        }
            return "실패";
    }
}
