package bridge.view;

import bridge.model.MapShape;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String TOTAL_TRY_COUNT_MESSAGE = "총 시도한 횟수: ";
    private static final String PASS_OR_FAIL_MESSAGE = "게임 성공 여부: ";
    private static final String PASS_MESSAGE = "성공";
    private static final String FAIL_MESSAGE = "실패";
    private static final String FINAL_RESULT_MESSAGE = "최종 게임 결과";
    private static final String HEAD_BRACKET = "[ ";
    private static final String TAIL_BRACKET = " ]";

    private final MapShape mapShape;

    public OutputView() {
        this.mapShape = new MapShape();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String nextMove, String moveResult) {
        mapShape.addShape(nextMove, moveResult);
        printMapOfCase();
    }

    private void printMapOfCase() {
        System.out.println(HEAD_BRACKET + mapShape.convertUpperMapToString() + TAIL_BRACKET);
        System.out.println(HEAD_BRACKET + mapShape.convertLowerMapToString() + TAIL_BRACKET);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int tryCount, boolean passOrFail) {
        System.out.println(FINAL_RESULT_MESSAGE);
        printMapOfCase();
        System.out.println(PASS_OR_FAIL_MESSAGE + checkPassOrFail(passOrFail));
        System.out.println(TOTAL_TRY_COUNT_MESSAGE + tryCount);
    }

    // 실패 or 성공을 판별
    private String checkPassOrFail(boolean passOrFail) {
        if(passOrFail)
            return PASS_MESSAGE;
        return FAIL_MESSAGE;
    }
}
