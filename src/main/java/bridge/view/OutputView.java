package bridge.view;
public class OutputView {

    private static final String TOTAL_RESULT = "최종 게임 결과";
    private static final String SUCCESS_RESULT = "게임 성공 여부: ";
    private static final String TOTAL_TRIAL = "총 시도한 횟수: ";
    private static final String SUCCESS = "성공";
    private static final String FAILURE = "실패";
    private static final String SKIP_LINE = "\n";
    private static final String PROOF_OF_FAIL = "X";

    public void printMap(String result) {
        System.out.println(result);
    }
    public void printResult(String result, int trialCount) {
        printGameStatus(result);
        printTrialCounts(trialCount);
    }

    private boolean isFail(String result){
        return result.contains(PROOF_OF_FAIL);
    }

    private void printGameStatus(String result){
        System.out.println(TOTAL_RESULT+SKIP_LINE+result+SKIP_LINE);
        System.out.println(SUCCESS_RESULT + makeResultStatement(result));
    }

    private String makeResultStatement(String result){
        if(isFail(result)) return FAILURE;
        return SUCCESS;
    }

    private void printTrialCounts(int trialCount){
        System.out.println(TOTAL_TRIAL + trialCount);
    }
}
