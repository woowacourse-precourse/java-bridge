package bridge.model;

public class BridgeRetry {

    private final String retry;

    public BridgeRetry(String retry){
        validateRetry(retry);
        this.retry = retry;
    }

    public String getRetry(){
        return retry;
    }


    public void validateRetry(String retry){
        if(isRetryFormatCorrect(retry)){
            return;
        }
        throw new IllegalArgumentException("ERROR 재시도 문자는 R,Q 이어야만 가능합니다.");
    }

    private static boolean isRetryFormatCorrect(String retry) {
        return retry.equals("R") || retry.equals("Q");
    }
}
