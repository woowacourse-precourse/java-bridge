package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String bridgeState) {
        System.out.println(bridgeState);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param bridgeState
     * @param state
     * @param count
     */
    public static void printResult(String bridgeState, int state, int count) {
        System.out.println("최종 게임 결과\n" + bridgeState);
        printState(state);
        printCount(count);
    }

    private static void printCount(int count) {
        System.out.println("총 시도한 횟수: " + count);
    }

    public static void printState(int state) {
        String stateString = "성공";
        if (state == Utils.FAIL) {
            stateString = "실패";
        }
        System.out.println("게임 성공 여부: " + stateString);
    }

}
