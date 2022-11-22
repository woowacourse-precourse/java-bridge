package bridge.View;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String MESSAGE_PRINT_RESULT =
            "최종 게임 결과\n" +
                    "%s\n\n" +
                    "게임 성공 여부: %s\n" +
                    "총 시도한 횟수: %d\n";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * @param bridgeResult 현재까지 이동한 다리의 상태
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String bridgeResult) {
        System.out.println(bridgeResult);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * @param bridgeResult 현재까지 이동한 다리의 상태
     * @param result 성공 / 실패 여부
     * @param tries 시도 횟수
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String bridgeResult, String result, int tries) {
        System.out.printf(MESSAGE_PRINT_RESULT, bridgeResult, result, tries);
    }
}
