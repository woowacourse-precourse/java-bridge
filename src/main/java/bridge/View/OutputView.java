package bridge.View;

import bridge.Model.MapShape;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String TOTAL_TRY_COUNT = "총 시도한 횟수: ";
    private static final String PASS_OR_FAIL = "게임 성공 여부: ";
    private static final String PASS_MESSAGE = "성공";
    private static final String FAIL_MESSAGE = "실패";
    private static final String FINAL_RESULT_MESSAGE = "최종 게임 결과";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String nextMove, String moveResult) {
        MapShape.addShape(nextMove, moveResult);
        printMapOfCase();
    }

    public void printMapOfCase() {
        System.out.println("[ "+ MapShape.stringUpperMap() + " ]");
        System.out.println("[ "+ MapShape.stringLowerMap() + " ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int tryCount, boolean keepGoing) {
        System.out.println(FINAL_RESULT_MESSAGE);
        printMapOfCase();
        System.out.println(PASS_OR_FAIL + checkPassOrFail(keepGoing));
        System.out.println(TOTAL_TRY_COUNT + tryCount);
    }

    private String checkPassOrFail(boolean keepGoing) {
        if(keepGoing)
            return PASS_MESSAGE;
        return FAIL_MESSAGE;
    }
}
