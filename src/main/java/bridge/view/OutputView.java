package bridge.view;

import bridge.model.MapShape;

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

    public void printMap(String nextMove, String moveResult) {
        mapShape.addShape(nextMove, moveResult);
        printMapOfCase();
    }

    private void printMapOfCase() {
        System.out.println(HEAD_BRACKET + mapShape.convertUpperMapToString() + TAIL_BRACKET);
        System.out.println(HEAD_BRACKET + mapShape.convertLowerMapToString() + TAIL_BRACKET);
    }

    public void printResult(int tryCount, boolean passOrFail) {
        System.out.println(FINAL_RESULT_MESSAGE);
        printMapOfCase();
        System.out.println(PASS_OR_FAIL_MESSAGE + checkPassOrFail(passOrFail));
        System.out.println(TOTAL_TRY_COUNT_MESSAGE + tryCount);
    }

    private String checkPassOrFail(boolean passOrFail) {
        if(passOrFail)
            return PASS_MESSAGE;
        return FAIL_MESSAGE;
    }
}
