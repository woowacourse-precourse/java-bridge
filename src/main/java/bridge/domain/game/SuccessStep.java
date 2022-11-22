package bridge.domain.game;

import com.sun.net.httpserver.Authenticator;

public enum SuccessStep {
    SUCCESS("O", true, "성공"),
    FAIL("X", false, "실패");

    private final String step;
    private final boolean status;
    private final String result;

    public String getResult() {
        return result;
    }

    SuccessStep(String step, boolean status, String result) {
        this.step = step;
        this.status = status;
        this.result = result;
    }

    public String getStep() {
        return step;
    }

    public boolean getStatus() {
        return status;
    }

    public static SuccessStep compareStep(String answer, String step){
        if (step.equals(answer)){
            return SUCCESS;
        }
        return FAIL;
    }

    public static String getResultbyStatus(boolean status){
        for (SuccessStep successStep: SuccessStep.values()){
            if (successStep.status == status){
                return successStep.getResult();
            }
        }throw new IllegalArgumentException();
        //TODO: boolean 값으로만 찾도록 오류 메세지 출력
    }


}
