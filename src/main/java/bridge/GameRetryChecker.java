package bridge;

public class GameRetryChecker {

    private static final String NOT_ALLOW_INPUT_ERROR_MSG = "R: 재시작과 Q: 완전종료 중에 입력해 주세요";

    public boolean isRetry(String input){
        if(input.equals("R")) return true;
        if(input.equals("Q")) return false;
        throw new IllegalArgumentException(NOT_ALLOW_INPUT_ERROR_MSG);
    }
}
