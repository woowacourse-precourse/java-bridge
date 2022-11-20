package bridge;

public class Validator {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String RANGE_MESSAGE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String UD_MESSAGE = "입력값이 잘못되었습니다. U나 D만 허용합니다.";
    private static final String RQ_MESSAGE = "입력값이 잘못되었습니다. R이나 Q만 허용합니다.";
    public void bridgeLengthRange(int bridgeLength){
        if(bridgeLength<3||bridgeLength>20){
            throw new IllegalArgumentException(ERROR_MESSAGE+RANGE_MESSAGE);
        }
    }

    public void isUpOrDown(String input){
        if(!input.equals("U")&&!input.equals("D")){
            throw new IllegalArgumentException(ERROR_MESSAGE+UD_MESSAGE);
        }
    }

    public void isRestartOrQuit(String input){
        if(!input.equals("R")&&!input.equals("Q")){
            throw new IllegalArgumentException(ERROR_MESSAGE+RQ_MESSAGE);
        }
    }
}
